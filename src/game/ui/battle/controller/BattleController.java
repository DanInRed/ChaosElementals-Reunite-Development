//TODO this is incorrect
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 12, 2026
 */

/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 12, 2026
 */
package game.ui.battle.controller;

import game.character.holder.CharacterHolder;
import game.types.AttackType;
import game.battle.simulator.SimulateBattle;

public class BattleController {
    private CharacterHolder player;
    private CharacterHolder enemy;
    private SimulateBattle simulator;

    public BattleController(CharacterHolder player, CharacterHolder enemy) {
        this.player = player;
        this.enemy = enemy;
        this.simulator = new SimulateBattle();
    }

    public String handlePlayerAttack(AttackType type) {
        double power = type.getPower();
        
        // 1. Calculate damage (Bridge to your simulator later)
        double damage = 20.0 * power; 
        
        // 2. THE FIX: Use your existing takeDamage method!
        enemy.takeDamage(damage);
            
        return player.getName() + " used " + type.name() + "! Dealt " + (int)damage + " damage.";
    }

    public boolean isBattleOver() {
        // THE FIX: Use your isAlive() shortcut
        return !enemy.isAlive() || !player.isAlive();
    }
}
