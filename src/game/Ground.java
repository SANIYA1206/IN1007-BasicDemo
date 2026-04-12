package game;

import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class Ground extends StaticBody {

    public Ground(World world) {
        super(world, new BoxShape(50f, 0.5f));
        setPosition(new Vec2(0f, -8.5f));
    }
}