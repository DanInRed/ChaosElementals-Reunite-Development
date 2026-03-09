
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.engine;

import game.types.*;
import game.character.holder.CharacterHolder;

public class DamageCalculator {

    public static double calculateDamage(CharacterHolder attacker, CharacterHolder defender, AttackType move) {
        // 1. Check for NORMAL attack logic first
        if (move == AttackType.NORMAL) {
            return attacker.getStats().getBaseDamage();
        }

        // 2. Extract indices from the holders
        int attackerIndex = attacker.getElementType().getIndex();
        int defenderIndex = defender.getElementType().getIndex();

        // 3. PolygonStar Distance Math
        int distance = (defenderIndex - attackerIndex + 8) % 8;
        double elementMult = 1.0;

        if (distance == 1 || distance == 2) {
            elementMult = 1.5;      // Strong
        } else if (distance == 7 || distance == 6) {
            elementMult = 0.5;      // Weak
        }

        // 4. Attack Type Multiplier
        double moveMult = move.getPower();

        // 5. Final Calculation
        return attacker.getStats().getBaseDamage() * elementMult * moveMult;
    }
}