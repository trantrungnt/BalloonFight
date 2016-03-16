package GameObject.Obstacles;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 3/16/2016.
 */
public class Lake extends Obstacle {
    public Lake (int positionX, int positionY) {
        super(positionX, positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.LAKE)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
