
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.core;

import java.util.Scanner;

import game.types.*;
import game.battle.simulator.*;
import game.character.holder.*;
import java.util.Random;
import game.elements.*;
public class TestingElementalMaster {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);        
        //BaseDamage defaultStats = new BaseDamage();
        
        
        System.out.println("---------------------------------Elemental Masters---------------------------------");
        System.out.println("\n");
        System.out.println("Elements List: ");
        System.out.println("0. Fire");
        System.out.println("1. Ice");
        System.out.println("2. Plant");
        System.out.println("3. Rock");
        System.out.println("4. Electric");
        System.out.println("5. Water");
        System.out.println("6. Wind");
        System.out.println("7. Metal");
        System.out.println("\n");
        
        Random rand = new Random();
        int enemyChoice = rand.nextInt(8); // Random index 0-7
        
        
        Element enemyType = ElementValidator.getElementObject(enemyChoice);
        CharacterHolder enemy = new CharacterHolder(enemyType);

        System.out.println("!!! A WILD ENEMY APPEARS !!!");
        System.out.println("The enemy is a " + enemy.getElementType() + " [" + enemy.getName() + "]");
        System.out.println("-------------------------------------------");

        // 2. PLAYER DECIDES THEIR COUNTER
        int bestCounter1 = (enemyChoice + 7) % 8; // One step back (Strong)
        int bestCounter2 = (enemyChoice + 6) % 8; // Two steps back (Strong)

        System.out.println("HINT: Try using " + ElementValidator.getElementFromIndex(bestCounter1) + 
                   " or " + ElementValidator.getElementFromIndex(bestCounter2) + "!");
        
        System.out.println("Elements List: 0.Fire, 1.Ice, 2.Plant, 3.Rock, 4.Electric, 5.Water, 6.Wind, 7.Metal");
        int playerChoice = InputValidator.getValidElement("Choose your element to counter " + enemy.getName() + ": ", scanf);
        Element playerType = ElementValidator.getElementObject(playerChoice);
        CharacterHolder player = new CharacterHolder(playerType);

        System.out.println("\nYou chose " + player.getElementType() + " Element! " + " " + player.getName() + " Appeared!");
        
        // New: Call the Simulator
        SimulateBattle simulator = new SimulateBattle();
        simulator.startBattle(player, enemy, scanf);
        
    }
}
