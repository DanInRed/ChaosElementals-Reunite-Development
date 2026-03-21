
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 21, 2026
 */
package game.battle.simulator;
import game.types.AttackType;

public class TurnResult {
    private final double damageDealt;
    private final AttackType attackUsed;
    private final String description;
    //private final boolean wasSweating; // New Flag
    //private final boolean isSkipped;   // For Stun/Freeze logic
    
    public TurnResult(String description ,Double damageDealt, AttackType attackUsed){//boolean wasSweating, boolean isSkipped
        this.damageDealt = damageDealt;
        this.attackUsed = attackUsed;
        this.description = description;
        //this.wasSweating = wasSweating;
        //this.isSkipped = false;
        
    }
    
    public double getDamageDealt(){
        return damageDealt;
    }
    public AttackType getAttackUsed(){
        return attackUsed;
    }
    public String getDescription(){
        return description;
    }
    
}
