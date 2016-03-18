package GameObject;

import Main.Resources;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * Created by Admin on 3/19/2016.
 */
public class GameOverButton extends GameObject {
    public GameOverButton(int positionX, int positionY){
        super(positionX, positionY);
        try{
            setSprite(ImageIO.read(new File(Resources.GAME_OVER_BUTTON)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
