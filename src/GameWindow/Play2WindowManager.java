package GameWindow;

import GameObject.Cafe;
import GameObject.Ink;

import javax.sql.rowset.CachedRowSet;

/**
 * Created by Admin on 3/19/2016.
 */
public class Play2WindowManager {
    private Play2Window play2Window;
    private Ink ink;
    private Cafe cafe;


    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public void reset(){
        ink = new Ink(100, 100);
        cafe = new Cafe(200, 250);
    }
    public Play2WindowManager(){
        this.reset();
        play2Window = new Play2Window();

    }


}
