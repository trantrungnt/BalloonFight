package GameWindow;

import GameObject.*;
import Main.Helper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by AsusA42F on 3/13/2016.
 */
public class PlayWindow extends GameWindow implements KeyListener {
    private Mountain mountain = new Mountain(0, 100);
    private Land land1 = new Land(100, 500);
    private Land land2 = new Land(600, 300);
    private Cloud cloud = new Cloud(502, 150);
    private MenuButton menuButton = new MenuButton(900, 50);

    public PlayWindow() {
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
        EnemyManager.getInstance().getEnemy1().draw(g);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) { //nhan phim a de di sang trai
            PlayManager.getInstance().getPlayerKey().setDirection(4);
        }

        if (e.getKeyCode() == KeyEvent.VK_W) { //nhan phim W de di len
            PlayManager.getInstance().getPlayerKey().setDirection(2);
        }

        if (e.getKeyCode() == KeyEvent.VK_D) { //nhan phim d de sang phai
            PlayManager.getInstance().getPlayerKey().setDirection(3);
        }

        if (e.getKeyCode() == KeyEvent.VK_S) { //nhan phim s de di xuong
            PlayManager.getInstance().getPlayerKey().setDirection(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_Z) { //nhan phim x de bat dau bay
            PlayManager.getInstance().getPlayerKey().setDirection(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PlayManager.getInstance().getPlayerKey().setDirection(0);
    }
}
