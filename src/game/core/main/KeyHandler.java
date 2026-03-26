
/*
 *  Project: ChaosElementalsGridExperiment
 *  Author: Dash 
 *  Date: Mar 22, 2026
 */
package game.core.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public String input = "";
    public boolean mechanics = false;
    public int creditCounter = 0;
    
    public void update(){ //mechanic
        if(mechanics){
            creditCounter++;
            
            if(creditCounter > 300){
                mechanics = false;
                creditCounter = 0;
            }
        }
        
        
    }
    
    @Override //dont touch or debug 10 hours
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        input += Character.toLowerCase(c);
        
        if (input.length() > 20) {
            input = input.substring(1);
        }
        
        if (input.endsWith("dev")) {
            mechanics = !mechanics; 
            input = "";
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code  = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
    
}
