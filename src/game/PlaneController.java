package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlaneController extends KeyAdapter {

    private DynamicBody plane;
    private float speed = 6f;

    public PlaneController(DynamicBody plane) {
        this.plane = plane;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Vec2 v = plane.getLinearVelocity();

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            plane.setLinearVelocity(new Vec2(speed, v.y));
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            plane.setLinearVelocity(new Vec2(-speed, v.y));
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            plane.setLinearVelocity(new Vec2(v.x, speed));
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            plane.setLinearVelocity(new Vec2(v.x, -speed));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Vec2 v = plane.getLinearVelocity();

        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            plane.setLinearVelocity(new Vec2(0, v.y));
        }

        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            plane.setLinearVelocity(new Vec2(v.x, 0));
        }
    }
}
