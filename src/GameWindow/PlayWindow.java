package GameWindow;

import java.awt.*;
import Main.*;
import GameObject.*;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class PlayWindow extends GameWindow {
    private Mountain mountain = new Mountain(0, Helper.WINDOW_HEIGHT - 204);
    private Land land1 = new Land(100, 500);
    private Land land2 = new Land(600, 300);
    private Cloud cloud =new Cloud(502,150);

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        mountain.draw(g);
        land1.draw(g);
        land2.draw(g);
        cloud.draw(g);
    }
}

