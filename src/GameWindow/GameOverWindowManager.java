package GameWindow;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindowManager {
    private GameOverWindow gameOverWindow;

    public GameOverWindow getGameOverWindow() {
        return gameOverWindow;
    }

    private static GameOverWindowManager ourInstance = new GameOverWindowManager();

    public static GameOverWindowManager getInstance() {
        return ourInstance;
    }

    private GameOverWindowManager() {
        gameOverWindow = new GameOverWindow();
    }
}
