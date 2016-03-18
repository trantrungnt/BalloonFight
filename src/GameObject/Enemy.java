package GameObject;

import GameObject.Obstacles.Obstacle;
import GameWindow.PlayWindowManager;
import Main.Helper;
import Main.Resources;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Main.Helper.*;

/**
 * Created by TuấnCon on 3/14/2016.
 */
public class Enemy extends EnemyAbstract {
    private int flip1;
    private int flip2;
    private Animation animationCurrent;
    private Animation animationBomBong;
    private Animation animationBayMotBong;
    private Animation animationBayHaiBong;
    private Animation animationBayVoiDu;
    private int count=0;

    public Enemy(int positionX, int positionY, int Speed) {
        super(positionX, positionY);
        setSpeed(Speed);
        setHealth(2);

        animationCurrent = getEnemyAmiantionBlowingBalloon();

        this.flip1 = this.getPositionX();
        this.flip2 = this.getSprite().getWidth();
        this.setSpeedX(1);
        this.setSpeedY(1);
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
                    obstacle.getSprite().getWidth(),1);
            if (rectEnemy.intersects(rectObstacle)) {
                setSpeedY(1);
                break;
            }
        }}

    public void move() {
        this.positionX += this.getSpeedX();
        if (this.positionX<=0) {
           setSpeedX(+1);
        }
        if (this.positionX>=WINDOW_WIDTH-Helper.ENEMY_WIDTH ) {
            setSpeedX(-1);
        }

       // this.positionY-=1;


    }

    public void draw(Graphics g){
        if (this.getSpeedX() > 0) {{
            this.flip1 = this.getPositionX() + this.getSprite().getWidth();
            this.flip2 = -this.getSprite().getWidth();
            }
        }
            else {
            this.flip1 = this.getPositionX();
            this.flip2 = this.getSprite().getWidth();
            }
        animationCurrent.draw(g, this.flip1, this.positionY, this.flip2, this.getSprite().getHeight());
       //this.getAnimation().draw(g,this.flip1,this.positionX,this.flip2,this.getSprite().getHeight());
    }


    public void update() {
        //check thoi gian bom bong
        this.checkObstacle1();
        count++;
        if (count>=60) {
            animationCurrent = getEnemyAminationFly();
            this.move();
        }
    }

    //ham kiem tra Bom Bong: khi den anh thu 7 thi bom bong xong
    public boolean isFinishPumpBalloon()
    {
        boolean check=false;

        int count=0;

        for (int i = 0; i < this.getAnimation().vecFrame.size();i++) {
            count++;
            if (count == (this.getAnimation().vecFrame.size()-1)) {
                check = true;
                break;
            }
        }


        return check;
    }
    private Animation getAnimationBayMotBong() {
        try {

            BufferedImage Image = ImageIO.read(new File(Resources.ENEMY_ANIMATION));
            setSprite(Image.getSubimage(0,0,60,60));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Animation(Resources.ENEMY_ANIMATION ,60,60,4,6,70);
    }

    //get anh dong khi Enemy bay
    private Animation getEnemyAminationFly()
    {
            /* Xet anh tinh cho Enemy (hinh dau tien trong anh dong) */
            try {
                BufferedImage bigImage = ImageIO.read(new File(Resources.ENEMY_ANIMATION)); // doc SpriteSheet anh dong
                setSprite(bigImage.getSubimage(0, 0, 60, 60)); //lay anh dau tien lam anh tinh
            } catch (IOException e) {
                e.printStackTrace();
            }

            /* Xet anh dong cho Enemy */
            return new Animation(Resources.ENEMY_ANIMATION, 60, 60, 1, 3, 70);
    }


    //get anh dong khi Enemy bom bong
    private Animation getEnemyAmiantionBlowingBalloon()
    {
        /* Xet anh tinh cho Enemy (hinh dau tien trong anh dong) */
        try {
            BufferedImage bigImage = ImageIO.read(new File(Resources.ENEMY_AMINATION_BLOWING_BALLOONS)); // doc SpriteSheet anh dong
            setSprite(bigImage.getSubimage(0, 0, 60, 60)); //lay anh dau tien lam anh tinh
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Xet anh dong cho Enemy */
        //this.setAnimation(new Animation(Resources.ENEMY_AMINATION_BLOWING_BALLOONS, 60, 60, 1, 8, 70));
        return new Animation(Resources.ENEMY_AMINATION_BLOWING_BALLOONS, 60, 60, 1, 8, 200);
    }

}
