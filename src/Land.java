import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class Land extends GameObject {
    private Land() {

    }

    public Land(int positionX, int positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
        try {
            setSprite(ImageIO.read(new File(Resources.LAND)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(this.getSprite(), this.getPositionX(), this.getPositionY(), null);
    }
}