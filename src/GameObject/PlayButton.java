package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class PlayButton extends GameObject {
    private PlayButton() {

    }

    public PlayButton(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.PLAY_BUTTON)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
