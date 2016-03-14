package GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Main.*;
import GameObject.*;

/**
 * Created by AsusA42F on 3/13/2016.
 */
public class GameWindow extends Frame implements Runnable {
    private Graphics seconds;
    private Image image;
    private BufferedImage background;

    public GameWindow() {
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
    }

    //Game Loop
    //Vong Lap game
    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
