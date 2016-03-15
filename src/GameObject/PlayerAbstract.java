package GameObject;

/**
 * Created by Admin on 3/14/2016.
 */
public abstract class PlayerAbstract extends GameObject {
    protected int moveSpeed; // toc do di chuyen binh thuong
    protected int maxSpeed; // toc do khi bay (an Z)
    protected int health;
    protected Animation animation;

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
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

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
}
