package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;
import java.util.Random;

public class Game {

    public static int score = 0;
    public static int lives = 3;

    // tweak these to change difficulty
    public static final float SCROLL_SPEED = 4.0f;     // how fast obstacles move left
    public static final float RESPAWN_X = 22.0f;       // where obstacles reappear
    public static final float MIN_Y = -2.5f;           // obstacle min height
    public static final float MAX_Y = 7.5f;            // obstacle max height

    public static final Random RNG = new Random();

    private final World world;
    private final JFrame frame;
    private final Plane plane;

    public Game() {

        world = new World();
        world.setGravity(9.8f); // flappy-style gravity

        // Ground (optional - helps with “fall out of world” feel)
        Shape groundShape = new BoxShape(50f, 0.5f);
        StaticBody ground = new StaticBody(world, groundShape);
        ground.setPosition(new Vec2(0f, -8.5f));

        // Plane
        plane = new Plane(world);
        plane.setPosition(new Vec2(-10f, 2f));
        plane.addCollisionListener(new PlaneCollision());

        // Rings (collect = score++)
        Ring ring1 = new Ring(world);
        ring1.setPosition(new Vec2(6f, 3f));

        Ring ring2 = new Ring(world);
        ring2.setPosition(new Vec2(12f, 5f));

        Ring ring3 = new Ring(world);
        ring3.setPosition(new Vec2(18f, 2f));

        // Birds (hit = lose life)
        Bird bird1 = new Bird(world);
        bird1.setPosition(new Vec2(10f, 6f));

        Bird bird2 = new Bird(world);
        bird2.setPosition(new Vec2(16f, 4f));

        // Make them all scroll left + respawn when off-screen
        world.addStepListener(new Scroller(plane, ring1, true));
        world.addStepListener(new Scroller(plane, ring2, true));
        world.addStepListener(new Scroller(plane, ring3, true));
        world.addStepListener(new Scroller(plane, bird1, false));
        world.addStepListener(new Scroller(plane, bird2, false));

        // View
        UserView view = new SkyView(world, 800, 500);
        frame = new JFrame("Flappy Plane");
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);

        // Controls (SPACE/W/UP = flap)
        frame.addKeyListener(new PlaneController(plane));

        world.start();
    }

    public static float randomY() {
        return MIN_Y + RNG.nextFloat() * (MAX_Y - MIN_Y);
    }

    public static void main(String[] args) {
        new Game();
    }
}