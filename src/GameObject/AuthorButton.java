package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Admin on 3/17/2016.
 */
public class AuthorButton extends GameObject {
    public AuthorButton(int positionX, int positionY) {
        super(positionX, positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.AUTHOR_BUTTON)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
