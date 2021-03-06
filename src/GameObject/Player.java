package GameObject;

import GameObject.Obstacles.Obstacle;
import GameWindow.GameOverWindowManager;
import GameWindow.PlayWindowManager;
import GameWindow.WindowManager;
import Main.GameManager;
import Main.Helper;
import Main.Resources;
import Sound.JavaxSound;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 3/14/2016.
 */
public class Player extends PlayerAbstract {
    private int flip1;
    private int flip2;
    private int count = 0;
    /*
        Ve anh dung chieu: g.drawImage(image, x, y, width, height, null);
        Ve anh doi xung (theo chieu thang dung): g.drawImage(image, x + width, y, -width, height, null);
        flip1 = x hoac x + width
        flip2 = width hoac -width
    * */
    //private Clip clipSoundGameOver;

    public Player(int positionX, int positionY, int speed, int typePlayer) {
        super(positionX, positionY);
        setSpeed(speed);
        setHealth(2);
        setTypePlayer(typePlayer);

        switch (typePlayer) {
            case 1:
                  /* Xet anh tinh cho Player (hinh dau tien trong anh dong) */
                try {
                    BufferedImage bigImage = ImageIO.read(new File(Resources.PLAYER_ANIMATION)); // doc SpriteSheet anh dong
                    setSprite(bigImage.getSubimage(0, 0, 50, 61));
                    BufferedImage dieImage = ImageIO.read(new File(Resources.PLAYER_DIE));
                    setSprite(dieImage.getSubimage(0, 0, 50, 75));
                    setBayHaiBongTinh(bigImage.getSubimage(0, 0, 50, 61)); //lay anh dau tien lam anh tinh
                    setBayMotBongTinh(bigImage.getSubimage(150, 0, 50, 61));
                    setPlayDieTinh(dieImage.getSubimage(0, 0, 50, 75));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /* Xet anh dong cho Player */
                this.setBayHaiBongDong(new Animation(Resources.PLAYER_ANIMATION, 50, 61, 1, 3, 170));
                this.setBayMotBongDong(new Animation(Resources.PLAYER_ANIMATION, 50, 61, 4, 6, 170));
                this.setPlayerDie(new Animation(Resources.PLAYER_DIE, 50, 75, 1, 3, 170));
                this.flip1 = this.getPositionX();
                this.flip2 = this.getSprite().getWidth();
                break;
            case 2:
                try {
                    BufferedImage bigImagePlayTwice = ImageIO.read(new File(Resources.PLAYER_TWICE_AMINATION)); // doc SpriteSheet anh dong
                    setSprite(bigImagePlayTwice.getSubimage(0, 0, 50, 61));
                    BufferedImage dieImage = ImageIO.read(new File(Resources.PLAYER_DIE));
                    setSprite(dieImage.getSubimage(0, 0, 50, 75));
                    setBayHaiBongTinh(bigImagePlayTwice.getSubimage(0, 0, 50, 61)); //lay anh dau tien lam anh tinh
                    setBayMotBongTinh(bigImagePlayTwice.getSubimage(150, 0, 50, 61));
                    setPlayDieTinh(dieImage.getSubimage(0, 0, 50, 75));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /* Xet anh dong cho Player */
                this.setBayHaiBongDong(new Animation(Resources.PLAYER_TWICE_AMINATION, 50, 61, 1, 3, 170));
                this.setBayMotBongDong(new Animation(Resources.PLAYER_TWICE_AMINATION, 50, 61, 4, 6, 170));
                this.setPlayerDie(new Animation(Resources.PLAYER_DIE, 50, 75, 1, 3, 170));
                this.flip1 = this.getPositionX();
                this.flip2 = this.getSprite().getWidth();
                break;
        }
        //JavaxSound javaxSound = new JavaxSound();
        //clipSoundGameOver = javaxSound.playWAV(Resources.SOUND_GAME_OVER);
    }

    private void moveByKey() {
        if (this.getDirectionY() == 1) { // di xuong duoi
            setSpeedX(0);
            setSpeedY(getSpeed());
        } else if (this.getDirectionY() == -1) { // de bay len
            setSpeedX(0);
            setSpeedY(-getSpeed());
        }
        if (this.getDirectionX() == 1) { // di sang phai
            setSpeedX(getSpeed());
        } else if (this.getDirectionX() == -1) { //di sang trai
            setSpeedX(-getSpeed());
        }
    }

    private void checkObstacle() {
        Rectangle rectPlayer = new Rectangle(this.getPositionX(), this.getPositionY(), this.getSprite().getWidth(), this.getSprite().getHeight());
        boolean isOnObstacle = false;
        Rectangle rectObstacle;
        for (Obstacle obstacle : PlayWindowManager.getInstance().getObstacleVectorLand()) {
            /* Xet va cham voi mep tren vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY(), obstacle.getSprite().getWidth(), Helper.EPS);
            if (rectPlayer.intersects(rectObstacle) && Math.abs(obstacle.getPositionY() - this.getPositionY() - this.getSprite().getHeight()) <= Helper.EPS) {
                if (getDirectionY() != -1) { // neu khong nhay
                    setDirectionY(0);
                    setSpeedY(0);
                    isOnObstacle = true;
                    break;
                }
            }
        }

        if (isOnObstacle == false && getDirectionY() == 0) {
            setSpeedY(1);
        } else if (isOnObstacle) {
            return;
        }

        for (Obstacle obstacle : PlayWindowManager.getInstance().getObstacleVectorLand()) {
            /* Xet va cham voi mep trai vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY(), Helper.EPS, obstacle.getSprite().getHeight());
            if (rectPlayer.intersects(rectObstacle)) {
                setDirectionX(0);
                setSpeedX(0);
                break;
            }

            /* Xet va cham voi mep phai vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX() + obstacle.getSprite().getWidth(), obstacle.getPositionY(),
                    Helper.EPS, obstacle.getSprite().getHeight());
            if (rectPlayer.intersects(rectObstacle)) {
                setDirectionX(0);
                setSpeedX(0);
                break;
            }

            /* Xet va cham voi mep duoi vat can */
            rectObstacle = new Rectangle(obstacle.getPositionX(), obstacle.getPositionY() + obstacle.getSprite().getHeight(),
                    obstacle.getSprite().getWidth(), Helper.EPS);
            if (rectPlayer.intersects(rectObstacle)) {
                setDirectionY(0);
                setSpeedY(obstacle.getPositionY() + obstacle.getSprite().getHeight() - getPositionY() + Helper.BOUNCE);
                break;
            }
        }

        rectObstacle = new Rectangle(0, 0, Helper.WINDOW_WIDTH, Helper.EPS);
        if (rectPlayer.intersects(rectObstacle)) {
            setDirectionY(0);
            setSpeedY(- getPositionY() + Helper.BOUNCE);
        }

        rectObstacle = new Rectangle(0, 0, Helper.EPS, Helper.WINDOW_HEIGHT);
        if (rectPlayer.intersects(rectObstacle)) {
            setSpeedX(-getPositionX() + Helper.BOUNCE);
        }

        rectObstacle = new Rectangle(Helper.WINDOW_WIDTH - Helper.EPS, 0, Helper.EPS, Helper.WINDOW_HEIGHT);
        if (rectPlayer.intersects(rectObstacle)) {
            setSpeedX(-getPositionX() + Helper.WINDOW_WIDTH - this.getSprite().getWidth() - Helper.EPS - Helper.BOUNCE);
        }
    }

    private void checkVaCham() {
        Rectangle rectPlayer = new Rectangle(this.getPositionX(), this.getPositionY(), this.getSprite().getWidth(), Helper.EPS);
        for (Enemy enemy : EnemyManager.getInstance().getEnemyVector()) {
            Rectangle rectEnemy = new Rectangle(enemy.getPositionX(), enemy.getPositionY() + enemy.getSprite().getHeight() - Helper.EPS,
                    enemy.getSprite().getWidth(), Helper.EPS);
            if (rectEnemy.intersects(rectPlayer)) {
                this.setPositionY(this.getPositionY() + Helper.BOUNCE);
                if (this.getHealth() > 0 && count == 0) {
                    count = Helper.PROTECT_DELAY;
                    this.setHealth(this.getHealth() - 1);
                    WindowManager.getInstance().getWindow().getClipSoundBalloonExplode().start();
                }
            }
        }
        if (count > 0) {
            count--;
        }

        rectPlayer = new Rectangle(this.getPositionX(), this.getPositionY(), this.getSprite().getWidth(), this.getSprite().getHeight());
        for (Laser laser : NewEnemyManager.getInstance().getLaserVector()) {
            Rectangle rectLaser = new Rectangle(laser.getPositionX(), laser.getPositionY(),
                    laser.getSprite().getWidth(), laser.getSprite().getHeight());
            if (rectLaser.intersects(rectPlayer)) {
                setHealth(0);
                WindowManager.getInstance().getWindow().getClipSoundBalloonExplode().start();
                break;
            }
        }
    }

    public void update() {
        this.moveByKey();
        if (this.getHealth() > 0) {
            this.checkObstacle();
        }
        setPositionX(getPositionX() + getSpeedX());
        setPositionY(getPositionY() + getSpeedY());
        if (this.getHealth() > 0) {
            this.checkVaCham();
            if (this.getHealth() == 0 || this.getPositionY() >= Helper.WATER_LEVEL) {
                try {
                    Thread.sleep(Helper.PLAYER_DEATH_DELAY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                PlayManager.getInstance().getPlayerVector().remove(this);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        if (this.getDirectionY() == -1) {
            if (this.getDirectionX() == 1) {
                this.flip1 = this.getPositionX() + this.getSprite().getWidth();
                this.flip2 = -this.getSprite().getWidth();
            } else if (this.getDirectionX() == -1) {
                this.flip1 = this.getPositionX();
                this.flip2 = this.getSprite().getWidth();
            }
            if (this.getHealth() == 2) {
                this.getBayHaiBongDong().draw(g, this.flip1, this.positionY, this.flip2, getSprite().getHeight());
            } else if (this.getHealth() == 1) {
                this.getBayMotBongDong().draw(g, this.flip1, this.positionY, this.flip2, getSprite().getHeight());
            } else if (this.getHealth() == 0) {
                this.getPlayerDie().draw(g, this.flip1, this.positionY, this.flip2, getSprite().getHeight());
            }
        } else {
            if (this.getDirectionX() == 1) { // di sang phai
                this.flip1 = getPositionX() + getSprite().getWidth();
                this.flip2 = -getSprite().getWidth();
            } else if (this.getDirectionX() == -1) { // di sang trai
                this.flip1 = getPositionX();
                this.flip2 = getSprite().getWidth();
            }
            if (this.getHealth() == 2) {
                g.drawImage(this.getBayHaiBongTinh(), this.flip1, this.positionY, this.flip2, getSprite().getHeight(), null);
            } else if (this.getHealth() == 1) {
                g.drawImage(this.getBayMotBongTinh(), this.flip1, this.positionY, this.flip2, getSprite().getHeight(), null);
            } else if (getHealth() == 0) {
                g.drawImage(this.getPlayDieTinh(), this.flip1, this.positionY, this.flip2, getSprite().getHeight(), null);
            }
        }
    }
}
