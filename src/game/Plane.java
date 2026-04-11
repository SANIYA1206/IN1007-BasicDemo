package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Plane extends DynamicBody {

    private static final Shape SHAPE = new BoxShape(0.6f, 0.35f);

    private int fireUses = 2;

    public Plane(World world) {
        super(world, SHAPE);
        addImage(new BodyImage("data/plane.png", 1.2f));
        setGravityScale(1);
    }

    public void flap() {
        setLinearVelocity(new Vec2(getLinearVelocity().x, 0));
        applyImpulse(new Vec2(0, 6.5f));
    }

    public void useFireAttack() {
        if (fireUses <= 0) {
            return;
        }

        if (!(getWorld() instanceof Level3)) {
            return;
        }

        Fireball fireball = new Fireball(getWorld());
        fireball.shootFrom(getPosition().x + 1.2f, getPosition().y);
        fireball.addCollisionListener(new FireballCollision());

        fireUses--;
    }

    public int getFireUses() {
        return fireUses;
    }
}