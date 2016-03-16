package GameWindow;

import GameObject.*;
import Main.Helper;
import Main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by AsusA42F on 3/13/2016.
 */
public class PlayWindow extends GameWindow implements KeyListener /*MouseListener,*/{
    private Mountain mountain = new Mountain(0, Helper.WINDOW_HEIGHT - 204);
    private Land land1 = new Land(100, 500);
    private Land land2 = new Land(600, 300);
    private Cloud cloud = new Cloud(502, 150);
    private MenuButton menuButton = new MenuButton(900, 50);

    public PlayWindow() {

        /*WindowManager.getInstance().getWindow().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuButton menuButton = PlayWindowManager.getInstance().getPlayWindow().getMenuButton();
                if (menuButton.getPositionX() <= e.getX() && e.getX() <= menuButton.getPositionX() + menuButton.getSprite().getWidth()
                        && menuButton.getPositionY() <= e.getY() && e.getY() <= menuButton.getPositionY() + menuButton.getSprite().getHeight()) {
                    if (Main.gameWindowStack.size() > 1) {
                        Main.gameWindowStack.pop();
                    }
                } else {
                    Main.gameWindowStack.add(GameOverWindowManager.getInstance().getGameOverWindow());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {



            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });*/

        //dang ky de lang nghe su kien keyboard
        WindowManager.getInstance().getWindow().addKeyListener(this);

    }

    @Override
    public void draw(Graphics g) {
        mountain.draw(g);
        land1.draw(g);
        land2.draw(g);
        cloud.draw(g);
        menuButton.draw(g);
        PlayManager.getInstance().getPlayerKey().draw(g);
    }

    public Mountain getMountain() {
        return mountain;
    }

    public Land getLand1() {
        return land1;
    }

    public Land getLand2() {
        return land2;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public MenuButton getMenuButton() {
        return menuButton;
    }

    /*@Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }*/




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){ //nhan phim a de di sang trai
            PlayManager.getInstance().getPlayerKey().setdirection(4);
        }

        if(e.getKeyCode() == KeyEvent.VK_W){ //nhan phim W de di len
            PlayManager.getInstance().getPlayerKey().setdirection(2);
        }

         if(e.getKeyCode() == KeyEvent.VK_D){ //nhan phim d de sang phai
             PlayManager.getInstance().getPlayerKey().setdirection(3);
        }

        if(e.getKeyCode()==KeyEvent.VK_S){ //nhan phim s de di xuong
            PlayManager.getInstance().getPlayerKey().setdirection(1);

        }

        if(e.getKeyCode() == KeyEvent.VK_Z){ //nhan phim x de bat dau bay
            PlayManager.getInstance().getPlayerKey().setdirection(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PlayManager.getInstance().getPlayerKey().setdirection(0);
    }


}

