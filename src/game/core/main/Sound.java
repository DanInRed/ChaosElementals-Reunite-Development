
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 26, 2026
 */
package game.core.main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    
    public Sound(){
        String path = "/game/resources/sound/";
        soundURL[0] = getClass().getResource(path + "first_light_particles.wav");
        soundURL[1] = getClass().getResource(path + "titletheme.wav");
        soundURL[2] = getClass().getResource(path + "grassfstep.wav");
        soundURL[3] = getClass().getResource(path + "sandfstep.wav");
        soundURL[4] = getClass().getResource(path + "pickupkey.wav");
        soundURL[5] = getClass().getResource(path + "opendoor.wav");
        soundURL[6] = getClass().getResource(path + "death.wav");
        // need sfx for water 
        
    }
    
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){
            System.out.println("Error at Sound.java");
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
