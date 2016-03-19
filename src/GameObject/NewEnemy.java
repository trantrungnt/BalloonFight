package GameObject;

import GameObject.Obstacles.Obstacle;
import GameWindow.PlayWindowManager;
import Main.Helper;
import Main.Resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by AsusA42F on 3/19/2016.
 */
public class NewEnemy extends EnemyAbstract {
    private int flip1;
    private int flip2;
    private int count = 0;

    public NewEnemy(int positionX, int positionY, int Speed) {
        super(positionX, positionY);
        setSpeed(Speed);
        try {
            setSprite(ImageIO.read(new File(Resources.NEW_ENEMY)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.flip1 = this.getPositionX();
        this.flip2 = this.getSprite().getWidth();
    }

    private void checkObstacle1() {
        Rectangle rectEnemy = new Rectangle(this.getPositionX(), this.getPositionY(), this.getSprite().getWidth(), this.getSprite().getHeight());
        boolean isOnObstacle = false;
        for (Obstacle obstacle : PlayWindowManager.getInstance().getObstacleVectorLand()) {
            Rectangle rectObstacle;

            /* Xet va cham voi mep tren vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY(), obstacle.getSprite().getWidth(), 1);
            if (rectEnemy.intersects(rectObstacle) && Math.abs(obstacle.getPositionY() - this.getPositionY() - this.getSprite().getHeight()) <= 2) {
                { // neu khong nhay
                    isOnObstacle = true;
                    break;
                }
            }
        }

        for (Obstacle obstacle : PlayWindowManager.getInstance().getObstacleVectorLand()) {
            Rectangle rectObstacle;

            /* Xet va cham voi mep trai vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY(), 1, obstacle.getSprite().getHeight());
            if (rectEnemy.intersects(rectObstacle)) {

                setSpeedX(-1);
                break;
            }

            /* Xet va cham voi mep phai vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX() + obstacle.getSprite().getWidth(), obstacle.getPositionY(),
                    1, obstacle.getSprite().getHeight());
            if (rectEnemy.intersects(rectObstacle)) {
                setSpeedX(1);
                break;
            }

            /* Xet va cham voi mep duoi vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY() + obstacle.getSprite().getHeight(),
                    obstacle.getSprite().getWidth(), 1);
            if (rectEnemy.intersects(rectObstacle)) {
                setSpeedY(1);
                break;
            }
        }
    }

    public void draw(Graphics g) {
        for (Laser laser : NewEnemyManager.getInstance().getLaserVector()) {
            laser.draw(g);
        }
        g.drawImage(this.getSprite(), this.getPositionX(), this.getPositionY(), this.getSprite().getWidth(), this.getSprite().getHeight(), null);
    }


    public void shot() {
        Laser laser = new Laser(this.positionX, this.positionY);
        NewEnemyManager.getInstance().getLaserVector().add(laser);
    }

    public void move() {
        setDirectionX(0);
        setSpeedX(0);
        setPositionY(getPositionY() + getSpeedY());
        if (getPositionY() >= Helper.WINDOW_HEIGHT) {
            setDirectionY(-1);
            setSpeedY(-getSpeed());
            setPositionY(getPositionY() + getSpeedY());
        }
        if (getPositionY() <= 0) {
            setDirectionY(1);
            setSpeedY(getSpeed());
            setPositionY(getPositionY() + getSpeedY());
        }
    }

    public void update() {
        count++;
        move();
        for (Laser laser : NewEnemyManager.getInstance().getLaserVector()) {
            laser.update();
        }
        if (count >= Helper.SHOT_DELAY) {
            shot();
            count = 0;
        }
    }
}
