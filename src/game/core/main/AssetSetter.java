
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 25, 2026
 */
package game.core.main;

import game.object.OBJ_Boots;
import game.object.OBJ_Chest;
import game.object.OBJ_Door;
import game.object.OBJ_Key;


public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 5 * gp.tileSize;
        gp.obj[1].worldY = 48 * gp.tileSize;
        
        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 26 * gp.tileSize;
        gp.obj[2].worldY = 37 * gp.tileSize;
        
        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 5 * gp.tileSize;
        gp.obj[5].worldY = 7 * gp.tileSize;
        gp.obj[6] = new OBJ_Door();
        gp.obj[6].worldX = 6 * gp.tileSize;
        gp.obj[6].worldY = 44 * gp.tileSize;
        
        gp.obj[8] = new OBJ_Chest();
        gp.obj[8].worldX = 22 * gp.tileSize;
        gp.obj[8].worldY = 19 * gp.tileSize;
        
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 13 * gp.tileSize;
        gp.obj[0].worldY = 10 * gp.tileSize;
        
        gp.obj[3] = new OBJ_Chest();
        gp.obj[3].worldX = 26 * gp.tileSize;
        gp.obj[3].worldY = 35 * gp.tileSize;
        
        gp.obj[4] = new OBJ_Boots();
        gp.obj[4].worldX = 7 * gp.tileSize;
        gp.obj[4].worldY = 12 * gp.tileSize;
        
    }
}
