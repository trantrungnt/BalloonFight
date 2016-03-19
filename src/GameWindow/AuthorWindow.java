package GameWindow;

import Main.Resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Admin on 3/17/2016.
 */
public class AuthorWindow extends GameWindow {
    private BufferedImage author;

    public AuthorWindow() {
        try {
            author = ImageIO.read(new File(Resources.DETAIL));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(author, 100, 100, null);
    }


}
