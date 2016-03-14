package GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import Main.*;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class MenuTitle extends GameObject {
    private MenuTitle() {

    }

    public MenuTitle(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.MENU_TITLE)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(this.getSprite(), this.getPositionX(), this.getPositionY(), null);
    }
}
