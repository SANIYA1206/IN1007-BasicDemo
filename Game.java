package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

/**
 * Milestone 1 Plane Game (based on the starter template)
 */
public class Game {

    private World world;
    private UserView view;

    // game state for HUD
    public static int score = 0;
    public static int lives = 3;

    /** Initialise a new Game. */
    public Game() {

        // 1. make an empty game world
        world = new World();

        // 2. populate it with bodies (platforms, collectibles, characters)

        // --- Ground (StaticBody) ---
        Shape groundShape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(world, groundShape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // --- Side walls (StaticBody) ---
        Shape wallShape = new BoxShape(0.5f, 20f);
        StaticBody leftWall = new StaticBody(world, wallShape);
        leftWall.setPosition(new Vec2(-11.5f, 0));

        StaticBody rightWall = new StaticBody(world, wallShape);
        rightWall.setPosition(new Vec2(11.5f, 0));

        // --- Buildings (StaticBody obstacles) ---
        makeBuilding(world, new Vec2(-6, -9.5f), 1.5f, 2.0f);
        makeBuilding(world, new Vec2(1, -8.8f), 2.0f, 2.7f);
        makeBuilding(world, new Vec2(7, -9.0f), 1.2f, 2.5f);

        // --- Plane (DynamicBody) ---
        Shape planeShape = new BoxShape(1.3f, 0.4f);
        DynamicBody plane = new DynamicBody(world, planeShape);
        plane.setPosition(new Vec2(-7, 5));
        plane.addImage(new BodyImage("data/plane.png", 2.0f));
        plane.setGravityScale(0); // plane floats (easier for milestone 1)

        // --- Rings (collectibles) ---
        Ring r1 = new Ring(world); r1.setPosition(new Vec2(-2, 6));
        Ring r2 = new Ring(world); r2.setPosition(new Vec2(4, 3));
        Ring r3 = new Ring(world); r3.setPosition(new Vec2(8, 7));

        // --- Birds (moving obstacles) ---
        Bird b1 = new Bird(world); b1.setPosition(new Vec2(3, 7));  b1.setLinearVelocity(new Vec2(-2, 0));
        Bird b2 = new Bird(world); b2.setPosition(new Vec2(9, 4));  b2.setLinearVelocity(new Vec2(-3, 0));

        // --- Collision handling (score/lives changes) ---
        plane.addCollisionListener(new PlaneCollision(plane));

        // 3. make a view to look into the game world
        view = new SkyView(world, 500, 500);

        // 4. create a Java window (frame) and add the game view to it
        final JFrame frame = new JFrame("City Game - Plane");
        frame.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        // --- Controls ---
        frame.addKeyListener(new PlaneController(plane));

        // start simulation
        world.start();
    }

    // helper to make buildings quickly (StaticBodies)
    private void makeBuilding(World world, Vec2 pos, float halfW, float halfH) {
        Shape s = new BoxShape(halfW, halfH);
        StaticBody building = new StaticBody(world, s);
        building.setPosition(pos);
    }

    public static void main(String[] args) {
        new Game();
    }
}