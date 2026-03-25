
/*
 *  Project: ChaosElementalsGridExperiment
 *  Author: Dash 
 *  Date: Mar 22, 2026
 */
package game.entity;

import game.core.main.GamePanel;
import game.core.main.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2- (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 24;
        solidArea.height = 24;
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        worldX = gp.tileSize * 5;
        worldY = gp.tileSize * 15;
        speed = 4;
        direction = "down";
    }
    
    public void getPlayerImage(){
        String filePath = "/game/resources/player/";
        try{
            //create the sprites pls 
            
            up1 = ImageIO.read(getClass().getResourceAsStream(filePath +"DashDown1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream(filePath +"DashDown2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream(filePath +"DashDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream(filePath +"DashDown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream(filePath +"DashDown1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream(filePath +"DashDown2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream(filePath +"DashDown1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream(filePath +"DashDown2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed == true){
                direction = "up";
            }
            else if(keyH.downPressed == true){
                direction = "down";
            }
            else if(keyH.leftPressed == true){
                direction = "left";
            }
            else if(keyH.rightPressed == true){
                direction = "right";
            }
            
            // Check Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            // If collision is false, player can move 
            if(collisionOn == false){
                switch(direction){
                    case "up" : worldY -= speed; break;
                    case "down" : worldY += speed; break;
                    case "left" : worldX -= speed; break;
                    case "right" : worldX += speed; break;
                }
            }
            
            spriteCounter++;
            if(spriteCounter>20){
                if(spriteNumber == 1){
                    spriteNumber = 2;
                }else if(spriteNumber == 2){
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    
    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        
        BufferedImage image = null;
        
        switch(direction){
            case "up" : 
                if(spriteNumber == 1){
                    image = up1;
                }
                if(spriteNumber == 2){
                    image = up2;
                }
                break;
            case "down" : 
                if(spriteNumber == 1){
                    image = down1;
                }
                if(spriteNumber == 2){
                    image = down2;
                }
                break;
            case "left" : 
                if(spriteNumber == 1){
                    image = left1;
                }
                if(spriteNumber == 2){
                    image = left2;
                }
                break;
            case "right" : 
                if(spriteNumber == 1){
                    image = right1;
                }
                if(spriteNumber == 2){
                    image = right2;
                }
                break;
            
            
        }
        if(image != null){
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }else{
            // Fallback so the game doesn't crash while debugging
            g2.setColor(Color.WHITE);
            g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
        }
    }
}
