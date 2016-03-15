package Main;

import GameWindow.WindowManager;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class Main {
    //public static Stack<GameWindow> gameWindowStack = new Stack<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(WindowManager.getInstance().getWindow());
        thread1.start();
    }
}
