package GameObject;

import java.awt.image.BufferedImage;

/**
 * Created by TuấnCon on 3/14/2016.
 */
public abstract class EnemyAbstract extends GameObject {
    private int speedX;
    private int speedY;
    private int speed;
    private int health; // so bong con lai
    private int directionX;
    private int directionY;
    private Animation animation;
    private BufferedImage Die;

    public BufferedImage getDie() {
        return Die;
    }

    public void setDie(BufferedImage die) {
        Die = die;
    }

    public EnemyAbstract(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }


}
