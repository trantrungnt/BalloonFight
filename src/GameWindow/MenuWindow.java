package GameWindow;

import GameObject.MenuTitle;
import GameObject.PlayButton;
import Main.Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by AsusA42F on 3/13/2016.
 */

public class MenuWindow extends GameWindow implements MouseListener {
    private MenuTitle menuTitle = new MenuTitle(256, 100);
    private PlayButton playButton = new PlayButton(420, 600);

    public MenuWindow() {
        WindowManager.getInstance().getWindow().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayButton playButton = MenuWindowManager.getInstance().getMenuWindow().getPlayButton();
                if (playButton.getPositionX() <= e.getX() && e.getX() <= playButton.getPositionX() + playButton.getSprite().getWidth()
                        && playButton.getPositionY() <= e.getY() && e.getY() <= playButton.getPositionY() + playButton.getSprite().getHeight()) {
                    Main.gameWindowStack.add(PlayWindowManager.getInstance().getPlayWindow());
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
        menuTitle.draw(g);
        playButton.draw(g);
    }

    public MenuTitle getMenuTitle() {
        return menuTitle;
    }

    public PlayButton getPlayButton() {
        return playButton;
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
