package GameWindow;

import GameObject.Cloud;
import GameObject.MenuButton;
import GameObject.Mountain;
import GameObject.Obstacles.Lake;
import GameObject.Obstacles.Land;
import GameObject.Obstacles.Island;
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
    private Vector<Obstacle> obstacleVectorLand;
    private Vector<Obstacle> obstacleLake;
    private Vector<Obstacle> obstacleIsland;


    public PlayWindow getPlayWindow() {
        return playWindow;
    }

    public Vector<Obstacle> getObstacleVectorLand() {
        return obstacleVectorLand;
    }

    public Vector<Obstacle> getObstacleLake() {
        return obstacleLake;
    }
    public Vector<Obstacle> getObstacleIsland(){
        return obstacleIsland;
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
        obstacleVectorLand = new Vector<>();

        obstacleVectorLand.add(new Land(850, 450));
        obstacleVectorLand.add(new Land(830, 450));
        obstacleVectorLand.add(new Land(810, 450));
        obstacleVectorLand.add(new Land(870, 450));
        obstacleVectorLand.add(new Land(890, 450));
        obstacleVectorLand.add(new Land(790, 450));
        obstacleVectorLand.add(new Land(770, 450));

        obstacleVectorLand.add(new Land(770, 350));
        obstacleVectorLand.add(new Land(850, 270));

        obstacleVectorLand.add(new Land(150, 420));
        obstacleVectorLand.add(new Land(170, 420));
        obstacleVectorLand.add(new Land(190, 420));
        obstacleVectorLand.add(new Land(210, 420));
        obstacleVectorLand.add(new Land(230, 420));
        obstacleVectorLand.add(new Land(250, 420));
        obstacleVectorLand.add(new Land(270, 420));

        obstacleVectorLand.add(new Land(250, 320));
        obstacleVectorLand.add(new Land(160, 240));

//        obstacleVectorLand.add(new Land(100, 500));
//        obstacleVectorLand.add(new Land(600, 300));

        obstacleLake = new Vector<>();
        obstacleLake.add(new Lake(450, 640));
        obstacleLake.add(new Lake(150, 640));
//        obstacleLake.add(new Lake(640, 630));
//        obstacleLake.add(new Lake(0, 630));
        obstacleLake.add(new Lake(450, 680));
        obstacleLake.add(new Lake(200, 680));
        obstacleLake.add(new Lake(640, 672));
        obstacleLake.add(new Lake(0, 675));
        obstacleLake.add(new Lake(200, 700));
        obstacleLake.add(new Lake(640, 700));
        obstacleLake.add(new Lake(0, 700));


        obstacleIsland = new Vector<>();
        obstacleIsland.add(new Island(900, 630));
        obstacleIsland.add(new Island(810, 630));
        obstacleIsland.add(new Island(55, 630));
        obstacleIsland.add(new Island(0, 630));

        mountain = new Mountain(0, 550);
        cloud = new Cloud(502, 150);
        menuButton = new MenuButton(900, 50);

        playWindow = new PlayWindow();
    }


}


