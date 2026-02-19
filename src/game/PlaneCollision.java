package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

public class PlaneCollision implements CollisionListener {

    private final DynamicBody plane;

    public PlaneCollision(DynamicBody plane) {
        this.plane = plane;
    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() instanceof Ring) {
            e.getOtherBody().destroy();
            Game.score += 1;
            return;
        }

        if (e.getOtherBody() instanceof Bird) {
            e.getOtherBody().destroy();
            Game.lives -= 1;

            // respawn
            plane.setLinearVelocity(new Vec2(0, 0));
            plane.setAngularVelocity(0);
            plane.setPosition(new Vec2(-7, 5));

            if (Game.lives <= 0) {
                Game.lives = 3;
                Game.score = 0;
            }
        }
    }
}
