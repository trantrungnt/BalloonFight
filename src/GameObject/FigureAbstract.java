package GameObject;

import java.awt.*;

/**
 * Created by TuấnCon on 3/14/2016.
 */
public abstract class FigureAbstract extends GameObject {
    private int speed;
    public abstract void update();
    public abstract void move();
    public abstract void move( int x, int y );
    public abstract void draw(Graphics g);
}
