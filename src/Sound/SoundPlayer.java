package Sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Created by Admin on 3/13/2016.
 */
public class SoundPlayer {

    Clip clip;
    public SoundPlayer(String s){
        try{
            AudioInputStream ais =
                    AudioSystem.getAudioInputStream(
                        getClass().getResourceAsStream(
                            s
                        )
            );

            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFomat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais =
                    AudioSystem.getAudioInputStream(
                            decodeFomat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        if(clip == null) return;
        stop();
        clip.setFramePosition(0);
        clip.start();
    }
    public void stop(){
        if(clip.isRunning()) clip.stop();
    }

    public void close(){
        stop();
        clip.close();
    }
}
