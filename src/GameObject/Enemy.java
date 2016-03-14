package GameObject;

import Main.Helper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by TuấnCon on 3/14/2016.
 */
public class Enemy extends FigureAbstract {
    private int direction;

    public Enemy( int positionX, int positionY, int moveSpeed){
        this.positionX=positionX;
        this.positionY=positionY;
        this.moveSpeed=moveSpeed;
        try{
            this.sprite= ImageIO.read(new File("Resources.Enemy"));

        }catch (IOException e){
            e.printStackTrace();

        }



    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void move() {
            this.moveSpeed += this.moveSpeed;
            if (this.positionX <= 0) {
                this.moveSpeed = -this.getmoveSpeed();
            }
            if (this.positionX >= Helper.WINDOW_WIDTH) {
                this.moveSpeed = -this.moveSpeed;
            }

    }


    public void update(){
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(),getPositionX(),getPositionY(),null);

    }
}
