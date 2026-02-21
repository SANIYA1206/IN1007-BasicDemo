package game;

import city.cs.engine.*;

public class Bird extends DynamicBody {

    public Bird(World world) {
        super(world, new BoxShape(0.8f, 0.25f));
        addImage(new BodyImage("data/bird.png", 1.0f));
        setGravityScale(0);
    }
}