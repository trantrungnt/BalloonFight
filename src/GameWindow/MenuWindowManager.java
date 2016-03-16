package GameWindow;

import GameObject.MenuTitle;
import GameObject.Obstacles.Island;
import GameObject.Obstacles.Obstacle;
import GameObject.PlayButton;

import java.util.Vector;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class MenuWindowManager {
    private MenuWindow menuWindow;
    private MenuTitle menuTitle;
    private PlayButton playButton;
    private Vector<Obstacle> obstacleIsland;

    public Vector<Obstacle> getObstacleIsland() {
        return obstacleIsland;
    }

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
        playButton = new PlayButton(485, 480);

        obstacleIsland = new Vector<>();
        obstacleIsland.add(new Island(100, 600));
    }
}
