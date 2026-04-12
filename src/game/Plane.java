package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * The Plane class represents the player-controlled character.
 * The plane can move upward and shoot fireballs to destroy lasers in Level 3.
 */
public class Plane extends DynamicBody {

    // Shape of the plane
    private static final Shape SHAPE = new BoxShape(0.6f, 0.35f);

    // Number of fire attacks available
    private int fireUses = 2;

    /**
     * Constructor to create the plane in the game world.
     */
    public Plane(World world) {
        super(world, SHAPE);
        addImage(new BodyImage("data/plane.png", 1.2f));
        setGravityScale(1); // Normal gravity for flappy-style movement
    }

    /**
     * Makes the plane move upward when the player presses W/UP/SPACE.
     */
    public void flap() {
        // Reset vertical velocity for consistent movement
        setLinearVelocity(new Vec2(getLinearVelocity().x, 0));
        // Apply upward impulse
        applyImpulse(new Vec2(0, 6.5f));
    }

    /**
     * Fires a fireball horizontally to destroy LaserShot obstacles.
     * Activated when the player presses the SHIFT key.
     */
    public void useFireAttack() {
        // Check if any fire uses remain
        if (fireUses <= 0) {
            return;
        }

        // Optional: Restrict the fire attack to Level 3 only
        if (!(getWorld() instanceof Level3)) {
            return;
        }

        // Create the fireball
        Fireball fireball = new Fireball(getWorld());

        // Position the fireball slightly in front of the plane
        fireball.shootFrom(
                getPosition().x + 1.5f,
                getPosition().y
        );

        // Attach collision listener so the fireball can destroy lasers
        fireball.addCollisionListener(new FireballCollision());

        // Decrease the number of remaining fire uses
        fireUses--;
    }

    /**
     * Returns the number of remaining fire uses.
     * This is useful for displaying in the HUD.
     */
    public int getFireUses() {
        return fireUses;
    }

    /**
     * Optional: Reset fire uses when starting a new level.
     */
    public void resetFireUses() {
        fireUses = 2;
    }
}