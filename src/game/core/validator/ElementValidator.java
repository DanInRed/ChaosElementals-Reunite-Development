
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.core.validator;

import game.elements.*;
import game.types.*;

public class ElementValidator {

    /**
     * Converts a user-input integer into a valid ElementType.
     * @param index The number chosen by the user (0-7).
     * @return The corresponding ElementType.
     */
    public static ElementType getElementFromIndex(int index) {
        return switch (index) {
            case 0 -> ElementType.FIRE;
            case 1 -> ElementType.ICE;
            case 2 -> ElementType.PLANT;
            case 3 -> ElementType.ROCK;
            case 4 -> ElementType.ELECTRIC;
            case 5 -> ElementType.WATER;
            case 6 -> ElementType.WIND;
            case 7 -> ElementType.METAL;
            default -> ElementType.FIRE; // Default fallback
        };
    }
    
    public static Element getElementObject(int index) {
        return switch (index) {
            case 0 -> new FireElemental();
            case 1 -> new IceElemental();
            case 2 -> new PlantElemental();
            case 3 -> new RockElemental();
            case 4 -> new ElectricElemental();
            case 5 -> new WaterElemental();
            case 6 -> new WindElemental();
            case 7 -> new MetalElemental();
            
            default -> new FireElemental();
        };
    }
    
}