package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Spike extends DynamicBody {

    private static final Shape spikeShape = new BoxShape(0.5f, 0.5f);

    public Spike(World world) {
        super(world, spikeShape);
        addImage(new BodyImage("data/spike.png", 1.2f)); // make sure image exists
        setLinearVelocity(new Vec2(-Game.SCROLL_SPEED, 0));
    }
}