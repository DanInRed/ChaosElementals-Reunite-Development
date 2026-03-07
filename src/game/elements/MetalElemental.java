
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

public class MetalElemental implements Element{
    private BaseDamage base = new BaseDamage();
    
    @Override
    public String getName(){
        return "Dash' Metalhead spawnling!";
    }
    @Override
    public ElementType getType() { return ElementType.METAL; }
    @Override
    public double getBaseAttack() { return base.getBaseDamage(); } // Base stats live here
}