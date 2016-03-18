package GameWindow;

import GameObject.*;
import GameObject.MenuButton;
import GameObject.PlayButton;
import Main.GameManager;
import Main.Helper;
import Main.Resources;
import Sound.JavaxSound;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by AsusA42F on 3/13/2016.
 */
public class Window extends Frame implements Runnable, MouseListener {
    private Graphics seconds;
    private Image image;
    private BufferedImage background;
    private static Clip clipSoundMain;
    private static Clip clipSoundMenu;
    private static Clip clipSoundGameOver;

    public Window() {
        //thiet lap tieu de cho cua so
        this.setTitle("Balloon Fight - Cuộc chiến khinh khí cầu");
        //thiet lap kich thuoc cho cua so
        this.setSize(Helper.WINDOW_WIDTH, Helper.WINDOW_HEIGHT);
        GameManager.getInstance().setWindowWidth(Helper.WINDOW_WIDTH);
        GameManager.getInstance().setWindowHeight(Helper.WINDOW_HEIGHT);
        //thiet lap xem cua so co hien thi hay khong
        this.setVisible(true);
        //khi an vao nut X thi thoat
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        try {
            background = ImageIO.read(new File(Resources.BACKGROUND));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //dang ky lang nghe su kien chuot
        this.addMouseListener(this);


        //khoi tao doi tuong javaxsound
        JavaxSound javaxSound = new JavaxSound();
        clipSoundMenu = javaxSound.playWAV(Resources.SOUND_MENU_GAME);
        clipSoundMain = javaxSound.playWAV(Resources.SOUND_MAIN_GAME);
        clipSoundGameOver = javaxSound.playWAV(Resources.SOUND_GAME_OVER);

        //goi phuong thuc chay Soudn MenuBackground
        playSoundMenu();
    }

    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        if (GameManager.getInstance().getGameWindowStack().size() > 0) {
            GameManager.getInstance().getGameWindowStack().peek().draw(g);
        }
    }

    //Game Loop
    //Vong Lap game
    @Override
    public void run() {
        while (true) {
            if (GameManager.getInstance().getGameWindowStack().peek() instanceof PlayWindow) {
                PlayManager.getInstance().getPlayerKey().update();
                for (Enemy enemy : EnemyManager.getInstance().getEnemyVector()){
                    enemy.update();
                };
                PlayManager.getInstance().getPlayerTwice().update();
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (GameManager.getInstance().getGameWindowStack().peek() instanceof MenuWindow) { // hien tai dang o Menu Window
            PlayButton playButton = MenuWindowManager.getInstance().getPlayButton();
            if (playButton.getPositionX() <= e.getX() && e.getX() <= playButton.getPositionX() + playButton.getSprite().getWidth()
                    && playButton.getPositionY() <= e.getY() && e.getY() <= playButton.getPositionY() + playButton.getSprite().getHeight()) {
                // chuyen sang Play Window khi an Play
                GameManager.getInstance().getGameWindowStack().add(PlayWindowManager.getInstance().getPlayWindow());
                clipSoundMenu.stop();
                clipSoundGameOver.stop();
                clipSoundMain.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }

        else if (GameManager.getInstance().getGameWindowStack().peek() instanceof PlayWindow) { // hien tai dang o Play Window
            MenuButton menuButton = PlayWindowManager.getInstance().getMenuButton();
            if (menuButton.getPositionX() <= e.getX() && e.getX() <= menuButton.getPositionX() + menuButton.getSprite().getWidth()
                    && menuButton.getPositionY() <= e.getY() && e.getY() <= menuButton.getPositionY() + menuButton.getSprite().getHeight()) {
                if (GameManager.getInstance().getGameWindowStack().size() > 1) {
                    // quay lai Menu Window khi an Menu
                    GameManager.getInstance().getGameWindowStack().pop();
                    clipSoundMain.stop();
                    clipSoundGameOver.stop();
                    clipSoundMenu.loop(Clip.LOOP_CONTINUOUSLY);
                }
            } else {
                // chuyen sang Game Over Window (DEBUG MODE: khi an ngoai nut Menu)
                GameManager.getInstance().getGameWindowStack().add(GameOverWindowManager.getInstance().getGameOverWindow());
                clipSoundMain.stop();
                clipSoundMenu.stop();
                clipSoundGameOver.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } else if (GameManager.getInstance().getGameWindowStack().peek() instanceof GameOverWindow) { // hien tai dang o Game Over Window
            AgainButton againButton = GameOverWindowManager.getInstance().getAgainButton();
            if (againButton.getPositionX() <= e.getX() && e.getX() <= againButton.getPositionX() + againButton.getSprite().getWidth()
                    && againButton.getPositionY() <= e.getY() && e.getY() <= againButton.getPositionY() + againButton.getSprite().getHeight()) {
                if (GameManager.getInstance().getGameWindowStack().size() > 1) {
                    // quay lai Play Window khi an Again
                    GameManager.getInstance().getGameWindowStack().pop();
                    clipSoundMenu.stop();
                    clipSoundGameOver.stop();
                    clipSoundMain.loop(Clip.LOOP_CONTINUOUSLY);
                }
            }
        }
        else if(GameManager.getInstance().getGameWindowStack().peek() instanceof MenuWindow ){ //hien tai dang o MenuWindow
            AuthorButton authorButton = MenuWindowManager.getInstance().getAuthorButton();
            if(authorButton.getPositionX() <= e.getX() && e.getX() <= authorButton.getPositionX() + authorButton.getSprite().getWidth()
                    && authorButton.getPositionY() <= e.getY() && e.getY() <= authorButton.getPositionY() + authorButton.getSprite().getHeight()){
                //chuyen sang AuthorWindow khi nhan Author
                GameManager.getInstance().getGameWindowStack().add(AuthorWindowManager.getInstance().getAuthorWindow());
            }

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

    //play Sound Menu
    private void playSoundMenu()
    {
        //kiem tra cua so hien tai co la menuGame khong va nhac chua mo thi chay nhac
        if (GameManager.getInstance().getGameWindowStack().peek() instanceof MenuWindow)
        {
            clipSoundMain.stop();
            //load file nhac nen cua Game Balloon Fight
            clipSoundMenu.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

}