package GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public abstract class GameObject {
    protected int positionX;
    protected int positionY;
    public BufferedImage sprite;

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private GameObject() {

    }

    public GameObject(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void draw(Graphics g) {
        g.drawImage(this.getSprite(), this.getPositionX(), this.getPositionY(), null);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}