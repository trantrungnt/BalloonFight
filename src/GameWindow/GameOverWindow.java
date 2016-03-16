package GameWindow;

import GameObject.AgainButton;

import java.awt.*;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindow extends GameWindow {
    public GameOverWindow() {

    }

    @Override
    public void draw(Graphics g) {
        GameOverWindowManager.getInstance().getAgainButton().draw(g);
    }
}
