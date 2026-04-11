package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class FireballCollision implements CollisionListener {

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof LaserShot shot) {
            shot.destroy();
            e.getReportingBody().destroy();
        }
    }
}