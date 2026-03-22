
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 7, 2026
 */
package game.entity.character.stats;

/**
 *
 * @author Dash
 */
public class BaseDamage{
    private double baseDamage;
    public BaseDamage(){
        this.baseDamage = 50.0;
    }
    public BaseDamage(double baseDamage){
        this.baseDamage = baseDamage;
    }
    public double getBaseDamage(){
        return baseDamage;
    }
}
