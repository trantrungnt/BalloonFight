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
    private int direction;
    private int flip1;
    private int flip2;

    private Player() {
        setPositionX(0);
        setPositionY(0);
        setMoveSpeed(0);
        setMaxSpeed(0);
    }

    public Player(int positionX, int positionY, int moveSpeed) {
        setPositionX(positionX);
        setPositionY(positionY);
        this.flip1 = getPositionX();
        this.flip2 = getSprite().getWidth();
        setMoveSpeed(moveSpeed);
        setMaxSpeed(3);
        try {
            setSprite(ImageIO.read(new File(Resources.PLAYER)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setAnimation(new Animation(Resources.PLAYER_ANIMATION, 50, 75, 1, 3, 170));
    }

    private void moveByKey() {
        if (this.direction == 1) { //nhan s de di xuong duoi
            this.positionY += this.moveSpeed;
        }

        if (this.direction == 2) {
            this.positionY -= this.moveSpeed;
        }

        if (this.direction == 3) {
            this.positionX += this.moveSpeed;
        }

        if (this.direction == 4) {
            this.positionX -= this.moveSpeed;
        }

        if (this.direction == 5) {
            this.positionY -= this.maxSpeed;
        }
    }


    public void update() {
        this.moveByKey();
    }

    @Override
    public void draw(Graphics g) {
        if (this.direction == 5) {
            this.animation.draw(g, this.positionX, this.positionY);
        } else {
            if (this.direction == 3) {
                this.flip1 = getPositionX() + getSprite().getWidth();
                this.flip2 = -getSprite().getWidth();
            } else if (this.direction == 4) {
                this.flip1 = getPositionX();
                this.flip2 = getSprite().getWidth();
            }
            g.drawImage(this.sprite, this.flip1, this.positionY, this.flip2, getSprite().getHeight(), null);
        }
            /*if (this.direction == 3 || this.direction == 4) {
                g.drawImage(this.sprite, this.flip1, this.positionY, this.flip2, getSprite().getHeight(), null);
            } else if (this.direction == 1 || this.direction == 2) {
                g.drawImage(this.sprite, this.flip1, this.positionY, this.flip2, getSprite().getHeight(), null);*/
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}