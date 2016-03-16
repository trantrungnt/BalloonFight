package GameObject.Obstacles;

import Main.Resources;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Admin on 3/16/2016.
 */
public class Island extends Obstacle {
    public Island(int positionX, int positionY){
        super(positionX, positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.ISLAND)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
