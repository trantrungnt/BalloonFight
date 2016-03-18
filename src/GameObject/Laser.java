package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by AsusA42F on 3/19/2016.
 */
public class Laser extends GameObject {
    public Laser(int positionX, int positionY) {
        super(positionX, positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.LASER)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
