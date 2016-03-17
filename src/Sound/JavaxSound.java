package Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by TrungNT on 3/16/2016.
 */
public class JavaxSound {
    private Clip oClip;
    //phuong thuc doc file sound wav dung cho background sound game
    //phuong thuc nay chi ho tro dinh dang dang file wav, au, aiff
    public Clip playWAV(String dir)
    {

        try {
            // Open an audio input stream.
            File soundFile = new File(dir);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            this.oClip = clip;


        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        return oClip;
    }
}
