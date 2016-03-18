package GameObject;

import Main.Helper;

/**
 * Created by TrungNT on 3/16/2016.
 */
public class PlayManager {
    private static PlayManager _sharePointer;

    public Player getPlayerKey() {
        return playerKey;
    }

    private Player playerKey;

    public Player getPlayerTwice() {
        return playerTwice;
    }

    private Player playerTwice;

    private PlayManager() {
        playerKey = new Player(30, 630 - Helper.PLAYER_HEIGHT, 2);
        playerTwice = new Player(150, 406 - Helper.PLAYER_HEIGHT, 2);
    }

    public static PlayManager getInstance() {
        if (_sharePointer == null) {
            _sharePointer = new PlayManager();
        }
        return _sharePointer;
    }
}
