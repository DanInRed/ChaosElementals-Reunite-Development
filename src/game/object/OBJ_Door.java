
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 25, 2026
 */
package game.object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{
    
    public OBJ_Door(){
        String path = "/game/resources/objects/";
        name = "Door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream(path + "door.png"));
        }catch(IOException e){
            System.out.println("Error at OBJ_Door");
            e.printStackTrace();
        }
        collision = true;
    }
}
