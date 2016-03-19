package GameWindow;

import Main.Resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class GameOverWindow extends GameWindow {
    private BufferedImage gameOver;

    public GameOverWindow() {
        try {
            gameOver = ImageIO.read(new File(Resources.GAME_OVER_BUTTON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void draw(Graphics g) {
        GameOverWindowManager.getInstance().getAgainButton().draw(g);
        g.drawImage(gameOver, 300, 300, null);
    }
}
