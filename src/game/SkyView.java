package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.ImageIcon;
import java.awt.*;

public class SkyView extends UserView {

    private Image background;
    private final Game game;

    public SkyView(World world, int width, int height, Game game) {
        super(world, width, height);
        this.game = game;

        // default background
        updateBackground("data/sky.png");
    }

    public void updateBackground(String file) {
        background = new ImageIcon(file).getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        }
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.WHITE);

        g.drawString("Score: " + Game.score, 15, 20);
        g.drawString("Lives: " + Game.lives, 15, 40);
        g.drawString("Level: " + game.getLevelNumber(), 15, 60);
        g.drawString("Time: " + game.getTime(), 15, 80);

        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Controls: W/UP = up, S/DOWN = down", 15, 100);
    }
}