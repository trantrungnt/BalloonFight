package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 3/14/2016.
 */
public class Player extends PlayerAbstract {
    private int flip1;
    private int flip2;
        /*
            Ve anh dung chieu: g.drawImage(image, x, y, width, height, null);
            Ve anh doi xung (theo chieu thang dung): g.drawImage(image, x + width, y, -width, height, null);
            flip1 = x hoac x + width
            flip2 = width hoac -width
        * */

    public Player(int positionX, int positionY, int speed) {
        super(positionX, positionY);
        setSpeed(speed);
        setHealth(2);
        try {
            setSprite(ImageIO.read(new File(Resources.PLAYER)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setAnimation(new Animation(Resources.PLAYER_ANIMATION, 50, 75, 1, 3, 170));
        this.flip1 = this.getPositionX();
        this.flip2 = this.getSprite().getWidth();
    }

    private void moveByKey() {
        if (this.getDirectionY() == 1) { // nhan s de di xuong duoi
            setSpeedX(0);
            setSpeedY(getSpeed());
        } else if (this.getDirectionY() == -1) { // nhan z de bay len
            setSpeedX(0);
            setSpeedY(-getSpeed());
        }

        if (this.getDirectionX() == 1) { // nhan d de di sang phai
            setSpeedX(getSpeed());
        } else if (this.getDirectionX() == -1) { // nhan a de di sang trai
            setSpeedX(-getSpeed());
        }

        setPositionX(getPositionX() + getSpeedX());
        setPositionY(getPositionY() + getSpeedY());
    }


    public void update() {
        this.moveByKey();
    }

    @Override
    public void draw(Graphics g) {
        if (this.getDirectionY() == -1) {
            if (this.getDirectionX() == 1) {
                this.flip1 = this.getPositionX() + this.getSprite().getWidth();
                this.flip2 = -this.getSprite().getWidth();
            } else if (this.getDirectionX() == -1) {
                this.flip1 = this.getPositionX();
                this.flip2 = this.getSprite().getWidth();
            }
            this.getAnimation().draw(g, this.flip1, this.positionY, this.flip2, getSprite().getHeight());
        } else {
            if (this.getDirectionX() == 1) { // di sang phai
                this.flip1 = getPositionX() + getSprite().getWidth();
                this.flip2 = -getSprite().getWidth();
            } else if (this.getDirectionX() == -1) { // di sang trai
                this.flip1 = getPositionX();
                this.flip2 = getSprite().getWidth();
            }
            g.drawImage(this.sprite, this.flip1, this.positionY, this.flip2, getSprite().getHeight(), null);
        }
    }
}