
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
            // 1. PLAYER TURN
            handlePlayerTurn(player, enemy, scanf);
            if (!enemy.isAlive()) break;

            // 2. ENEMY TURN
            handleEnemyTurn(enemy, player);
        }

        displayResult(player, enemy);
    }

    private void handlePlayerTurn(CharacterHolder player, CharacterHolder enemy, Scanner scanf) {
        System.out.println("\n                                      [ YOUR TURN ]                                              ");
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
        
        System.out.println("\n[ ENEMY TURN - HP: " + enemy.getCurrentHealth() + " ]");
        
        for(int i = 0; i < 3; i++){
            pause(666);
            System.out.print(".");
        }
        
        // Randomly pick an attack for the enemy
        AttackType enemyMove = AttackType.values()[rand.nextInt(AttackType.values().length)];
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