package GameWindow;

import GameObject.AuthorButton;
import GameObject.MenuTitle;
import GameObject.Mountain;
import GameObject.Obstacles.Island;
import GameObject.Obstacles.Lake;
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
    private AuthorButton authorButton;
    private Vector<Obstacle> obstacleIsland;
    private Vector<Obstacle> obstacleLake;
    private Mountain mountain;

    public Vector<Obstacle> getObstacleIsland() {
        return obstacleIsland;
    }

    public Vector<Obstacle> getObstacleLake() {
        return obstacleLake;
    }

    public MenuWindow getMenuWindow() {
        return menuWindow;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public MenuTitle getMenuTitle() {
        return menuTitle;
    }
    public PlayButton getPlayButton() {
        return playButton;
    }

    public AuthorButton getAuthorButton() {
        return authorButton;
    }

    private static MenuWindowManager ourInstance = new MenuWindowManager();

    public static MenuWindowManager getInstance() {
        return ourInstance;
    }

    private MenuWindowManager() {
        menuWindow = new MenuWindow();
        menuTitle = new MenuTitle(256, 100);
        playButton = new PlayButton(485, 480);
        authorButton = new AuthorButton(50, 50);

        mountain = new Mountain(0, 550);

        obstacleIsland = new Vector<>();
        obstacleIsland.add(new Island(660, 625));
        obstacleIsland.add(new Island(580, 625));
        obstacleIsland.add(new Island(500, 625));
        obstacleIsland.add(new Island(420, 625));
        obstacleIsland.add(new Island(340, 625));
        obstacleIsland.add(new Island(260, 625));

        obstacleLake = new Vector<>();
//        obstacleLake.add(new Lake(450, 630));
        obstacleLake.add(new Lake(350, 640));
        obstacleLake.add(new Lake(640, 640));
        obstacleLake.add(new Lake(0, 640));
//        obstacleLake.add(new Lake(450, 680));
        obstacleLake.add(new Lake(320, 680));
        obstacleLake.add(new Lake(640, 680));
        obstacleLake.add(new Lake(0, 680));




    }
}
