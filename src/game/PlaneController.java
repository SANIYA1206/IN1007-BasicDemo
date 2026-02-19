package game;

import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlaneController implements KeyListener {

    private final DynamicBody plane;
    private float speed = 4f;

    public PlaneController(DynamicBody plane) {
        this.plane = plane;
        plane.setLinearVelocity(new Vec2(speed, 0));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Vec2 v = plane.getLinearVelocity();

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            plane.setLinearVelocity(new Vec2(speed, 6));
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            plane.setLinearVelocity(new Vec2(speed, -6));
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            speed = Math.min(10f, speed + 1f);
            plane.setLinearVelocity(new Vec2(speed, v.y));
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            speed = Math.max(2f, speed - 1f);
            plane.setLinearVelocity(new Vec2(speed, v.y));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // go level when releasing up/down
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            plane.setLinearVelocity(new Vec2(speed, 0));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }
}
