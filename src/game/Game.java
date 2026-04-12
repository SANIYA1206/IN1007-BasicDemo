package game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game {

    public static int score = 0;
    public static int lives = 3;

    public static final float SCROLL_SPEED = 4.0f;
    public static final float RESPAWN_X = 22.0f;
    public static final float MIN_Y = -2.5f;
    public static final float MAX_Y = 7.5f;

    public static final Random RNG = new Random();

    private GameLevel level;
    private final JFrame frame;
    private final SkyView view;
    private int time = 0;

    // Background music
    private SoundClip backgroundMusic;

    public Game() {

        // Start at Level 1
        level = new Level1(this);


        view = new SkyView(level, 800, 500, this);


        frame = new JFrame("Flappy Plane");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);


        frame.addKeyListener(new PlaneController(level.getPlane()));


        level.start();


        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
                view.repaint();
            }
        });
        timer.start();

        // =============================
        // Start Background Music
        // =============================
        backgroundMusic = new SoundClip("data/background.wav");
        backgroundMusic.loop();
    }


    public void goNextLevel() {
        GameLevel next = level.getNextLevel();


        if (next == null) {
            if (backgroundMusic != null) {
                backgroundMusic.stop();
            }
            JOptionPane.showMessageDialog(frame, "YOU WIN!");
            System.exit(0);
        }


        level.stop();


        if (frame.getKeyListeners().length > 0) {
            frame.removeKeyListener(frame.getKeyListeners()[0]);
        }


        level = next;

        // Update the world and background
        view.setWorld(level);
        view.updateBackground(level.getBackgroundFile());

        // Add a new key listener for the new plane
        frame.addKeyListener(new PlaneController(level.getPlane()));

        // Start the new level
        level.start();

        // Refresh the display
        view.repaint();
    }


    public void showGameOver() {
        if (backgroundMusic != null) {
            backgroundMusic.stop();
        }
        JOptionPane.showMessageDialog(frame, "GAME OVER");
        System.exit(0);
    }


    public int getLevelNumber() {
        return level.getLevelNumber();
    }

    public int getTime() {
        return time;
    }


    public static float randomY() {
        return MIN_Y + RNG.nextFloat() * (MAX_Y - MIN_Y);
    }


    // Main Method

    public static void main(String[] args) {
        new Game();
    }
}