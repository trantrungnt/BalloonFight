package GameWindow;

import GameObject.AgainButton;
import Main.Resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindow extends GameWindow {
    public GameOverWindow(){

    }


    @Override
    public void draw(Graphics g) {
        GameOverWindowManager.getInstance().getAgainButton().draw(g);
        GameOverWindowManager.getInstance().getGameOverButton().draw(g);
    }
}
