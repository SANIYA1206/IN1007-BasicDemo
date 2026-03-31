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

    public Game() {
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
    }

    public void goNextLevel() {
        GameLevel next = level.getNextLevel();

        if (next == null) {
            JOptionPane.showMessageDialog(frame, "YOU WIN!");
            System.exit(0);
        }

        level.stop();
        frame.removeKeyListener(frame.getKeyListeners()[0]);

        level = next;
        view.setWorld(level);
        view.updateBackground(level.getBackgroundFile());

        frame.addKeyListener(new PlaneController(level.getPlane()));
        level.start();
        view.repaint();
    }

    public void showGameOver() {
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

    public static void main(String[] args) {
        new Game();
    }
}