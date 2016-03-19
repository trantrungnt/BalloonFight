package GameObject;

import Main.Resources;
import javax.imageio.ImageIO;
import java.io.File;


/**
 * Created by Admin on 3/19/2016.
 */
public class Cafe extends GameObject {
    public Cafe (int positionX, int positionY){
        super(positionX, positionY);
        try{
            setSprite(ImageIO.read(new File(Resources.CAFE)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
