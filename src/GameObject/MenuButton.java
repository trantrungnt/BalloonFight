package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class MenuButton extends GameObject {
    private MenuButton() {

    }

    public MenuButton(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.MENU_BUTTON)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
