
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

public class ElectricElemental implements Element{
    private BaseDamage base = new BaseDamage();
    
    @Override 
    public String getName(){
        return "ElectricWizard's Electric Spirit!";
    }
    
    @Override
    public ElementType getType() { return ElementType.ELECTRIC; }
    @Override
    public double getBaseAttack() { return base.getBaseDamage(); } // Base stats live here
}