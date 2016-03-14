package GameWindow;

import java.awt.*;
import Main.*;
import GameObject.*;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class MenuWindow extends GameWindow {
    private MenuTitle menuTitle;
    private Button playButton;

    public MenuWindow() {
        menuTitle = new MenuTitle(256, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        menuTitle.draw(g);
    }
}
