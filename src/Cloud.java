import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by TuấnCon on 3/14/2016.
 */
public class Cloud extends GameObject {
    private Cloud(){}

    public Cloud(int positionX, int positionY) {
            this.setPositionX(positionX);
            this.setPositionY(positionY);
            try {
                setSprite(ImageIO.read(new File(Resources.CLOUD)));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    @Override
    public void draw(Graphics g) {
        g.drawImage(this.getSprite(), this.getPositionX(), this.getPositionY(), null);


    }
}
