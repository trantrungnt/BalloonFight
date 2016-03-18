package GameWindow;

import GameObject.GameObject;
import Main.Resources;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Admin on 3/17/2016.
 */
public class AuthorWindow extends GameWindow {
    private BufferedImage sprite;

    public AuthorWindow (int positionX, int positionY){
        try{
            setSprite(ImageIO.read(new File(Resources.DETAIL)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        AuthorWindowManager.getInstance().getAuthorWindow().draw(g);
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
