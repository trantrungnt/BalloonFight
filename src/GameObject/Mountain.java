package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class Mountain extends GameObject {
    private Mountain() {

    }

    public Mountain(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.MOUNTAIN)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
