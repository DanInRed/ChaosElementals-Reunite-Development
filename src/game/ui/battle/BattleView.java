
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 20, 2026
 */
package game.ui.battle;

public interface BattleView {
    void setControlsEnabled(boolean enabled);
    void updateUI();
    void playDamageAnimation(boolean isPlayer, double damage);
}