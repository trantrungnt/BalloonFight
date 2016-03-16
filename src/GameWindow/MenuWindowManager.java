package GameWindow;

import GameObject.MenuTitle;
import GameObject.PlayButton;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class MenuWindowManager {
    private MenuWindow menuWindow;
    private MenuTitle menuTitle;
    private PlayButton playButton;

    public MenuWindow getMenuWindow() {
        return menuWindow;
    }

    public MenuTitle getMenuTitle() {
        return menuTitle;
    }

    public PlayButton getPlayButton() {
        return playButton;
    }

    private static MenuWindowManager ourInstance = new MenuWindowManager();

    public static MenuWindowManager getInstance() {
        return ourInstance;
    }

    private MenuWindowManager() {
        menuWindow = new MenuWindow();
        menuTitle = new MenuTitle(256, 100);
        playButton = new PlayButton(420, 600);
    }
}
