package GameWindow;

import GameObject.*;
import GameObject.Obstacles.Island;
import GameObject.Obstacles.Lake;
import GameObject.Obstacles.Obstacle;

import java.util.Vector;

/**
 * Created by Admin on 3/19/2016.
 */
public class Play2WindowManager {
    private Play2Window play2Window;
    private Ink ink;
    private Cafe cafe;
    private Mountain mountain;
    private Cloud cloud;
    private MenuButton menuButton;
    private Vector<Obstacle> obstacleVector;
    private Vector<Obstacle> obstacleLake;


    private static Play2WindowManager ourInstance = new Play2WindowManager();

    public static Play2WindowManager getInstance() {
        return ourInstance;
    }

    private Play2WindowManager() {
        this.reset();
        play2Window = new Play2Window();
    }

    public void reset() {

        obstacleVector = new Vector<>();
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

        ink = new Ink(100, 100);
        cafe = new Cafe(200, 250);

    }

    public Play2Window getPlay2Window() {
        return play2Window;
    }

    public void setPlay2Window(Play2Window play2Window) {
        this.play2Window = play2Window;
    }

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    public MenuButton getMenuButton() {
        return menuButton;
    }

    public void setMenuButton(MenuButton menuButton) {
        this.menuButton = menuButton;
    }

    public Vector<Obstacle> getObstacleVector() {
        return obstacleVector;
    }

    public void setObstacleVector(Vector<Obstacle> obstacleVector) {
        this.obstacleVector = obstacleVector;
    }

    public Vector<Obstacle> getObstacleLake() {
        return obstacleLake;
    }

    public void setObstacleLake(Vector<Obstacle> obstacleLake) {
        this.obstacleLake = obstacleLake;
    }


}
