
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 25, 2026
 */
package game.object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Chest extends SuperObject{
    public OBJ_Chest(){
        String path = "/game/resources/objects/";
        name = "Chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream(path + "chest.png"));
        }catch(IOException e){
            System.out.println("Error at OBJ_Chest");
            e.printStackTrace();
        }
        collision = true;
    }
}
