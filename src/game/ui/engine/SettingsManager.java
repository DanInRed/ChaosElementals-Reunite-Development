
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 11, 2026
 */
package game.ui.engine;

public class SettingsManager {
    public static boolean musicEnabled = true;
    public static boolean sfxEnabled = true;

    public static void toggleMusic() {
        musicEnabled = !musicEnabled;
        System.out.println("Ghost Music is now: " + (musicEnabled ? "ON" : "OFF"));
    }

    public static void toggleSFX() {
        sfxEnabled = !sfxEnabled;
        System.out.println("Ghost SFX is now: " + (sfxEnabled ? "ON" : "OFF"));
    }
   
}