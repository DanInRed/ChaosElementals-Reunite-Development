
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

    public static ImageIcon getScaledIcon(String path, int size) {
        URL url = IconLoader.class.getResource(path);
        
        // Fallback to placeholder if path is wrong
        if (url == null) {
            System.err.println("DEBUG: Missing resource at " + path);
            url = IconLoader.class.getResource(DEFAULT_PATH);
        }

        if (url != null) {
            return new ImageIcon(new ImageIcon(url).getImage()
                    .getScaledInstance(size, size, Image.SCALE_SMOOTH));
        }
        
        return null; // Both failed
    }
}