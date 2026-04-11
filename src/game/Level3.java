package game;

import org.jbox2d.common.Vec2;

public class Level3 extends GameLevel {

    public Level3(Game game) {
        super(game);
        populate();
    }

    @Override
    public void populate() {

        // Rings (collectibles)
        Ring ring1 = new Ring(this);
        ring1.setPosition(new Vec2(8f, 4f));

        Ring ring2 = new Ring(this);
        ring2.setPosition(new Vec2(15f, 2f));

        Ring ring3 = new Ring(this);
        ring3.setPosition(new Vec2(22f, 6f));

        // Increased number of birds for higher difficulty
        Bird bird1 = new Bird(this);
        bird1.setPosition(new Vec2(10f, 6f));

        Bird bird2 = new Bird(this);
        bird2.setPosition(new Vec2(16f, 4f));

        Bird bird3 = new Bird(this);
        bird3.setPosition(new Vec2(22f, 5f));

        Bird bird4 = new Bird(this);
        bird4.setPosition(new Vec2(26f, 3f));

        // Laser barriers (indestructible obstacles to dodge)
       // LaserBarrier laser1 = new LaserBarrier(this);
        //laser1.setPosition(new Vec2(18f, 2f));

       // LaserBarrier laser2 = new LaserBarrier(this);
       // laser2.setPosition(new Vec2(24f, 5f));

        // Oscillating rings for added challenge
        new RingOscillator(ring1);
        new RingOscillator(ring2);

        // Scrolling behaviour
        addStepListener(new Scroller(plane, ring1, true));
        addStepListener(new Scroller(plane, ring2, true));
        addStepListener(new Scroller(plane, ring3, true));
        addStepListener(new Scroller(plane, bird1, false));
        addStepListener(new Scroller(plane, bird2, false));
        addStepListener(new Scroller(plane, bird3, false));
        addStepListener(new Scroller(plane, bird4, false));
       // addStepListener(new Scroller(plane, laser1, false));
        //addStepListener(new Scroller(plane, laser2, false));
    }

    // Final level completion condition
    @Override
    public boolean isComplete() {
        return Game.score >= 20;
    }

    // No next level → player wins
    @Override
    public GameLevel getNextLevel() {
        return null;
    }

    @Override
    public int getLevelNumber() {
        return 3;
    }

    // Night background
    @Override
    public String getBackgroundFile() {
        return "data/sky3.png";
    }
}