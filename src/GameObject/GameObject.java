package GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import Main.*;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public abstract class GameObject {
    protected int positionX;
    protected int positionY;
    public BufferedImage sprite;

    public abstract void draw(Graphics g);

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