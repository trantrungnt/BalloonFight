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

import static Main.Helper.WINDOW_WIDTH;

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
    private int count = 0;

    public Enemy(int positionX, int positionY, int Speed) {
        super(positionX, positionY);
        setSpeed(Speed);
        setHealth(2);

        animationCurrent = getEnemyAmiantionBlowingBalloon();
        try {
            BufferedImage Enemy_Die = ImageIO.read(new File(Resources.ENEMY_DIE));
            setDie(Enemy_Die.getSubimage(0, 0, 25, 25));
        } catch (IOException e) {
            e.printStackTrace();

        }

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
                    obstacle.getSprite().getWidth(), 1);
            if (rectEnemy.intersects(rectObstacle)) {
                setSpeedY(1);
                break;
            }
        }
    }

    private void checkCollisionEnemyPlayer() {

        Rectangle rectPlayer = new Rectangle(
                PlayManager.getInstance().getPlayerKey().getPositionX(),
                PlayManager.getInstance().getPlayerKey().getPositionY() + PlayManager.getInstance().getPlayerKey().getSprite().getHeight() - Helper.EPS,
                PlayManager.getInstance().getPlayerKey().getSprite().getWidth(),
                Helper.EPS);
        Rectangle rectEnemy = new Rectangle(this.getPositionX(), this.getPositionY(), this.getSprite().getWidth(), this.getSprite().getHeight());

        //va cham voi bong Enemy
        if (rectEnemy.intersects(rectPlayer)) {
            if (this.getHealth() == 2) {
                setHealth(getHealth() - 1);
                if (this.getHealth() == 1) {
                    setHealth(getHealth() - 1);
                }
            }
        }

        rectPlayer = new Rectangle(
                PlayManager.getInstance().getPlayerTwice().getPositionX(),
                PlayManager.getInstance().getPlayerTwice().getPositionY() + PlayManager.getInstance().getPlayerTwice().getSprite().getHeight() - Helper.EPS,
                PlayManager.getInstance().getPlayerTwice().getSprite().getWidth(),
                Helper.EPS);
        rectEnemy = new Rectangle(this.getPositionX(), this.getPositionY(), this.getSprite().getWidth(), this.getSprite().getHeight());

        //va cham voi bong Enemy
        if (rectEnemy.intersects(rectPlayer)) {
            if (this.getHealth() == 2) {
                setHealth(getHealth() - 1);
                if (this.getHealth() == 1) {
                    setHealth(getHealth() - 1);
                }
            }
        }
    }

    public void move() {
        this.positionX += this.getSpeedX();

        if (this.positionX <= 0) {
            setSpeedX(+1);
        }
        if (this.positionX >= WINDOW_WIDTH - Helper.ENEMY_WIDTH) {
            setSpeedX(-1);
        }
        if (this.getHealth() == 0) {
            setSpeedY(10);
            this.positionY += this.getSpeedY();
        }
        ;


        // this.positionY-=1;


    }

    public void draw(Graphics g) {
        if (this.getSpeedX() > 0) {
            {
                this.flip1 = this.getPositionX() + this.getSprite().getWidth();
                this.flip2 = -this.getSprite().getWidth();
            }
        } else {
            this.flip1 = this.getPositionX();
            this.flip2 = this.getSprite().getWidth();
            animationCurrent.draw(g, this.flip1, this.positionX, this.flip2, this.getSprite().getHeight());
        }
        animationCurrent.draw(g, this.flip1, this.positionY, this.flip2, this.getSprite().getHeight());
        //this.getAnimation().draw(g,this.flip1,this.positionX,this.flip2,this.getSprite().getHeight());
        if (this.getHealth() == 0) {
            g.drawImage(this.getDie(), this.flip1, this.positionY, this.flip2, getSprite().getHeight(), null);
        }
    }


    public void update() {
        //check thoi gian bom bong
        this.checkObstacle1();
        count++;
        if (count >= 60) {
            animationCurrent = getAnimationBayHaiBong();
            this.move();
            if (this.getHealth() == 2) {
                animationCurrent = getAnimationBayHaiBong();
            } else if (this.getHealth() == 1) {
                animationCurrent = getAnimationBayMotBong();
            }
        }
        this.checkCollisionEnemyPlayer();


        if (count >= 60) {
            if (this.getHealth() == 2) {
                animationCurrent = getAnimationBayHaiBong();
            } else if (this.getHealth() == 1) {
                animationCurrent = getAnimationBayMotBong();

            }

        }

    }

    //ham kiem tra Bom Bong: khi den anh thu 7 thi bom bong xong
    public boolean isFinishPumpBalloon() {
        boolean check = false;

        int count = 0;

        for (int i = 0; i < this.getAnimation().vecFrame.size(); i++) {
            count++;
            if (count == (this.getAnimation().vecFrame.size() - 1)) {
                check = true;
                break;
            }
        }


        return check;
    }

    private Animation getAnimationBayMotBong() {
        try {

            BufferedImage Image = ImageIO.read(new File(Resources.ENEMY_ANIMATION));
            setSprite(Image.getSubimage(180, 360, 60, 60));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Animation(Resources.ENEMY_ANIMATION, 60, 60, 4, 6, 70);
    }

    //get anh dong khi Enemy bay
    private Animation getAnimationBayHaiBong() {
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
    private Animation getEnemyAmiantionBlowingBalloon() {
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
