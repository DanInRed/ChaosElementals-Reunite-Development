
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.battle.simulator; // or game.battle

import java.util.Scanner;
import java.util.Random;
import game.character.holder.CharacterHolder;
import game.engine.DamageCalculator;
import static game.engine.GameUtils.pause;
import game.types.AttackType;
import game.core.AttackTypeValidator;
import game.core.InputValidator;
import game.types.*;

public class SimulateBattle {
    private final Random rand = new Random();
    private int round = 1;
    public void startBattle(CharacterHolder player, CharacterHolder enemy, Scanner scanf) {
        System.out.println("\n--- BATTLE START: " + player.getElementType() + " VS " + enemy.getElementType() + " ---");

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
        System.out.println("\n[ YOUR TURN - HP: " + player.getCurrentHealth() + " ]");
        System.out.println("Round " + round + "| 0: NORMAL | 1: SKILL_1 | 2: SKILL_2 | 3: ULTIMATE");
        
        int choice = InputValidator.getValidAttack("Select Attack: ", scanf);
        
        player.setAttackType(AttackTypeValidator.getAttackTypeByIndex(choice));
        double dmg = DamageCalculator.calculate(player, enemy, player.getAttackType());
        
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
        double dmg = DamageCalculator.calculate(enemy, player, enemyMove);
        
        player.takeDamage(dmg);
        System.out.println("Enemy used " + enemyMove + "! Dealt: " + dmg);
        round++;
    }
    
    private String getWittyRemark(ElementType type, boolean playerWon) {
    if (playerWon) {
        return switch (type) {
            case FIRE -> "The heat was on, but you played it cool!";
            case ICE -> "Cool Story... too bad you're on thin ice now. Consider yourself defrosted :p";
            case PLANT -> "Oh no you poor thing, Uprooted!";
            case ROCK -> "You were a boulder, but I was the Jack Hammer.";
            case ELECTRIC -> "The riff guy got Amped!";
            case WATER -> "You soaked up the win and left them high and dry!";
            case WIND -> "Is that it? The 'legendary gale' was barely a light breeze.";
            case METAL -> "You really Headbanged that victory home!";
            default -> "Victory is yours! They never stood a chance.";
        };
    } else {
        return switch (type) {
            case FIRE -> "You just got third-degree burned. Ouch.";
            case ICE -> "Is this frostbite? into the chill grave you go.";
            case PLANT -> "Yikes, post apocaliptic vegetation it is.";
            case ROCK -> "Wait What? the golem launched a surprise attack? \nNo fair!";
            case ELECTRIC -> "Oh well.. thunderstruck it is.";
            case WATER -> "Don't worry, the salt water will preserve your pride. \nYour 'wave' was the most pathetic thing I saw all day.";
            case WIND -> "You got blown away like a leaf in a storm.";
            case METAL -> "Oops... poser detected!";
            default -> "Better luck next time, trainee!";
        };
    }
}
    
        private void displayResult(CharacterHolder player, CharacterHolder enemy) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("                         BATTLE END                         ");
            System.out.println("=".repeat(60));

            boolean playerWon = player.isAlive();
            // Get the witty remark based on the enemy's element and the result
            String remark = getWittyRemark(enemy.getElementType(), playerWon);

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