/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 8, 2026
 */

package game.engine;

import game.types.*;
import game.character.holder.CharacterHolder;

public class ManaCostCalculator {
    /**
     * @param character
     * @param attack
     * @return
     */
    public static double calculateManaCost(CharacterHolder character, AttackType attack){
        

        return switch(attack){
            case NORMAL -> 0.0; 
            case SKILL_1 -> 30.0;  
            case SKILL_2 -> 50.0; 
            case ULTIMATE -> 100.0; 
            default -> 0.0;
        };

        
    }
}
