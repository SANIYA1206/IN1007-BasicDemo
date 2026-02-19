package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

public class SkyView extends UserView {

    private final Image background;

    public SkyView(World world, int width, int height) {
        super(world, width, height);
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
        g.drawString("Score: " + Game.score, 15, 20);
        g.drawString("Lives: " + Game.lives, 15, 40);
    }
}
