package GameWindow;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class PlayWindowManager {
    private PlayWindow playWindow;

    public PlayWindow getPlayWindow() {
        return playWindow;
    }

    private static PlayWindowManager ourInstance = new PlayWindowManager();

    public static PlayWindowManager getInstance() {
        return ourInstance;
    }

    private PlayWindowManager() {
        playWindow = new PlayWindow();
    }
}
