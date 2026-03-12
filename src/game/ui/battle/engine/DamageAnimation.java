
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 12, 2026
 */
package game.ui.battle.engine;

/**
 *
 * @author Dash
 */
public class DamageAnimation {
    public static void showDamageAnimation(javax.swing.JLabel textLabel, javax.swing.JLabel iconLabel, double dmg) {
        // 1. Setup the Damage Text
        textLabel.setText("-" + (int)dmg);
        textLabel.setVisible(true);

        // 2. Save the original position of the Icon
        java.awt.Point originalLocation = iconLabel.getLocation();

        // 3. Create the Timer
        javax.swing.Timer animTimer = new javax.swing.Timer(50, new java.awt.event.ActionListener() {
            int count = 0;
            int shakeDistance = 5; // How many pixels to move

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (count < 10) { // Run for 10 frames (500ms total)
                    // BLINK LOGIC
                    if (count % 2 == 0) textLabel.setVisible(!textLabel.isVisible());

                    // SHAKE LOGIC
                    // Alternates: Original -> Left -> Original -> Right -> Repeat
                    if (count % 2 == 0) {
                        iconLabel.setLocation(originalLocation.x - shakeDistance, originalLocation.y);
                    } else {
                        iconLabel.setLocation(originalLocation.x + shakeDistance, originalLocation.y);
                    }

                    count++;
                } else {
                    // RESET EVERYTHING
                    iconLabel.setLocation(originalLocation); // Snap back to center
                    textLabel.setVisible(false);
                    textLabel.setText("");
                    ((javax.swing.Timer)e.getSource()).stop();
                }
            }
        });

        animTimer.start();
    }
}
