package GameWindow;

import GameObject.Cloud;
import GameObject.Ink;
import GameObject.MenuButton;
import GameObject.Mountain;
import GameObject.Obstacles.Island;
import GameObject.Obstacles.Lake;
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
    private Vector<Obstacle> obstacleLake;

    public Ink getInk() {
        return ink;
    }

    private Ink ink;

    public PlayWindow getPlayWindow() {
        return playWindow;
    }

    public void setPlayWindow(PlayWindow playWindow) {
        this.playWindow = playWindow;
    }

    public Vector<Obstacle> getObstacleVectorLand() {
        return obstacleVector;
    }

    public Vector<Obstacle> getObstacleLake() {
        return obstacleLake;
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

    public void reset() {
        obstacleVector = new Vector<>();
        obstacleVector.add(new Land(850, 450));
        obstacleVector.add(new Land(830, 450));
        obstacleVector.add(new Land(810, 450));
        obstacleVector.add(new Land(870, 450));
        obstacleVector.add(new Land(890, 450));
        obstacleVector.add(new Land(790, 450));
        obstacleVector.add(new Land(770, 450));

        obstacleVector.add(new Land(770, 350));
        obstacleVector.add(new Land(850, 270));

        obstacleVector.add(new Land(150, 420));
        obstacleVector.add(new Land(170, 420));
        obstacleVector.add(new Land(190, 420));
        obstacleVector.add(new Land(210, 420));
        obstacleVector.add(new Land(230, 420));
        obstacleVector.add(new Land(250, 420));
        obstacleVector.add(new Land(270, 420));

        obstacleVector.add(new Land(250, 320));
        obstacleVector.add(new Land(160, 240));

        obstacleVector.add(new Island(900, 630));
        obstacleVector.add(new Island(810, 630));
        obstacleVector.add(new Island(55, 630));
        obstacleVector.add(new Island(0, 630));

        obstacleLake = new Vector<>();
        obstacleLake.add(new Lake(150, 640));
        obstacleLake.add(new Lake(450, 640));
        obstacleLake.add(new Lake(0, 675));
        obstacleLake.add(new Lake(640, 672));
        obstacleLake.add(new Lake(200, 680));
        obstacleLake.add(new Lake(450, 680));
        obstacleLake.add(new Lake(0, 700));
        obstacleLake.add(new Lake(200, 700));
        obstacleLake.add(new Lake(450, 700));
        obstacleLake.add(new Lake(640, 700));


        mountain = new Mountain(0, 550);
        cloud = new Cloud(502, 150);
        menuButton = new MenuButton(900, 50);
        ink = new Ink(550, 350);
    }

    private PlayWindowManager() {
        this.reset();
        playWindow = new PlayWindow();
    }


}


