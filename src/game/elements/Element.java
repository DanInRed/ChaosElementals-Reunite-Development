
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.elements;

import game.types.ElementType;

/**
 *
 * @author Dash
 */
public interface Element {
    public String getName();
    public ElementType getType(); 
    public double getBaseAttack();
}
