package GameObject;

/**
 * Created by TuấnCon on 3/15/2016.
 */
public class EnemyManager {
    private static EnemyManager _sharePointer;
    private Enemy Enemy1;
    public Enemy getEnemy1() {
        return Enemy1;
    }
    private EnemyManager()
    {
        Enemy1   = new Enemy(250, 250, 1);
    }


    public static EnemyManager getInstance(){
        if(_sharePointer == null){
            _sharePointer = new EnemyManager();
        }
        return _sharePointer;
    }
}
