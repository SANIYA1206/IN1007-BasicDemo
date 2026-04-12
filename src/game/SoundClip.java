package game;

import javax.sound.sampled.*;
import java.io.File;

public class SoundClip {
    private Clip clip;

    public SoundClip(String filename) {
        try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(new File(filename));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (Exception e) {
            System.out.println("Error loading sound: " + filename);
            e.printStackTrace();
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }
}