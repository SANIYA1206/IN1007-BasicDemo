package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class LaserShot extends DynamicBody {

    public LaserShot(World world) {
        super(world, new BoxShape(2.5f, 0.15f));
        addImage(new BodyImage("data/laser_horizontal.png", 5f));
        setGravityScale(0);
    }

    public void fireFrom(float x, float y) {
        setPosition(new Vec2(x, y));
        setLinearVelocity(new Vec2(-8f, 0));
    }
}