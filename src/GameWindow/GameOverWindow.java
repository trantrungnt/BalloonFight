package GameWindow;

import GameObject.AgainButton;
import Main.Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindow extends GameWindow implements MouseListener {
    private AgainButton againButton = new AgainButton(256, 600);

    public GameOverWindow() {
        WindowManager.getInstance().getWindow().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AgainButton againButton = GameOverWindowManager.getInstance().getGameOverWindow().getAgainButton();
                if (againButton.getPositionX() <= e.getX() && e.getX() <= againButton.getPositionX() + againButton.getSprite().getWidth()
                        && againButton.getPositionY() <= e.getY() && e.getY() <= againButton.getPositionY() + againButton.getSprite().getHeight()) {
                    if (Main.gameWindowStack.size() > 1) {
                        Main.gameWindowStack.pop();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    @Override
    public void draw(Graphics g) {
        againButton.draw(g);
    }

    public AgainButton getAgainButton() {
        return againButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
