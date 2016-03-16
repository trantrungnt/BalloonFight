package GameWindow;

import GameObject.MenuTitle;
import GameObject.Obstacles.Obstacle;
import GameObject.PlayButton;
import Sound.JISoundPlayer;

import java.awt.*;

/**
 * Created by AsusA42F on 3/13/2016.
 */

public class MenuWindow extends GameWindow {
    public MenuWindow() {
    }

    @Override
    public void draw(Graphics g) {
        MenuWindowManager.getInstance().getMenuTitle().draw(g);
        MenuWindowManager.getInstance().getPlayButton().draw(g);
        for (Obstacle obstacleIsland: PlayWindowManager.getInstance().getObstacleIsland()){
            obstacleIsland.draw(g);
        }
    }
}
