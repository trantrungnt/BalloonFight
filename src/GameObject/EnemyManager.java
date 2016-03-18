package GameObject;

/**
 * Created by TuấnCon on 3/15/2016.
 */
public class EnemyManager {
    private static EnemyManager _sharePointer;
    private Enemy Enemy1,Enemy2, Enemy3;
    public Enemy getEnemy1() {
        return Enemy1;
    }
    public Enemy getEnemy2() {
        return Enemy2;
    }
    public Enemy getEnemy3() {
        return Enemy3;
    }


    private EnemyManager()
    {
        Enemy1 = new Enemy(250, 250, 1);
        Enemy2 = new Enemy(350, 400, 1);
        Enemy3 = new Enemy(190, 355, 1);
    }


    public static EnemyManager getInstance(){
        if(_sharePointer == null){
            _sharePointer = new EnemyManager();
        }
        return _sharePointer;
    }
}
