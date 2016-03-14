package GameWindow;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class WindowManager {
    private Window window;

    public Window getWindow() {
        return window;
    }

    private static WindowManager ourInstance = new WindowManager();

    public static WindowManager getInstance() {
        return ourInstance;
    }

    private WindowManager() {
        window = new Window();
    }
}
