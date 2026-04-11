package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {

    protected Plane plane;
    protected Game game;

    public GameLevel(Game game) {
        this.game = game;

        setGravity(9.8f);

        Shape groundShape = new BoxShape(50f, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -8.5f));

        plane = new Plane(this);
        plane.setPosition(new Vec2(-10f, 2f));
        plane.addCollisionListener(new PlaneCollision(game, this));
    }

    public Plane getPlane() {
        return plane;
    }

    public abstract void populate();

    public abstract boolean isComplete();

    public abstract GameLevel getNextLevel();

    public abstract int getLevelNumber();

    public abstract String getBackgroundFile();
}