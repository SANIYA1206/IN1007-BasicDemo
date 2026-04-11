package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlaneController extends KeyAdapter {

    private final Plane plane;

    public PlaneController(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP || code == KeyEvent.VK_SPACE) {
            plane.flap();
        }

        if (code == KeyEvent.VK_SHIFT) {
            plane.useFireAttack();
        }
    }
}