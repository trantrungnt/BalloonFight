package GameWindow;

import GameObject.AgainButton;
import GameObject.GameOverButton;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindowManager {
    private GameOverWindow gameOverWindow;
    private AgainButton againButton;
    private GameOverButton gameOverButton;

    public GameOverWindow getGameOverWindow() {
        return gameOverWindow;
    }

    public AgainButton getAgainButton() {
        return againButton;
    }

    public GameOverButton getGameOverButton() {
        return gameOverButton;
    }

    private static GameOverWindowManager ourInstance = new GameOverWindowManager();

    public static GameOverWindowManager getInstance() {
        return ourInstance;
    }

    private GameOverWindowManager() {
        gameOverWindow = new GameOverWindow();
        againButton = new AgainButton(256, 600);
        gameOverButton = new GameOverButton(300, 300);

    }
}
