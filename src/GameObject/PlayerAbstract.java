package GameObject;

/**
 * Created by Admin on 3/14/2016.
 */
public abstract class PlayerAbstract extends GameObject{
    protected int moveSpeed;
    protected int maxSpeed;
    protected int health;

    public int getmoveSpeed() {
        return moveSpeed;
    }

    public void setmoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getmaxSpeed() {
        return maxSpeed;
    }

    public void setmaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int gethealth() {
        return health;
    }

    public void sethealth(int health) {
        this.health = health;
    }
}
