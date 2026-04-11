package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.World;

/**
 * Represents a horizontal laser that shoots across the screen.
 */
public class LaserBarrier extends DynamicBody {

    public LaserBarrier(World world) {
        // Wide and thin shape for a horizontal laser
        super(world, new BoxShape(3f, 0.2f));

        // Add the laser image (horizontal orientation)
        addImage(new BodyImage("data/laser.png", 6f));

        // Prevent gravity from affecting the laser
        setGravityScale(0);
    }
}