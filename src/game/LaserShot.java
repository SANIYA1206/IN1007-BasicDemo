package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class LaserShot extends DynamicBody {

    public LaserShot(World world) {
        // Shorter and slightly thicker hitbox for reliable collisions
        super(world, new BoxShape(1.5f, 0.2f));
        addImage(new BodyImage("data/laser.png", 3f));
        setGravityScale(0);
    }

    public void fireFrom(float x, float y) {
        setPosition(new Vec2(x, y));
        setLinearVelocity(new Vec2(-8f, 0));
    }
}