package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class RingOscillator implements StepListener {

    private final Ring ring;
    private final float baseY;
    private float t = 0f;

    private final float amplitude = 1.2f;
    private final float speed = 2.2f;

    public RingOscillator(Ring ring) {
        this.ring = ring;
        this.baseY = ring.getPosition().y;
        ring.getWorld().addStepListener(this);
    }

    @Override
    public void preStep(StepEvent stepEvent) { }

    @Override
    public void postStep(StepEvent stepEvent) {
        t += 0.02f;
        float y = baseY + amplitude * (float) Math.sin(speed * t);
        ring.setPosition(new Vec2(ring.getPosition().x, y));
    }
}