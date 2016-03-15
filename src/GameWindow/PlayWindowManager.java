package GameWindow;

import GameObject.Cloud;
import GameObject.MenuButton;
import GameObject.Mountain;
import GameObject.Obstacles.Land;
import GameObject.Obstacles.Obstacle;

import java.util.Vector;

/**
 * Created by AsusA42F on 3/14/2016.
 */
public class PlayWindowManager {
    private PlayWindow playWindow;
    private Mountain mountain;
    private Cloud cloud;
    private MenuButton menuButton;
    private Vector<Obstacle> obstacleVector;

    public PlayWindow getPlayWindow() {
        return playWindow;
    }

    public Vector<Obstacle> getObstacleVector() {
        return obstacleVector;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public MenuButton getMenuButton() {
        return menuButton;
    }

    private static PlayWindowManager ourInstance = new PlayWindowManager();

    public static PlayWindowManager getInstance() {
        return ourInstance;
    }

    private PlayWindowManager() {
        obstacleVector = new Vector<>();
        obstacleVector.add(new Land(100, 500));
        obstacleVector.add(new Land(600, 300));
        mountain = new Mountain(0, 100);
        cloud = new Cloud(502, 150);
        menuButton = new MenuButton(900, 50);

        playWindow = new PlayWindow();
    }

}
