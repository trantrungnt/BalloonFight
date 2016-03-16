package GameWindow;

import GameObject.Cloud;
import GameObject.MenuButton;
import GameObject.Mountain;
import GameObject.Obstacles.Island;
import GameObject.Obstacles.Lake;
import GameObject.Obstacles.Land;
import GameObject.Obstacles.Obstacle;
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
    private Vector<Obstacle> obstacleIsland;


    public PlayWindow getPlayWindow() {
        return playWindow;
    }

    public Vector<Obstacle> getObstacleVector() {
        return obstacleVector;
    }


    public Vector<Obstacle> getObstacleLake() {
        return obstacleLake;
    }
    public Vector<Obstacle> getObstacleIsland() {return obstacleIsland; }

//    public Mountain getMountain() {
//        return mountain;
//    }



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

        obstacleVector.add(new Land(850, 450));
        obstacleVector.add(new Land(830, 450));
        obstacleVector.add(new Land(810, 450));
        obstacleVector.add(new Land(870, 450));
        obstacleVector.add(new Land(890, 450));
        obstacleVector.add(new Land(790, 450));
        obstacleVector.add(new Land(770, 450));

        obstacleVector.add(new Land(770, 360));
        obstacleVector.add(new Land(850, 300));

        obstacleVector.add(new Land(150, 420));
        obstacleVector.add(new Land(170, 420));
        obstacleVector.add(new Land(190, 420));
        obstacleVector.add(new Land(210, 420));
        obstacleVector.add(new Land(230, 420));
        obstacleVector.add(new Land(250, 420));
        obstacleVector.add(new Land(270, 420));

        obstacleVector.add(new Land(250, 350));
        obstacleVector.add(new Land(160, 260));

        obstacleLake = new Vector<>();
        obstacleLake.add(new Lake(0, 450));

        obstacleIsland.add(new Island(50, 450));


        obstacleVector = new Vector<>();
        obstacleVector.add(new Land(100, 500));
        obstacleVector.add(new Land(600, 300));


        mountain = new Mountain(0, 100);
        cloud = new Cloud(502, 150);
        menuButton = new MenuButton(900, 50);

        playWindow = new PlayWindow();
    }

}


