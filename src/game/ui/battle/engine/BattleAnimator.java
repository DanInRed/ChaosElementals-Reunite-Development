
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 12, 2026
 */

package game.ui.battle.engine;

import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Point;

public class BattleAnimator {

    public static void animateDamage(JLabel textLabel, JLabel iconLabel, double dmg) {
        textLabel.setText("-" + (int)dmg);
        textLabel.setVisible(true);
        
        final Point originalLocation = iconLabel.getLocation();
        
        Timer animTimer = new Timer(50, null); // Initialize without listener first
        animTimer.addActionListener(new java.awt.event.ActionListener() {
            int count = 0;
            int shakeDistance = 5;

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (count < 10) {
                    // Blink logic
                    if (count % 2 == 0) textLabel.setVisible(!textLabel.isVisible());

                    // Shake logic
                    if (count % 2 == 0) {
                        iconLabel.setLocation(originalLocation.x - shakeDistance, originalLocation.y);
                    } else {
                        iconLabel.setLocation(originalLocation.x + shakeDistance, originalLocation.y);
                    }
                    count++;
                } else {
                    // Reset
                    iconLabel.setLocation(originalLocation);
                    textLabel.setVisible(false);
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        animTimer.start();
    }
}
