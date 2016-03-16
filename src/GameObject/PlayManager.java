package GameObject;

/**
 * Created by TrungNT on 3/16/2016.
 */
public class PlayManager {
    private static PlayManager _sharePointer;

    public Player getPlayerKey() {
        return playerKey;
    }

    private Player playerKey;

    private PlayManager()
    {
        playerKey = new Player(400, 400, 2);
    }

    public static PlayManager getInstance(){
        if(_sharePointer == null){
            _sharePointer = new PlayManager();
        }
        return _sharePointer;
    }
}
