package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Admin on 3/19/2016.
 */
public class Ink extends GameObject {
    public Ink(int positionX, int positionY){
        super(positionX, positionY);
        try{
            setSprite(ImageIO.read(new File(Resources.INK)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
