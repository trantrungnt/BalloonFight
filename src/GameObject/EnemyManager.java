package GameObject;

import Main.Helper;

import java.util.Vector;

/**
 * Created by TuấnCon on 3/15/2016.
 */
public class EnemyManager {
    private static EnemyManager _sharePointer;
    private Vector<Enemy> enemyVector = new Vector<>();

    public Vector<Enemy> getEnemyVector() {
        return enemyVector;
    }

    public void reset() {
        enemyVector.clear();
        enemyVector.add(new Enemy(800, 450 - Helper.ENEMY_HEIGHT, 1));
        enemyVector.add(new Enemy(160, 240 - Helper.ENEMY_HEIGHT, 1));
        enemyVector.add(new Enemy(250, 320 - Helper.ENEMY_HEIGHT, 1));
    }

    private EnemyManager() {
        reset();
    }


    public void setEnemyVector(Vector<Enemy> enemyVector) {
        this.enemyVector = enemyVector;
    }

    public static EnemyManager getInstance() {
        if (_sharePointer == null) {
            _sharePointer = new EnemyManager();
        }
        return _sharePointer;
    }
}