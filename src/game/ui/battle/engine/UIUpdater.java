
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 12, 2026
 */

package game.ui.battle.engine;

import game.character.holder.CharacterHolder;
import javax.swing.JProgressBar;
import java.awt.Color;

public class UIUpdater {

    public static void refreshHealthBar(JProgressBar bar, CharacterHolder character) {
        int current = (int)character.getCurrentHealth();
        int max = (int)character.getHP().getMaxHP();

        bar.setMinimum(0);
        bar.setMaximum(max);
        bar.setValue(current);

        // Color Logic
        double percent = ((double)current / max) * 100;
        if (percent <= 25) {
            bar.setForeground(Color.RED);
        } else if (percent <= 50) {
            bar.setForeground(Color.ORANGE);
        } else {
            bar.setForeground(new Color(34, 139, 34)); // A nice Forest Green
        }
    }
    
    public static void refreshManaBar(JProgressBar bar, CharacterHolder character){
        int current = (int)character.getCurrentMana();
        int max = (int)character.getMana().getMaxMana();
        
        bar.setMinimum(0);
        bar.setMaximum(max);
        bar.setValue(current);
        
        bar.setForeground(Color.BLUE);
        
    }
    
    public static void updateLabels(javax.swing.JLabel lblHp, javax.swing.JLabel lblMana, CharacterHolder character) {
        int currHP = (int) character.getCurrentHealth();
        int maxHP = (int) character.getHP().getMaxHP();
        int currMana = (int) character.getCurrentMana();
        int maxMana = (int) character.getMana().getMaxMana();
        
        lblHp.setText("HP: " + currHP + "/" + maxHP);
        lblMana.setText("Mana: " + currMana + "/" + maxMana);
        // updateActionButtons(); called after startEnemyTurnTimer
    }

}
