package GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by AsusA42F on 3/15/2016.
 */
public class Animation {
    BufferedImage bigImage;
    Vector<Image> vecFrame;
    int countTime;
    int index;
    int delta;

    /*
        dirImage: duong dan anh (bigImage)
        width: chieu rong anh nho
        height: chieu cao anh nho
        number: so luong anh nho
        delta: khoang cach
    * */
    public Animation(String dirImage, int width, int height, int first, int last, int delta) {
        this.delta = delta;
        countTime = 0;
        vecFrame = new Vector<>();
        index = 0;
        int count = 0; // dem thu tu anh
        try {
            bigImage = ImageIO.read(new File(dirImage));
            for (int i = 0; i < (int) (bigImage.getHeight() / height); i++) {
                for (int j = 0; j < (int) bigImage.getWidth() / width; j++) {
                    count++;
                    if (first <= count && count <= last) {
                        Image img = bigImage.getSubimage(j * width, i * height, width, height);
                        vecFrame.add(img);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void draw(Graphics g, int x, int y, int width, int height) {
        g.drawImage(vecFrame.get(index), x, y, width, height, null);
        countTime += 17;
        if (countTime >= delta) {
            countTime = 0;
            index++;
            if (index >= vecFrame.size()) {
                index = 0;
            }
        }
    }
}