package GameWindow;

import GameObject.NewEnemy;
import GameObject.NewEnemyManager;
import GameObject.Obstacles.Obstacle;
import GameObject.PlayManager;
import GameObject.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Admin on 3/19/2016.
 */
public class Play2Window extends GameWindow implements KeyListener {
    public Play2Window play2Window;
    public Play2Window(){

    }

    @Override
    public void draw(Graphics g) {
        Play2WindowManager.getInstance().getCafe().draw(g);
        Play2WindowManager.getInstance().getInk().draw(g);
        Play2WindowManager.getInstance().getCloud().draw(g);
        Play2WindowManager.getInstance().getMountain().draw(g);
        for (Obstacle obstacleLand : PlayWindowManager.getInstance().getObstacleVectorLand()) {
            obstacleLand.draw(g);
        }

        for (int i = 0; i < (PlayWindowManager.getInstance().getObstacleLake().size() - 1) / 2; i++) {
            PlayWindowManager.getInstance().getObstacleLake().get(i).draw(g);
        }
        for (Player player : PlayManager.getInstance().getPlayerVector()) {
            player.draw(g);
        }

        for (NewEnemy newEnemy : NewEnemyManager.getInstance().getNewEnemyVector()) {
            newEnemy.draw(g);
        }

        for (int j = (PlayWindowManager.getInstance().getObstacleLake().size() - 1) / 2; j < PlayWindowManager.getInstance().getObstacleLake().size(); j++) {
            PlayWindowManager.getInstance().getObstacleLake().get(j).draw(g);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
