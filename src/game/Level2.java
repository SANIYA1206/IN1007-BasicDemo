package game;

import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel {

    public Level2(Game game) {
        super(game);
        populate();
    }

    @Override
    public void populate() {

        // Rings (collectibles)
        Ring ring1 = new Ring(this);
        ring1.setPosition(new Vec2(8f, 4f));

        Ring ring2 = new Ring(this);
        ring2.setPosition(new Vec2(14f, 2f));

        Ring ring3 = new Ring(this);
        ring3.setPosition(new Vec2(20f, 5f));

        // Birds (enemies)
        Bird bird1 = new Bird(this);
        bird1.setPosition(new Vec2(10f, 6f));

        Bird bird2 = new Bird(this);
        bird2.setPosition(new Vec2(16f, 3f));

        // Spikes (new hazard introduced in Level 2)
        Spike spike1 = new Spike(this);
        spike1.setPosition(new Vec2(6f, 0f));

        Spike spike2 = new Spike(this);
        spike2.setPosition(new Vec2(12f, 1f));

        // Oscillating rings for added difficulty
        new RingOscillator(ring1);
        new RingOscillator(ring2);

        // Scrolling behaviour
        addStepListener(new Scroller(plane, ring1, true));
        addStepListener(new Scroller(plane, ring2, true));
        addStepListener(new Scroller(plane, ring3, true));
        addStepListener(new Scroller(plane, bird1, false));
        addStepListener(new Scroller(plane, bird2, false));
        addStepListener(new Scroller(plane, spike1, false));
        addStepListener(new Scroller(plane, spike2, false));
    }

    // Level completion condition
    @Override
    public boolean isComplete() {
        return Game.score >= 10;
    }

    // Progress to Level 3
    @Override
    public GameLevel getNextLevel() {
        return new Level3(game);
    }

    @Override
    public int getLevelNumber() {
        return 2;
    }

    // Sunset background
    @Override
    public String getBackgroundFile() {
        return "data/sky2.png";
    }
}