package game;

import city.cs.engine.*;

public class Ring extends DynamicBody {

    public Ring(World world) {
        super(world, new CircleShape(0.8f));
        addImage(new BodyImage("data/ring.png", 2.0f));
        setGravityScale(0);
    }
}