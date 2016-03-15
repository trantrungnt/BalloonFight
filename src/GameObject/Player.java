package GameObject;
import Main.Resources;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Created by Admin on 3/14/2016.
 */
public class Player extends PlayerAbstract  {
    private int direction;
    private Player(){
        setPositionX(0);
        setPositionY(0);
        setmoveSpeed(0);
        setmaxSpeed(0);
    }
    public Player(int positionX, int positionY, int moveSpeed){
        setPositionX(positionX);
        setPositionY(positionY);
        setmoveSpeed(moveSpeed);
        setmaxSpeed(3);

        try{
            this.sprite=ImageIO.read(new File(Resources.PLAYER));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void moveByKey(){
        if(this.direction == 1) { //nhan s de di xuong duoi
            this.positionY += this.moveSpeed;
        }


        if(this.direction == 2){
            this.positionY -=this.moveSpeed;
        }

        if(this.direction == 3){
           this.positionX +=this.moveSpeed;
        }

        if(this.direction == 4){
            this.positionX -=this.moveSpeed;
        }

        if(this.direction == 5){
           this.positionY -= this.maxSpeed;
        }
    }


    public void update(){
        this.moveByKey();

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(), getPositionX(), getPositionY(), null);
    }



    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}




