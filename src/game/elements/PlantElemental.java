
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */

/**
 *
 * @author Dash
 */
package game.elements;

import game.types.*;
import game.character.stats.*;

public class PlantElemental implements Element{
    private BaseDamage base = new BaseDamage();
    
    @Override
    public String getName(){
        return "Roy's Awakened Venus Flytrap!";
    }
    @Override
    public ElementType getType() { return ElementType.PLANT; }
    @Override
    public double getBaseAttack() { return base.getBaseDamage(); } // Base stats live here
}