package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

public class Scroller implements StepListener {

    private final Plane plane;
    private final DynamicBody body;
    private final boolean isRing;

    public Scroller(Plane plane, DynamicBody body, boolean isRing) {
        this.plane = plane;
        this.body = body;
        this.isRing = isRing;
    }

    @Override
    public void preStep(StepEvent e) {
        // Move obstacles left
        body.setLinearVelocity(new Vec2(-Game.SCROLL_SPEED, 0));

        // Keep plane fixed in X (flappy style)
        plane.setLinearVelocity(new Vec2(0, plane.getLinearVelocity().y));
    }

    @Override
    public void postStep(StepEvent e) {
        // Respawn obstacle when off-screen left
        if (body.getPosition().x < -14f) {
            float newY = Game.randomY();
            float extra = isRing ? 0f : 2f; // birds slightly spaced out
            body.setPosition(new Vec2(Game.RESPAWN_X + extra, newY));
        }
    }
}