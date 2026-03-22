
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

public class FireElemental implements Element{
    private BaseDamage base = new BaseDamage();
    
    @Override
    public String getName(){
        return "SLAYER's Pyro Spawnling!";
    }
    @Override
    public ElementType getType() { return ElementType.FIRE; }
    @Override
    public double getBaseAttack() { return base.getBaseDamage(); } // Base stats live here
}