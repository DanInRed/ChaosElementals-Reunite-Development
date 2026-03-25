
/*
 *  Project: TestingElementalMaster
 *  Author: Dash 
 *  Date: Mar 25, 2026
 */
package game.object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Dash
 */
public class OBJ_Key extends SuperObject{
    
    public OBJ_Key(){
        String path = "/game/resources/objects/";
        name = "Key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream(path + "key.png"));
        }catch(IOException e){
            System.out.println("Error at OBJ_Key");
            e.printStackTrace();
        }
    }
    
}
