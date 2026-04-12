package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Fireball extends DynamicBody {

    public Fireball(World world) {
        super(world, new BoxShape(0.9f, 0.3f));
        addImage(new BodyImage("data/fireball.png", 1.8f));
        setGravityScale(0);
    }

    public void shootFrom(float x, float y) {
        setPosition(new Vec2(x, y));
        setLinearVelocity(new Vec2(12f, 0));
    }
}