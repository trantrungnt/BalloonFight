package GameObject;

import java.awt.*;

/**
 * Created by Admin on 3/14/2016.
 */
public class Player extends FigureAbstract  {
    private int direction;
    public Player(int positionX, int positionY, int moveSpeed){
        setPositionX(positionX);
        setPositionY(positionY);
        setmoveSpeed(moveSpeed);
    }

    private void moveByKey(){
        if(this.direction == 1){
            setPositionX(getPositionX() - getmoveSpeed());
        }
        else if(this.direction == 2){
            setPositionY(getPositionY() + getmoveSpeed());
        }
        else if(this.direction == 3){
            setPositionX(getPositionX() + getmoveSpeed());
        }
        else if(this.direction == 4){
            setPositionY(getPositionY() - getmoveSpeed());
        }
        else if(this.direction == 5){
            setPositionY(getPositionY() - getmaxSpeed());
        }
    }


    public void update(){
        this.moveByKey();
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(), getPositionX(), getPositionY(), null);
    }



    public int getdirection() {
        return direction;
    }

    public void setdirection(int direction) {
        this.direction = direction;
    }
}
