package GameObject;

/**
 * Created by Admin on 3/14/2016.
 */
public abstract class PlayerAbstract extends GameObject {
    private int speedX;
    private int speedY;
    private int speed;
    private int health;
    private Animation animation;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Animation getAnimation() {
        return animation;
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

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
