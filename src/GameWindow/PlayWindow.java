package GameWindow;

import GameObject.*;
import GameObject.Obstacles.Land;
import GameObject.Obstacles.Obstacle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;


/**
 * Created by AsusA42F on 3/13/2016.
 */
public class PlayWindow extends GameWindow implements KeyListener {
    //private Vector<Obstacle> obstacleVector = new Vector<>();

    public PlayWindow() {
        //dang ky de lang nghe su kien keyboard
        WindowManager.getInstance().getWindow().addKeyListener(this);
    }

    @Override
    public void draw(Graphics g) {
        PlayWindowManager.getInstance().getMountain().draw(g);
        for (Obstacle obstacle : PlayWindowManager.getInstance().getObstacleVector()) {
            obstacle.draw(g);
        }
        PlayWindowManager.getInstance().getCloud().draw(g);
        PlayWindowManager.getInstance().getMenuButton().draw(g);
        PlayManager.getInstance().getPlayerKey().draw(g);
        EnemyManager.getInstance().getEnemy1().draw(g);
        EnemyManager.getInstance().getEnemy2().draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) { //nhan phim a de di sang trai
            PlayManager.getInstance().getPlayerKey().setDirectionX(-1);
        }

        if (e.getKeyCode() == KeyEvent.VK_D) { //nhan phim d de sang phai
            PlayManager.getInstance().getPlayerKey().setDirectionX(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_S) { //nhan phim s de di xuong
            PlayManager.getInstance().getPlayerKey().setDirectionY(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_Z) { //nhan phim z de bat dau bay
            PlayManager.getInstance().getPlayerKey().setDirectionY(-1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PlayManager.getInstance().getPlayerKey().setDirectionX(0);
        PlayManager.getInstance().getPlayerKey().setDirectionY(0);
        PlayManager.getInstance().getPlayerKey().setSpeedX(0);
        PlayManager.getInstance().getPlayerKey().setSpeedY(1);
    }
}
