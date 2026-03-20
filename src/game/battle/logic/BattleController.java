
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 20, 2026
 */
package game.battle.logic;
import game.battle.state.BattleState;
import game.ui.battle.engine.CombatLog;
import game.ui.battle.BattleView;
import game.battle.simulator.SimulateManaCost;
import game.engine.DamageCalculator;
import game.types.AttackType;
import javax.swing.Timer; //Timer for ui purpose

public class BattleController {
    private BattleState state;
    private CombatLog logScrollPane;
    private BattleView view;
        
    public BattleController(BattleState state, CombatLog logScrollPane, BattleView view) {
        this.state = state;
        this.logScrollPane = logScrollPane;
        this.view = view;
    }

    public void handlePlayerInput(int choice, AttackType type) {
        // Moved manaValidator logic from BattlePanel!
        SimulateManaCost check = new SimulateManaCost(choice, state.getPlayer(), type);

        if (check.isChoiceValid(choice, state.getPlayer(), type)) {
            // 1. Spend Mana
            state.getPlayer().manaCost(check.getManaNeeded());
            
            // 2. Lock UI to prevent double-clicks
            view.setControlsEnabled(false);
            
            // 3. Perform the attack
            executeAttack(type);
        } else {
            logScrollPane.log("Not enough mana for " + type + "!");
        }
    }
    
    private void executeAttack(AttackType type) {
        // 1. Logic: Calculate and Apply Damage
        double dmg = DamageCalculator.calculateDamage(state.getPlayer(), state.getEnemy(), type);
        state.getEnemy().takeDamage(dmg);

        // 2. View: Feedback
        logScrollPane.log(state.getPlayer().getName() + " used " + type + "!");
        logScrollPane.log("Dealt " + (int)dmg + " damage!");
        
        // Use the Interface to trigger the animation on the enemy (isPlayer = false)
        view.playDamageAnimation(false, dmg);
        view.updateUI();

        // 3. State Check: Did they win?
        if (!state.getEnemy().isAlive()) {
            logScrollPane.log("VICTORY! " + state.getEnemy().getName() + " fainted.");
            // You might want to add view.handleBattleEnd(true) here later
        } else {
            startEnemyTurnTimer();
        }
    }
    
    private void startEnemyTurnTimer() {
        Timer enemyTimer = new Timer(1500, e -> {
            // 1. Logic: Enemy AI (Simple Normal attack for now)
            AttackType enemyMove = AttackType.NORMAL; 
            double dmg = DamageCalculator.calculateDamage(state.getEnemy(), state.getPlayer(), enemyMove);
            state.getPlayer().takeDamage(dmg);

            // 2. View: Feedback
            logScrollPane.log(state.getEnemy().getName() + " attacks with " + enemyMove + "!");
            logScrollPane.log("You took " + (int)dmg + " damage.");
            
            // Trigger animation on player (isPlayer = true)
            view.playDamageAnimation(true, dmg);
            view.updateUI();

            // 3. Final Check
            if (!state.getPlayer().isAlive()) {
                logScrollPane.log("DEFEAT... You have fallen.");
            } else {
                view.setControlsEnabled(true);
                logScrollPane.log("Your turn!");
            }
        });

        enemyTimer.setRepeats(false);
        enemyTimer.start();
    }
    
}
