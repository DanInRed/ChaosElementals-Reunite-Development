
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.core.validator;

import game.types.AttackType;

public class AttackTypeValidator {
    
    /**
     * Converts a user-input integer into a valid ElementType.
     * @param index The attack Type chosen by the user (0-3).
     * 0 = NORMAL, 1 = SKILL_1, 2 = SKILL_2, 3 = ULTIMATE
     * @return The corresponding ElementType.
     */
    public static AttackType getAttackTypeByIndex(int index) {
        return switch (index) {
            case 0 -> AttackType.NORMAL;
            case 1 -> AttackType.SKILL_1;
            case 2 -> AttackType.SKILL_2;
            case 3 -> AttackType.ULTIMATE;
            
            default -> AttackType.NORMAL; // Default fallback
        };
    }
    
}