package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class LaserShooter implements StepListener {

    private final GameLevel level;
    private float timer = 0f;
    private final float interval = 2.5f; // seconds between shots
    private final float x;
    private final float y;

    public LaserShooter(GameLevel level, float x, float y) {
        this.level = level;
        this.x = x;
        this.y = y;
        level.addStepListener(this);
    }

    @Override
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        timer += 1f / 60f;

        if (timer >= interval) {
            timer = 0f;

            LaserShot shot = new LaserShot(level);
            shot.fireFrom(x, y);
        }
    }
}