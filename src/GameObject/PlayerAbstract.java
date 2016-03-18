package GameObject;

import java.awt.image.BufferedImage;

/**
 * Created by Admin on 3/14/2016.
 */
public abstract class PlayerAbstract extends GameObject {
    private int speedX;
    private int speedY;
    private int speed;
    private int health; // so bong con lai
    private int directionX;
    private int directionY;
    private Animation bayHaiBongDong;
    private Animation bayMotBongDong;
    private BufferedImage bayHaiBongTinh;
    private BufferedImage bayMotBongTinh;

    public PlayerAbstract(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public Animation getBayHaiBongDong() {
        return bayHaiBongDong;
    }

    public void setBayHaiBongDong(Animation bayHaiBongDong) {
        this.bayHaiBongDong = bayHaiBongDong;
    }

    public Animation getBayMotBongDong() {
        return bayMotBongDong;
    }

    public void setBayMotBongDong(Animation bayMotBongDong) {
        this.bayMotBongDong = bayMotBongDong;
    }

    public BufferedImage getBayHaiBongTinh() {
        return bayHaiBongTinh;
    }

    public void setBayHaiBongTinh(BufferedImage bayHaiBongTinh) {
        this.bayHaiBongTinh = bayHaiBongTinh;
    }

    public BufferedImage getBayMotBongTinh() {
        return bayMotBongTinh;
    }

    public void setBayMotBongTinh(BufferedImage bayMotBongTinh) {
        this.bayMotBongTinh = bayMotBongTinh;
    }
}
