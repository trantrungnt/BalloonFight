package GameObject;

import Main.Helper;

import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by TrungNT on 3/16/2016.
 */
public class PlayManager {
    private static PlayManager _sharePointer;

    private LinkedList<Player> playerVector = new LinkedList<>();

    public LinkedList<Player> getPlayerVector() {
        return playerVector;
    }

    public void setPlayerVector(LinkedList playerVector) {
        this.playerVector = playerVector;
    }

    public void reset() {
        playerVector.clear();
        playerVector.add(new Player(150, 406 - Helper.PLAYER_HEIGHT, 2, 1));
        playerVector.add(new Player(175, 406 - Helper.PLAYER_HEIGHT, 2, 2));
    }

    private PlayManager() {
        reset();
    }

    public static PlayManager getInstance() {
        if (_sharePointer == null) {
            _sharePointer = new PlayManager();
        }
        return _sharePointer;
    }
}
