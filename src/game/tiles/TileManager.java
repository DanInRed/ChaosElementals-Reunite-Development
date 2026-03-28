        
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
            BufferedImage pathSheet = ImageIO.read(getClass().getResourceAsStream(path + "/path.png"));
            BufferedImage waterSheet = ImageIO.read(getClass().getResourceAsStream(path + "/water.png"));
            BufferedImage treeSheet  = ImageIO.read(getClass().getResourceAsStream(path + "/tree.png"));
            BufferedImage bushSheet = ImageIO.read(getClass().getResourceAsStream(path + "/bush.png"));
            BufferedImage thornybushSheet = ImageIO.read(getClass().getResourceAsStream(path + "/thornybush.png"));
            // 00-01 grass, 02-03 path, 04 hintpath, 05 sand,06 concretefloor, 10-11 water, 
            // 30-31 = tree, 35-36 bush, 37-38 thorny, 40 = concretewall 
            // --- 00-09 = WALKABLE PATHS ---
            tile[0] = new Tile(); // Frame 1
            tile[0].image = grassSheet.getSubimage(0, 0, 16, 16); // Row 1
            tile[1] = new Tile(); // Frame 2
            tile[1].image = grassSheet.getSubimage(0, 16, 16, 16); // Row 2
            
            tile[2] = new Tile(); // Frame 1
            tile[2].image = pathSheet.getSubimage(0, 0, 16, 16); // Row 1
            tile[3] = new Tile(); // Frame 2
            tile[3].image = pathSheet.getSubimage(0, 16, 16, 16); // Row 2
            
            tile[4] = new Tile(); // hint path
            tile[4].image = ImageIO.read(getClass().getResourceAsStream(path + "hintpath.png"));
            
            tile[5] = new Tile(); //sand
            tile[5].image = ImageIO.read(getClass().getResourceAsStream(path + "sand.png"));
            tile[5].collision = true;
            tile[6] = new Tile(); //concrete floor
            tile[6].image = ImageIO.read(getClass().getResourceAsStream(path + "concretefloor.png"));
            
            
            // --- 10-19 = WATER
            tile[10] = new Tile();
            tile[10].image = waterSheet.getSubimage(0, 0, 16, 16);
            tile[10].collision = true;
            tile[11] = new Tile();
            tile[11].image = waterSheet.getSubimage(0, 16, 16, 16);
            tile[11].collision = true;
            
            tile[30] = new Tile();
            tile[30].image = treeSheet.getSubimage(0, 0, 16, 16);
            tile[30].collision = true;
            tile[31] = new Tile();
            tile[31].image = treeSheet.getSubimage(0, 16, 16, 16);
            tile[31].collision = true;
            
            tile[35] = new Tile(); // Frame 1
            tile[35].image = bushSheet.getSubimage(0, 0, 16, 16); // Row 1
            tile[36] = new Tile(); // Frame 2
            tile[36].image = bushSheet.getSubimage(0, 16, 16, 16); // Row 2
            
            tile[37] = new Tile(); // Frame 1
            tile[37].image = thornybushSheet.getSubimage(0, 0, 16, 16); // Row 1
            tile[38] = new Tile(); // Frame 2
            tile[38].image = thornybushSheet.getSubimage(0, 16, 16, 16); // Row 2
            
            
            // WALLS 40+
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream(path + "concretewall.png"));
            tile[40].collision = true;
            
        }catch(IOException e){
            e.printStackTrace();
        }
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
            
            if(tileNum == 0 && spriteNum == 2) finalTileNum = 1; // Grass Animation
            if(tileNum == 2 && spriteNum == 2) finalTileNum = 3; // Path Animation
            if(tileNum == 10 && spriteNum == 2) finalTileNum = 11; // Water animation
            if(tileNum == 30 && spriteNum == 2) finalTileNum = 31; // Tree animation
            if(tileNum == 35 && spriteNum == 2) finalTileNum = 36; // Bush animation
            if(tileNum == 37 && spriteNum == 2) finalTileNum = 38; // thornyBush animation
            
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
