package GameWindow;

import GameObject.*;
import GameObject.Obstacles.Obstacle;
import Main.Resources;
import Sound.JavaxSound;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by AsusA42F on 3/13/2016.
 */
public class PlayWindow extends GameWindow implements KeyListener {
    //private Vector<Obstacle> obstacleVector = new Vector<>();
    private JavaxSound javaxSound = new JavaxSound();

    public PlayWindow() {
        //dang ky de lang nghe su kien keyboard
        WindowManager.getInstance().getWindow().addKeyListener(this);
    }

    @Override
    public void draw(Graphics g) {
        PlayWindowManager.getInstance().getMountain().draw(g);
        PlayWindowManager.getInstance().getCloud().draw(g);
        PlayWindowManager.getInstance().getMenuButton().draw(g);
        for (Obstacle obstacleLand : PlayWindowManager.getInstance().getObstacleVectorLand()) {
            obstacleLand.draw(g);
        }

        for (int i = 0; i < (PlayWindowManager.getInstance().getObstacleLake().size() - 1) / 2; i++) {
            PlayWindowManager.getInstance().getObstacleLake().get(i).draw(g);
        }

        PlayManager.getInstance().getPlayerKey().draw(g);

        for (Enemy enemy : EnemyManager.getInstance().getEnemyVector()) {
            enemy.draw(g);
        }

        for (Laser laser : NewEnemyManager.getInstance().getLaserVector()) {
            laser.draw(g);
        }

        for (NewEnemy newEnemy : NewEnemyManager.getInstance().getNewEnemyVector()) {
            newEnemy.draw(g);
        }

        for (int j = (PlayWindowManager.getInstance().getObstacleLake().size() - 1) / 2; j < PlayWindowManager.getInstance().getObstacleLake().size(); j++) {
            PlayWindowManager.getInstance().getObstacleLake().get(j).draw(g);
        }

        PlayManager.getInstance().getPlayerTwice().draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (PlayManager.getInstance().getPlayerKey().getDirectionY() == 0) {
            PlayManager.getInstance().getPlayerKey().setSpeedY(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) { //nhan phim mui ten trai de di sang trai
            PlayManager.getInstance().getPlayerKey().setDirectionX(-1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { //nhan phim mui ten hphai de sang phai
            PlayManager.getInstance().getPlayerKey().setDirectionX(1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) { //nhan phim mui ten xuong de di xuong
            PlayManager.getInstance().getPlayerKey().setDirectionY(1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) { //nhan phim mui ten len de bat dau bay
            PlayManager.getInstance().getPlayerKey().setDirectionY(-1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        //////////////////////////////////////////////////////////////////////
        if (PlayManager.getInstance().getPlayerTwice().getDirectionY() == 0) {
            PlayManager.getInstance().getPlayerTwice().setSpeedY(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_A) //nhan phim A thi di dang trai
        {
            PlayManager.getInstance().getPlayerTwice().setDirectionX(-1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_D) //nhan phim D de di sang phai
        {
            PlayManager.getInstance().getPlayerTwice().setDirectionX(1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_W) //nhan phim W de di bay len
        {
            PlayManager.getInstance().getPlayerTwice().setDirectionY(-1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_S) //nhan phim S de di xuong duoi
        {
            PlayManager.getInstance().getPlayerTwice().setDirectionY(1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PlayManager.getInstance().getPlayerKey().setDirectionX(0);
        PlayManager.getInstance().getPlayerKey().setDirectionY(0);
        PlayManager.getInstance().getPlayerKey().setSpeedX(0);
        PlayManager.getInstance().getPlayerKey().setSpeedY(1);

        PlayManager.getInstance().getPlayerTwice().setDirectionX(0);
        PlayManager.getInstance().getPlayerTwice().setDirectionY(0);
        PlayManager.getInstance().getPlayerTwice().setSpeedX(0);
        PlayManager.getInstance().getPlayerTwice().setSpeedY(1);
    }
}
