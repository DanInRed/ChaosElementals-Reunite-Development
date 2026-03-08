
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 8, 2026
 */
package game.engine;

/**
 *
 * @author Dash
 */

public class GameUtils {
    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}