package game;

import city.cs.engine.*;

public class Plane extends DynamicBody {

    private static final Shape SHAPE = new BoxShape(0.6f, 0.35f);

    public Plane(World world) {
        super(world, SHAPE);
        addImage(new BodyImage("data/plane.png", 1.2f));

        setGravityScale(1);        // gravity ON
   // keeps it floaty
    }

    public void flap() {
        // reset falling speed so flap feels consistent
        setLinearVelocity(getLinearVelocity().mul(0).add(new org.jbox2d.common.Vec2(getLinearVelocity().x, 0)));
        applyImpulse(new org.jbox2d.common.Vec2(0, 6.5f));
    }
}