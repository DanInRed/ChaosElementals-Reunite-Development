
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

import game.entity.character.stats.BaseDamage;
import game.types.*;

public class IceElemental implements Element{
    private BaseDamage base = new BaseDamage();
    
    @Override
    public String getName(){
        return "DISSECTION's Ice Elemental Spawnling!";
    }
    @Override
    public ElementType getType() { return ElementType.ICE; }
    @Override
    public double getBaseAttack() { return base.getBaseDamage(); } // Base stats live here
}