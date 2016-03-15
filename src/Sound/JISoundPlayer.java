package Sound;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by TrungNT on 3/16/2016.
 */


public class JISoundPlayer {
    //dung thu vien JLayer javazoom.ji doc cac file mp3 dang effect cua Game

    public void playmp3(String dir) {
        try {
            File file = new File(dir);
            FileInputStream fis = null;
            fis = new FileInputStream(file);


            Player player = null;
            try {
                player = new Player(fis);
                player.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
