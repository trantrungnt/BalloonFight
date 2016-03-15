package Main;

import GameWindow.GameWindow;
import GameWindow.MenuWindowManager;

import java.util.Stack;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class GameManager {
    private int locationX;
    private int locationY;
    private int windowHeight;
    private int windowWidth;

    private Stack<GameWindow> gameWindowStack = new Stack<>();

    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
        locationX = 0;
        locationY = 0;
        gameWindowStack.add(MenuWindowManager.getInstance().getMenuWindow());
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public void setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public void setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }

    public Stack<GameWindow> getGameWindowStack() {
        return gameWindowStack;
    }

    public void setGameWindowStack(Stack<GameWindow> gameWindowStack) {
        this.gameWindowStack = gameWindowStack;
    }
}