
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 26, 2026
 */
package game.object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Boots extends SuperObject{
    public OBJ_Boots(){
        String path = "/game/resources/objects/";
        name = "Boots";
        try{
            image = ImageIO.read(getClass().getResourceAsStream(path + "boots.png"));
        }catch(IOException e){
            System.out.println("Error at OBJ_Boots");
            e.printStackTrace();
        }
    }
}
