
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
        
        tile = new Tile[20];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        
        getTimeImage();
        loadMap("/game/resources/maps/map.txt");
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
            
            while(col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                
                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
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
        
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while(col < gp.maxScreenCol && row < gp.maxScreenRow){
            
            int tileNum = mapTileNum[col][row];
            
            // Animation Logic: Swap tiles based on spriteNum
            int finalTileNum = tileNum;
            
            if(tileNum == 0 && spriteNum == 2) finalTileNum = 3; // Switch grass1 to grass2
            if(tileNum == 2 && spriteNum == 2) finalTileNum = 4; // Switch water1 to water2
            
            g2.drawImage(tile[finalTileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            
            if(col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
