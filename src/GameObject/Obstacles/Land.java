package GameObject.Obstacles;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class Land extends Obstacle {
    public Land(int positionX, int positionY) {
        super(positionX, positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.LAND)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
