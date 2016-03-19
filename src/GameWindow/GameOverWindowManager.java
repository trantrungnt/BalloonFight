package GameWindow;

import GameObject.AgainButton;
import GameObject.MenuButton;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindowManager {
    private GameOverWindow gameOverWindow;
    private AgainButton againButton;
    private MenuButton menuButton;

    public GameOverWindow getGameOverWindow() {
        return gameOverWindow;
    }

    public AgainButton getAgainButton() {
        return againButton;
    }

    public MenuButton getMenuButton() {
        return menuButton;
    }

    private static GameOverWindowManager ourInstance = new GameOverWindowManager();

    public static GameOverWindowManager getInstance() {
        return ourInstance;
    }

    private GameOverWindowManager() {
        gameOverWindow = new GameOverWindow();
        againButton = new AgainButton(256, 600);
        menuButton = new MenuButton(700, 50);


    }
}
