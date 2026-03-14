
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.battle.simulator; // or game.battle

import java.util.Scanner;
import java.util.Random;

import game.character.holder.CharacterHolder;
import game.engine.*; //DamageCalculator and ManaCostCalculator
import static game.engine.GameUtils.pause;

import game.core.AttackTypeValidator;
import game.core.InputValidator;

import game.battle.simulator.dialogues.BattleDialogues;
import game.types.*;


public class SimulateBattle{
     SimulateManaCost simulateManaCost; 
    private final Random rand = new Random();
    private int round = 1;

    public void startBattle(CharacterHolder player, CharacterHolder enemy, Scanner scanf) {
        System.out.println("\n------------------------------------------ BATTLE START: " + player.getElementType() + " VS " + enemy.getElementType() + " ------------------------------------------");

        while (player.isAlive() && enemy.isAlive()) {
            //Mana regenerates by 10 after the round ends            
            if(round > 1){ 
                pause(1000);
                player.getMana().regenerate();  
                pause(1000);
                enemy.getMana().regenerate();

                System.out.println();
                System.out.println("Mana regenerates " + player.getRegenRate());
                System.out.println("Mana regenerates " + enemy.getRegenRate());
            }
            // 1. PLAYER TURN
            handlePlayerTurn(player, enemy, scanf);
            if (!enemy.isAlive()) break;
            // 2. ENEMY TURN
            handleEnemyTurn(enemy, player);
        }

        displayResult(player, enemy);
    }

    private void handlePlayerTurn(CharacterHolder player, CharacterHolder enemy, Scanner scanf) {
        System.out.println("\n\t\t\t\t\t[ YOUR TURN ]");
        System.out.println("HP: " + player.getCurrentHealth()+ " | Mana: " + player.getCurrentMana());
        System.out.println("Round " + round + "| 0: NORMAL (0MP) | 1: SKILL_1 (30MP) | 2: SKILL_2 (50MP) | 3: ULTIMATE (100MP)");

        //Loop to check if attack is Valid!
        int choice;

        while(true){
            choice = InputValidator.getValidAttack("Select Attack: ", scanf);
            AttackType selectedAttack = AttackTypeValidator.getAttackTypeByIndex(choice);
            
            simulateManaCost = new SimulateManaCost(choice, player, selectedAttack);//fixed            
            if(simulateManaCost.isChoiceValid(choice, player, selectedAttack)){
                player.setAttackType(selectedAttack);
                player.manaCost(simulateManaCost.getManaNeeded());
                break;    
            }else{
                System.out.println("Calm Down! You're too ambitious.");
                System.out.println("Mana Cost: " + simulateManaCost.getManaNeeded() + " | Current Mana: " + simulateManaCost.getCurrentMana()); 
            }
        }

        //player.setAttackType(AttackTypeValidator.getAttackTypeByIndex(choice));
        double dmg = DamageCalculator.calculateDamage(player, enemy, player.getAttackType());
        
        enemy.takeDamage(dmg);
        System.out.println("You used " + player.getAttackType() + "! Dealt: " + dmg);
        pause(1500);
    }

    private void handleEnemyTurn(CharacterHolder enemy, CharacterHolder player) {
        
        System.out.println("\n\t\t\t\t\t[ ENEMY TURN ]");
        System.out.println("HP: " + enemy.getCurrentHealth()+ " | Mana: " + enemy.getCurrentMana());
        for(int i = 0; i < 3; i++){
            pause(666);
            System.out.print(".");
        }
        
        // Randomly pick an attack for the enemy
        
        // 1. Initial Random Choice
    int choice = rand.nextInt(AttackType.values().length);
        AttackType enemyMove = AttackType.values()[choice];
        boolean isSweating = false;

        // 2. The Validation/Search Loop
        while (true) {
            simulateManaCost = new SimulateManaCost(choice, enemy, enemyMove);

            if (simulateManaCost.isChoiceValid(choice, enemy, enemyMove)) {
                // ACTION GRANTED: Move is affordable
                enemy.setAttackType(enemyMove);
                pause(1000);
                enemy.manaCost(simulateManaCost.getManaNeeded());
                pause(1000);
                break; // Exit the loop to deal damage
            } else {
                // ACTION DENIED: Start "Sweating" search
                if (!isSweating) {
                    System.out.println("\n" + enemy.getName() + " is Sweating!");
                    System.out.println("Reconsiders using another Skill...");
                    isSweating = true;
                }

                // Systematic Search: Lower the choice until it hits 0 (Physical Attack)
                if (choice > 0) {
                    choice--; 
                    enemyMove = AttackType.values()[choice];
                    // The loop repeats, re-checking simulateManaCost for the new choice
                } else {
                    // Safety break: If choice is already 0, something is wrong with the 
                    // mana cost of the basic attack (it should be 0).
                    break; 
                }
            }
        }

        // 3. Execution
        double dmg = DamageCalculator.calculateDamage(enemy, player, enemyMove);
        player.takeDamage(dmg);
        System.out.println("Enemy used " + enemyMove + "! Dealt: " + dmg);
        round++;
    }
    //WittyRemarks are moved to BattleDialogues.java file        
    
        private void displayResult(CharacterHolder player, CharacterHolder enemy) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("                         BATTLE END                         ");
            System.out.println("=".repeat(60));

            boolean playerWon = player.isAlive();
            // Get the witty remark based on the enemy's element and the result
            String remark = BattleDialogues.getWittyRemark(enemy.getElementType(), playerWon);

            if (playerWon) {
                System.out.println(" [!] VICTORY!");
                System.out.println(" You have triumphed over " + enemy.getName() + " (" + enemy.getElementType() + ")");
                System.out.println("\n " + player.getName() + " says: \"" + remark + "\"");
            } else {
                System.out.println(" [!] DEFEAT...");
                System.out.println(" " + enemy.getName() + " (" + enemy.getElementType() + ") stands victorious.");
                System.out.println("\n " + enemy.getName() + " mocks you: \"" + remark + "\"");
            }

            System.out.println("=".repeat(60) + "\n");
            round = 1;
        }


}