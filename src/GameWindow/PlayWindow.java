package GameWindow;

import GameObject.Animation;
import GameObject.EnemyManager;
import GameObject.Obstacles.Obstacle;
import GameObject.PlayManager;
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
//        for (Obstacle obstacleIsland: PlayWindowManager.getInstance().getObstacleIsland()){
//            obstacleIsland.draw(g);
//        }

        for (int i = 0; i < (PlayWindowManager.getInstance().getObstacleLake().size() - 1)/2; i++){
            PlayWindowManager.getInstance().getObstacleLake().get(i).draw(g);
        }

        PlayManager.getInstance().getPlayerKey().draw(g);

        //animation_current = EnemyManager.getInstance().getEnemy3().getEnemyAmiantionBlowingBalloon();
        EnemyManager.getInstance().getEnemy3().draw(g);

        //EnemyManager.getInstance().getEnemy3().draw(g);
        for (int j = (PlayWindowManager.getInstance().getObstacleLake().size() - 1)/2; j< (PlayWindowManager.getInstance().getObstacleLake().size()-1); j++){
            PlayWindowManager.getInstance().getObstacleLake().get(j).draw(g);
        }

        PlayWindowManager.getInstance().getObstacleLake().get(PlayWindowManager.getInstance().getObstacleLake().size() - 1).draw(g);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (PlayManager.getInstance().getPlayerKey().getDirectionY() == 0) {
            PlayManager.getInstance().getPlayerKey().setSpeedY(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_A) { //nhan phim a de di sang trai
            PlayManager.getInstance().getPlayerKey().setDirectionX(-1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_D) { //nhan phim d de sang phai
            PlayManager.getInstance().getPlayerKey().setDirectionX(1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_S) { //nhan phim s de di xuong
            PlayManager.getInstance().getPlayerKey().setDirectionY(1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
        }

        if (e.getKeyCode() == KeyEvent.VK_Z) { //nhan phim z de bat dau bay
            PlayManager.getInstance().getPlayerKey().setDirectionY(-1);
            javaxSound.playWAV(Resources.SOUND_PLAYER_FLY).start();
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
