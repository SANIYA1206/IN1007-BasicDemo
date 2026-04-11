package game;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import city.cs.engine.BodyImage;

public class Spike extends DynamicBody {

    private static final Shape spikeShape = new BoxShape(1.0f, 1.0f);

    public Spike(World world) {
        super(world, spikeShape);
        addImage(new BodyImage("data/spike.png", 2.0f));
    }
}