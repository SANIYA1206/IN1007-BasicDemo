package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Fixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 * LaserBarrier represents an indestructible vertical laser
 * that damages the player on contact.
 */
public class LaserBarrier extends StaticBody {

    public LaserBarrier(World world) {
        // Thin and tall shape for a vertical laser
        super(world, new BoxShape(0.2f, 3f));

        // Add the laser image (ensure this exists in the data folder)
        addImage(new BodyImage("data/laser.png", 6f));

        // Make the laser a sensor so the plane can pass through
        // but still trigger collision events
        for (Fixture fixture : getFixtures()) {
            //fixture.setSensor(true);
        }
    }
}