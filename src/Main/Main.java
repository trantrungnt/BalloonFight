package Main;

import GameWindow.GameWindow;
import GameWindow.MenuWindowManager;
import GameWindow.WindowManager;

import java.util.Stack;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class Main {
    public static Stack<GameWindow> gameWindowStack = new Stack<>();

    public static void main(String[] args) {
        gameWindowStack.add(MenuWindowManager.getInstance().getMenuWindow());
        Thread thread1 = new Thread(WindowManager.getInstance().getWindow());
        thread1.start();
    }
}
