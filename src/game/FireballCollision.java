package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class FireballCollision implements CollisionListener {

    @Override
    public void collide(CollisionEvent e) {

        // Check if the fireball hits a LaserShot
        if (e.getOtherBody() instanceof LaserShot) {
            // Destroy ONLY the laser that was hit
            e.getOtherBody().destroy();

            // Destroy the fireball after impact
            e.getReportingBody().destroy();
        }
    }
}