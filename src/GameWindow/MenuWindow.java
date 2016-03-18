package GameWindow;

import GameObject.Obstacles.Obstacle;

import java.awt.*;

/**
 * Created by AsusA42F on 3/13/2016.
 */

public class MenuWindow extends GameWindow {
    public MenuWindow() {
    }

    @Override
    public void draw(Graphics g) {
        MenuWindowManager.getInstance().getMountain().draw(g);
        MenuWindowManager.getInstance().getMenuTitle().draw(g);
        MenuWindowManager.getInstance().getPlayButton().draw(g);
        MenuWindowManager.getInstance().getAuthorButton().draw(g);

        for (Obstacle obstacleLake : MenuWindowManager.getInstance().getObstacleLake()){
            obstacleLake.draw(g);
        }
        for(Obstacle obstacleIsland : MenuWindowManager.getInstance().getObstacleIsland()){
            obstacleIsland.draw(g);
        }

    }
}
