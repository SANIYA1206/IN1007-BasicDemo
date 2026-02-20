package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class RingOscillator implements StepListener {

    private final Ring ring;
    private final float baseY;
    private float t = 0f;

    private final float amplitude = 1.2f; // how far up/down
    private final float speed = 2.2f;     // how fast

    public RingOscillator(Ring ring) {
        this.ring = ring;
        this.baseY = ring.getPosition().y;
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        // nothing
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        t += 0.02f; // fixed time step (CityEngine StepEvent doesn't have getTimeStep())
        float y = baseY + amplitude * (float) Math.sin(speed * t);
        ring.setPosition(new Vec2(ring.getPosition().x, y));
    }
}
