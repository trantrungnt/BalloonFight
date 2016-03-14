package GameWindow;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class MenuWindowManager {
    private MenuWindow menuWindow;

    public MenuWindow getMenuWindow() {
        return menuWindow;
    }

    private static MenuWindowManager ourInstance = new MenuWindowManager();

    public static MenuWindowManager getInstance() {
        return ourInstance;
    }

    private MenuWindowManager() {
        menuWindow = new MenuWindow();
    }
}
