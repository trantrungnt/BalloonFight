package GameWindow;

import GameObject.MenuTitle;
import GameObject.PlayButton;

import java.awt.*;

/**
 * Created by AsusA42F on 3/13/2016.
 */

public class MenuWindow extends GameWindow {
    private MenuTitle menuTitle = new MenuTitle(256, 100);
    private PlayButton playButton = new PlayButton(420, 600);

    public MenuWindow() {

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
}
