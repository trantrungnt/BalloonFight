package GameObject;

import java.util.Vector;

/**
 * Created by AsusA42F on 3/19/2016.
 */
public class NewEnemyManager {
    private Vector<NewEnemy> newEnemyVector = new Vector<>();
    private Vector<Laser> laserVector = new Vector<>();

    private static NewEnemyManager ourInstance = new NewEnemyManager();

    public static NewEnemyManager getInstance() {
        return ourInstance;
    }

    public void reset() {
        newEnemyVector.clear();
        laserVector.clear();
        newEnemyVector.add(new NewEnemy(1, 1, 1));
        for (NewEnemy newEnemy : newEnemyVector) {
            newEnemy.setDirectionY(1);
            newEnemy.setSpeedY(newEnemy.getSpeed());
        }
    }

    private NewEnemyManager() {
        reset();
    }

    public Vector<NewEnemy> getNewEnemyVector() {
        return newEnemyVector;
    }

    public void setNewEnemyVector(Vector<NewEnemy> newEnemyVector) {
        this.newEnemyVector = newEnemyVector;
    }

    public Vector<Laser> getLaserVector() {
        return laserVector;
    }

    public void setLaserVector(Vector<Laser> laserVector) {
        this.laserVector = laserVector;
    }
}
