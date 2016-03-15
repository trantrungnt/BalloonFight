package GameWindow;

import GameObject.AgainButton;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindowManager {
    private GameOverWindow gameOverWindow;
    private AgainButton againButton;

    public GameOverWindow getGameOverWindow() {
        return gameOverWindow;
    }

    public AgainButton getAgainButton() {
        return againButton;
    }

    private static GameOverWindowManager ourInstance = new GameOverWindowManager();

    public static GameOverWindowManager getInstance() {
        return ourInstance;
    }

    private GameOverWindowManager() {
        gameOverWindow = new GameOverWindow();
        againButton = new AgainButton(256, 600);
    }
}
