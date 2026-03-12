
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 12, 2026
 */
package game.ui.battle.engine;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

public class IconLoader {
    // Default placeholder in case an icon is missing
    private static final String DEFAULT_PATH = "/game/resources/icons/placeholder.png";

    public static ImageIcon getScaledIcon(Object caller, String path, int size) {
        URL url = caller.getClass().getResource(path);
        
        // Fallback to placeholder if path is wrong
        if (url == null) {
            System.err.println("Resource not found: " + path + ". Using placeholder.");
            url = caller.getClass().getResource(DEFAULT_PATH);
        }

        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            Image img = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        }
        
        return null; // Both failed
    }
}