
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

public class RockElemental implements Element{
    private BaseDamage base = new BaseDamage();
    
    @Override
    public String getName(){
        return "CROWBAR's Stone Golem!";
    }
    @Override
    public ElementType getType() { return ElementType.ROCK; }
    @Override
    public double getBaseAttack() { return base.getBaseDamage(); } // Base stats live here
}