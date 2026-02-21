package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.ImageIcon;
import java.awt.*;

public class SkyView extends UserView {

    private Image background;

    public SkyView(World world, int width, int height) {
        super(world, width, height);

        // Load background image
        background = new ImageIcon("data/sky.png").getImage();
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

        // HUD text
        g.drawString("Score: " + Game.score, 15, 20);
        g.drawString("Lives: " + Game.lives, 15, 40);

        // Optional: instructions
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Controls: W/UP = up, S/DOWN = down", 15, 60);
    }
}