
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 26, 2026
 */
package game.core.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
    GamePanel gp;
    
    public String currentMessage = "";
    public boolean messageOn  = false;
    public int messageCounter = 0; // The bark Timer
    
    public UI(GamePanel gp){
        this.gp = gp;
    }
    
    public void draw(Graphics2D g2) {
        if (gp.keyH.mechanics) {
            String repo = "Game: Chaos-Elementals-Reunite";
            String author = "Dev: [DanInRed/Dash]";

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            g2.setColor(Color.WHITE);

            // Draw in the bottom-right corner
            g2.drawString(repo, gp.screenWidth - 400, gp.screenHeight - 70);
            g2.drawString(author, gp.screenWidth - 400, gp.screenHeight - 40);
        }
        
        if(messageOn) {
            // 1. Draw the box (Optional but looks cool)
            g2.setColor(new Color(0,0,0,150));
            g2.fillRoundRect(gp.player.screenX, gp.player.screenY - 70, 200, 60, 10, 10); // TODO

            // 2. Draw the text
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 14F));
            //g2.drawString(currentMessage, gp.player.screenX + 5, gp.player.screenY - 20);
            
            int y = gp.player.screenY - 45; // Starting Y position
                for (String line : currentMessage.split("\n")) {
                    g2.drawString(line, gp.player.screenX, y);
                    y += 20; // Move down 20 pixels for the next line
                }
            
            // 3. Count frames
            messageCounter++;
            if(messageCounter > 150) { // 2.5 seconds for 60 FPS
                messageOn = false;
                messageCounter = 0;
            }
        }
    }
    
    public void showMessage(String text){
        currentMessage = text;
        messageOn = true;
        messageCounter = 0; // Reset timer everytime a new message appears
    }
    
    public void barkTime(){
        
    }
}
