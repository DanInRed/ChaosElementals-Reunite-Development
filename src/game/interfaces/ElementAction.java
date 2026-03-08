
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.interfaces;

import game.types.*;

public interface ElementAction {
    double calculateDamage(ElementType defender, AttackType attack, double baseDmg);
    String getElementName();
    double manaUsage();//TODO implement this mana Usage for skill casting
}
