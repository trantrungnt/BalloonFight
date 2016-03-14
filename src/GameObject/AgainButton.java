package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class AgainButton extends GameObject {
    private AgainButton() {

    }

    public AgainButton(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.AGAIN_BUTTON)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
