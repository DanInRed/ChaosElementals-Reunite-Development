
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
    public Tile[] tile;
    public int mapTileNum[][];
    
    // ANIMATION VARIABLES
    int spriteCounter = 0;
    int spriteNum = 1;
    
    public TileManager(GamePanel gp){
        final String path = "/game/resources/maps/";
        this.gp = gp;
        
        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTimeImage();
        loadMap(path + "50by50map.txt");
    }

    public void getTimeImage() {
        final String path = "/game/resources/tiles/"; 
        try{
            // 10 = water, 20 = sand,  00-01 = grass path, 5 = earth/field, 30 = tree, 40 = brick/wall;
            // --- 00-09 = WALKABLE PATHS ---
            tile[0] = new Tile(); //grass1
            tile[0].image = ImageIO.read(getClass().getResourceAsStream(path + "grass1.png"));
            tile[1] = new Tile(); //grass2
            tile[1].image = ImageIO.read(getClass().getResourceAsStream(path + "grass2.png"));
            
            
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream(path + "brick.png"));
            tile[40].collision = true;
            
            // --- 10-19 = WALKABLE WATER (SHALLOW OCEAN/POND/RIVER) ---
            tile[10] = new Tile(); //water1
            tile[10].image = ImageIO.read(getClass().getResourceAsStream(path + "water1.png"));
            //tile[10].collision = true;
            tile[11] = new Tile(); //water2
            tile[11].image = ImageIO.read(getClass().getResourceAsStream(path + "water2.png"));
            //tile[11].collision = true;
            
            tile[5] = new Tile(); //earth
            tile[5].image = ImageIO.read(getClass().getResourceAsStream(path + "earth.png"));
            
            tile[30] = new Tile(); //tree
            tile[30].image = ImageIO.read(getClass().getResourceAsStream(path + "tree.png"));
            tile[30].collision = true;
            
            tile[20] = new Tile(); //sand
            tile[20].image = ImageIO.read(getClass().getResourceAsStream(path + "sand.png"));
            
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
                    String numbers[] = line.split("\\s+");
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
            
        }catch(Exception e){
            System.out.println("Error: Could not load map file at " + filePath);
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g2){
        
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
            
            if(tileNum == 0 && spriteNum == 2) finalTileNum = 1; // Switch grass1 to grass2
            if(tileNum == 10 && spriteNum == 2) finalTileNum = 11; // Switch water1 to water2
            
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
