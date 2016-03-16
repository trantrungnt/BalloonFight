package GameObject;

import GameObject.Obstacles.Obstacle;
import GameWindow.PlayWindowManager;
import Main.Helper;
import Main.Resources;
import com.sun.imageio.plugins.common.SubImageInputStream;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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

        /* Xet anh tinh cho Player (hinh dau tien trong anh dong) */
        try {
            BufferedImage bigImage = ImageIO.read(new File(Resources.PLAYER_ANIMATION)); // doc SpriteSheet anh dong
            setSprite(bigImage.getSubimage(0, 0, 50, 61)); //lay anh dau tien lam anh tinh
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Xet anh dong cho Player */
        this.setAnimation(new Animation(Resources.PLAYER_ANIMATION, 50, 61, 1, 3, 170));
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
    }

    private void checkObstacle() {
        Rectangle rectPlayer = new Rectangle(this.getPositionX(), this.getPositionY(), this.getSprite().getWidth(), this.getSprite().getHeight());
        boolean isOnObstacle = false;
        for (Obstacle obstacle : PlayWindowManager.getInstance().getObstacleVector()) {
            Rectangle rectObstacle;

            /* Xet va cham voi mep tren vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY(), obstacle.getSprite().getWidth(), 1);
            if (rectPlayer.intersects(rectObstacle) && Math.abs(obstacle.getPositionY() - this.getPositionY() - this.getSprite().getHeight()) <= 2) {
                if (getDirectionY() != -1) { // neu khong nhay
                    setDirectionY(0);
                    setSpeedY(0);
                    isOnObstacle = true;
                    break;
                }
            }
        }

        if (isOnObstacle == false && getDirectionY() == 0) {
            setSpeedY(1);
        } else if (isOnObstacle) {
            return;
        }

        for (Obstacle obstacle : PlayWindowManager.getInstance().getObstacleVector()) {
            Rectangle rectObstacle;

            /* Xet va cham voi mep tren vat can */
            /*rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY(), obstacle.getSprite().getWidth(), 10);
            if (rectPlayer.intersects(rectObstacle) && obstacle.getPositionY() == this.getPositionY() + this.getSprite().getHeight()) {
                System.out.println("Zzz");
                if (getDirectionY() != -1) { // neu khong nhay
                    setDirectionY(0);
                    setSpeedY(0);
                    isOnObstacle = true;
                    break;
                }
            }*/

            /* Xet va cham voi mep trai vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY(), 1, obstacle.getSprite().getHeight());
            if (rectPlayer.intersects(rectObstacle)) {
                setDirectionX(0);
                setSpeedX(0);
                break;
            }

            /* Xet va cham voi mep phai vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX() + obstacle.getSprite().getWidth(), obstacle.getPositionY(),
                    1, obstacle.getSprite().getHeight());
            if (rectPlayer.intersects(rectObstacle)) {
                setDirectionX(0);
                setSpeedX(0);
                break;
            }

            /* Xet va cham voi mep duoi vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY() + obstacle.getSprite().getHeight(),
                    obstacle.getSprite().getWidth(), 1);
            if (rectPlayer.intersects(rectObstacle)) {
                setDirectionY(0);
                setSpeedY(1);
                break;
            }
        }
    }

    public void update() {
        this.moveByKey();
        this.checkObstacle();
        setPositionX(getPositionX() + getSpeedX());
        setPositionY(getPositionY() + getSpeedY());
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
