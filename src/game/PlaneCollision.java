package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class PlaneCollision implements CollisionListener {

    @Override
    public void collide(CollisionEvent e) {

        // Hit a ring = score
        if (e.getOtherBody() instanceof Ring ring) {
            Game.score++;
            ring.setPosition(new Vec2(Game.RESPAWN_X, Game.randomY()));
            return;
        }

        // Hit a bird = lose life EVERY time
        if (e.getOtherBody() instanceof Bird bird) {

            Game.lives--;

            // Move bird away so collision doesn't repeat instantly
            bird.setPosition(new Vec2(Game.RESPAWN_X, Game.randomY()));
            bird.setLinearVelocity(new Vec2(-Game.SCROLL_SPEED, 0));

            if (Game.lives <= 0) {
                System.out.println("GAME OVER");
                e.getReportingBody().getWorld().stop();
            }
        }
    }
}