package GameWindow;

import GameObject.AgainButton;

import java.awt.*;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindow extends GameWindow {
    private AgainButton againButton = new AgainButton(256, 600);

    public GameOverWindow() {

    }

    @Override
    public void draw(Graphics g) {
        againButton.draw(g);
    }

    public AgainButton getAgainButton() {
        return againButton;
    }
}
