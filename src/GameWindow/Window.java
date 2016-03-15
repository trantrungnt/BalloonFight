package GameWindow;

import GameObject.*;
import Main.GameManager;
import Main.Helper;
import Main.Main;
import Main.Resources;

import javax.imageio.ImageIO;
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

        this.addMouseListener(this);
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
        if (Main.gameWindowStack.size() > 0) {
            Main.gameWindowStack.peek().draw(g);
        }
    }

    //Game Loop
    //Vong Lap game
    @Override
    public void run() {
        while (true) {
            PlayManager.getInstance().getPlayerKey().update();
            EnemyManager.getInstance().getEnemy1().update();
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
        if (Main.gameWindowStack.peek() instanceof MenuWindow) { // hien tai dang o Menu Window
            PlayButton playButton = MenuWindowManager.getInstance().getMenuWindow().getPlayButton();
            if (playButton.getPositionX() <= e.getX() && e.getX() <= playButton.getPositionX() + playButton.getSprite().getWidth()
                    && playButton.getPositionY() <= e.getY() && e.getY() <= playButton.getPositionY() + playButton.getSprite().getHeight()) {
                // chuyen sang Play Window khi an Play
                Main.gameWindowStack.add(PlayWindowManager.getInstance().getPlayWindow());
            }
        } else if (Main.gameWindowStack.peek() instanceof PlayWindow) { // hien tai dang o Play Window
            MenuButton menuButton = PlayWindowManager.getInstance().getPlayWindow().getMenuButton();
            if (menuButton.getPositionX() <= e.getX() && e.getX() <= menuButton.getPositionX() + menuButton.getSprite().getWidth()
                    && menuButton.getPositionY() <= e.getY() && e.getY() <= menuButton.getPositionY() + menuButton.getSprite().getHeight()) {
                if (Main.gameWindowStack.size() > 1) {
                    // quay lai Menu Window khi an Menu
                    Main.gameWindowStack.pop();
                }
            } else {
                // chuyen sang Game Over Window (DEBUG MODE: khi an ngoai nut Menu)
                Main.gameWindowStack.add(GameOverWindowManager.getInstance().getGameOverWindow());
            }
        } else if (Main.gameWindowStack.peek() instanceof GameOverWindow) { // hien tai dang o Game Over Window
            AgainButton againButton = GameOverWindowManager.getInstance().getGameOverWindow().getAgainButton();
            if (againButton.getPositionX() <= e.getX() && e.getX() <= againButton.getPositionX() + againButton.getSprite().getWidth()
                    && againButton.getPositionY() <= e.getY() && e.getY() <= againButton.getPositionY() + againButton.getSprite().getHeight()) {
                if (Main.gameWindowStack.size() > 1) {
                    // quay lai Play Window khi an Again
                    Main.gameWindowStack.pop();
                }
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
}