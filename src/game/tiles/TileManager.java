        
/*
 *  Project: ChaosElementalsGridExperiment
 *  Author: Dash 
 *  Date: Mar 23, 2026
 */
package game.tiles;

import game.core.main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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
        
        getTileImage();
        loadMap(path + "50by50map.txt");
    }

    public void getTileImage() {
        final String path = "/game/resources/tiles/"; 
        try{
            // 1. Load the three separate strips
            BufferedImage grassSheet = ImageIO.read(getClass().getResourceAsStream(path + "/grass.png"));
            BufferedImage waterSheet = ImageIO.read(getClass().getResourceAsStream(path + "/water.png"));
            BufferedImage treeSheet  = ImageIO.read(getClass().getResourceAsStream(path + "/tree.png"));
            
            // 10 = water, 20 = sand,  00-01 = grass path, 5 = earth/field, 30 = tree, 40 = brick/wall;
            // --- 00-09 = WALKABLE PATHS ---
            tile[0] = new Tile(); // Frame 1
            tile[0].image = grassSheet.getSubimage(0, 0, 16, 16); // Row 1
            tile[1] = new Tile(); // Frame 2
            tile[1].image = grassSheet.getSubimage(0, 16, 16, 16); // Row 2
            
            
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream(path + "brick.png"));
            tile[40].collision = true;
            
            // --- 10-19 = WATER
            tile[10] = new Tile();
            tile[10].image = waterSheet.getSubimage(0, 0, 16, 16);
            tile[10].collision = true;
            tile[11] = new Tile();
            tile[11].image = waterSheet.getSubimage(0, 16, 16, 16);
            tile[11].collision = true;
            
            tile[5] = new Tile(); //earth
            tile[5].image = ImageIO.read(getClass().getResourceAsStream(path + "earth.png"));
            
            tile[30] = new Tile();
            tile[30].image = treeSheet.getSubimage(0, 0, 16, 16);
            tile[30].collision = true;
            tile[31] = new Tile();
            tile[31].image = treeSheet.getSubimage(0, 16, 16, 16);
            tile[31].collision = true;
            
            
            tile[20] = new Tile(); //sand
            tile[20].image = ImageIO.read(getClass().getResourceAsStream(path + "sand.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update() { 
        spriteCounter++;
        if(spriteCounter > 30) {
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
            
            if(tileNum == 0 && spriteNum == 2) finalTileNum = 1; // Grass Animation
            if(tileNum == 10 && spriteNum == 2) finalTileNum = 11; // Water animation
            if(tileNum == 30 && spriteNum == 2) finalTileNum = 31; // Tree animation
            
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
