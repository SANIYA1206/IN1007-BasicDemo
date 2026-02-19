package game;

import city.cs.engine.*;

public class Ring extends DynamicBody {

    public Ring(World world) {
        super(world, new CircleShape(0.6f));
        addImage(new BodyImage("data/ring.png", 1.2f));
        setGravityScale(0);
    }
}