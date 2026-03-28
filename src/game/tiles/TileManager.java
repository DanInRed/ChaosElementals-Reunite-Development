        
/*
 *  Project: ChaosElementalsGridExperiment
 *  Author: Dash 
 *  Date: Mar 23, 2026
 */
package game.tiles;

import game.core.main.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager implements TileIDs{
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    
    // ANIMATION VARIABLES
    int spriteCounter = 0;
    int spriteNum = 1;
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[51];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        // The Loader does the heavy lifting
        TileLoader.loadOverworldTiles(tile);
        TileLoader.parseMapFile("/game/resources/maps/50by50map.txt", mapTileNum, gp.maxWorldCol, gp.maxWorldRow);
    }
    
    public void update() { 
        spriteCounter++;
        if(spriteCounter > 60) {
            spriteNum = (spriteNum == 1) ? 2 : 1; // Cleaner way to toggle
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
            
            if(tileNum == GRASS_A && spriteNum == 2) finalTileNum = GRASS_B; // Grass Animation
            if(tileNum == PATH_A && spriteNum == 2) finalTileNum = PATH_B; // Path Animation
            if(tileNum == WATER_A && spriteNum == 2) finalTileNum = WATER_B; // Water animation
            if(tileNum == TREE_A && spriteNum == 2) finalTileNum = TREE_B; // Tree animation
            if(tileNum == BUSH1_A && spriteNum == 2) finalTileNum = BUSH1_B; // Bush animation
            if(tileNum == BUSH2_A && spriteNum == 2) finalTileNum = BUSH2_B; // thornyBush animation
            
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
