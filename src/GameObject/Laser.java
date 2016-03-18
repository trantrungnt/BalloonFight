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
        this.setSpeed(3);
        try {
            setSprite(ImageIO.read(new File(Resources.LASER)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g) {
        g.drawImage(this.sprite,(int)this.positionX, (int)this.positionY, null);
    }
    public void move() {
        this.positionX += this.getSpeed();

    }
    public  void update(){
        move();
    }
}
