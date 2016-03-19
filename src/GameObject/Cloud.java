package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by TuấnCon on 3/14/2016.
 */
public class Cloud extends GameObject {
    public Cloud(int positionX, int positionY) {
        super(positionX, positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.CLOUD)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
