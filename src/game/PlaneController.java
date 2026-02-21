package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlaneController extends KeyAdapter {

    private final Plane plane;

    private final float forwardSpeed = 4f;  // normal speed
    private final float backSpeed = -4f;    // when holding back
    private final float verticalSpeed = 6f;

    private boolean upHeld = false;
    private boolean downHeld = false;
    private boolean backHeld = false;

    public PlaneController(Plane plane) {
        this.plane = plane;
    }

    private void updateVelocity() {
        float x = backHeld ? backSpeed : forwardSpeed;

        float y = 0f;
        if (upHeld && !downHeld) y = verticalSpeed;
        if (downHeld && !upHeld) y = -verticalSpeed;

        plane.setLinearVelocity(new Vec2(x, y));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) upHeld = true;
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) downHeld = true;

        // BACK button (choose what you use)
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) backHeld = true;

        updateVelocity();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) upHeld = false;
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) downHeld = false;

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) backHeld = false;

        updateVelocity();
    }
}