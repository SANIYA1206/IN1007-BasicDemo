package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {

    protected Plane plane;
    protected Game game;

    public GameLevel(Game game) {
        this.game = game;

        // Set gravity
        setGravity(9.8f);

        // Add the ground
        new Ground(this);

        // Create the plane
        plane = new Plane(this);
        plane.setPosition(new Vec2(-10f, 2f));

        // Add collision listener
        plane.addCollisionListener(new PlaneCollision(game, this));
    }

    public Plane getPlane() {
        return plane;
    }

    // Each level must implement these methods
    public abstract void populate();

    public abstract boolean isComplete();

    public abstract GameLevel getNextLevel();

    public abstract int getLevelNumber();

    public abstract String getBackgroundFile();
}