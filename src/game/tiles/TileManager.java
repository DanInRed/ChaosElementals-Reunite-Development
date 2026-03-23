
/*
 *  Project: ChaosElementalsGridExperiment
 *  Author: Dash 
 *  Date: Mar 23, 2026
 */
package game.tiles;

import game.core.main.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    
    // ANIMATION VARIABLES
    int spriteCounter = 0;
    int spriteNum = 1;
    
    public TileManager(GamePanel gp){
        this.gp = gp;
        
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTimeImage();
        loadMap("/game/resources/maps/50by50map.txt");
    }

    public void getTimeImage() {
        try{
            
            tile[0] = new Tile(); //grass1
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/game/resources/tiles/grass1.png"));
            tile[3] = new Tile(); //grass2
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/game/resources/tiles/grass2.png"));
            
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/game/resources/tiles/brick.png"));
            
            tile[2] = new Tile(); //water1
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/game/resources/tiles/water1.png"));
            tile[4] = new Tile(); //water2
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/game/resources/tiles/water2.png"));
            
            tile[5] = new Tile(); //earth
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/game/resources/tiles/earth.png"));
            
            tile[6] = new Tile(); //tree
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/game/resources/tiles/tree.png"));
            
            tile[7] = new Tile(); //sand
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/game/resources/tiles/sand.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update() { // animation for tiles grass and water
        spriteCounter++;
        // Change image every 30 frames (0.5 seconds at 60FPS)
        if(spriteCounter > 30) {
            if(spriteNum == 1) {
                spriteNum = 2;
            } else if(spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
    }
}
    
    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                
                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            
        }catch(Exception e){
            
        }
    }
    
    public void draw(Graphics2D g2){
        /*g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[1].image, (gp.tileSize), 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, (gp.tileSize*2), 0, gp.tileSize, gp.tileSize, null);*/
        
        int worldCol = 0;
        int worldRow = 0;
        
        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            
            int tileNum = mapTileNum[worldCol][worldRow];
            
            // World positioning for gp.drawImage();
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            // Animation Logic: Swap tiles based on spriteNum
            int finalTileNum = tileNum;
            
            if(tileNum == 0 && spriteNum == 2) finalTileNum = 3; // Switch grass1 to grass2
            if(tileNum == 2 && spriteNum == 2) finalTileNum = 4; // Switch water1 to water2
            
            // Memory efficient that draws only those tiles that falls inside the player's screen
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
            g2.drawImage(tile[finalTileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
            
            //g2.drawImage(tile[finalTileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            worldCol++;
            
            
            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;  
            }
        }
    }
}
