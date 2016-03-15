package Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by TrungNT on 3/16/2016.
 */
public class JavaxSound {

    //phuong thuc doc file sound wav dung cho background sound game
    //phuong thuc nay chi ho tro dinh dang dang file wav, au, aiff
    public void playWAV(String dir)
    {
        try {
            // Open an audio input stream.
            File soundFile = new File(dir);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY); //lap mai mai
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
