package GameObject;

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
    private Animation animation;

    public PlayerAbstract(int positionX, int positionY) {
        super(positionX, positionY);
    }

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
}
