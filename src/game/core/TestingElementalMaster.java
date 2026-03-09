/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.core;

import java.util.Scanner;

import game.battle.simulator.*;
import game.character.holder.*;
import java.util.Random;
import game.elements.*;
import static game.engine.GameUtils.pause;
import game.character.stats.*;

public class TestingElementalMaster {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);        
        
        System.out.println("---------------------------------Elemental Masters---------------------------------");
        
        Random rand = new Random();
        int enemyChoice = rand.nextInt(8); // Random index 0-7
        
        
        Element enemyType = ElementValidator.getElementObject(enemyChoice);
        CharacterHolder enemy = new CharacterHolder(enemyType);

        System.out.println("\nWelcome to Elemental Masters! your cutesy elemental battleground.\n");
        
        pause(2500); // this acts as a timer to slow down the terminal
        
        System.out.println("Wait a minute... is that?\n");
        pause(2000);
        System.out.println("!!! A WILD ENEMY APPEARS !!!");
        System.out.println("The enemy is a " + enemy.getElementType() + " [" + enemy.getName() + "]");
        System.out.println("-------------------------------------------");

        // 2. PLAYER DECIDES THEIR COUNTER
        int bestCounter1 = (enemyChoice + 7) % 8; // One step back (Strong)
        int bestCounter2 = (enemyChoice + 6) % 8; // Two steps back (Strong)
        
        pause(2500); // this acts as a timer to slow down the terminal
        
        System.out.println("Wow an enemy appeared? We just started.\n");
        System.out.println("Oh well, Here's your options. ");
        
        pause(1500); // this acts as a timer to slow down the terminal
        
        System.out.println("HINT: Try using " + ElementValidator.getElementFromIndex(bestCounter1) + 
                   " or " + ElementValidator.getElementFromIndex(bestCounter2) + "!");
        pause(1500);
        System.out.println("Elements List: \n0.Fire, \n1.Ice, \n2.Plant, \n3.Rock, \n4.Electric, \n5.Water, \n6.Wind, \n7.Metal");
        int playerChoice = InputValidator.getValidElement("Choose your element to counter " + enemy.getName() + ": ", scanf);
        Element playerType = ElementValidator.getElementObject(playerChoice);
        CharacterHolder player = new CharacterHolder(playerType);
        
        pause(1500); // this acts as a timer to slow down the terminal
        System.out.println("\nYou chose " + player.getElementType() + " Element! " + " " + player.getName() + " Appeared!");
        pause(1500); // this acts as a timer to slow down the terminal
        // New: Call the Simulator
        SimulateBattle simulator = new SimulateBattle();
        simulator.startBattle(player, enemy, scanf);
        
    }
}
