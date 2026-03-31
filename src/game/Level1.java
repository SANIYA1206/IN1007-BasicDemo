package game;

import org.jbox2d.common.Vec2;

public class Level1 extends GameLevel {

    public Level1(Game game) {
        super(game);
        populate();
    }

    @Override
    public void populate() {
        Ring ring1 = new Ring(this);
        ring1.setPosition(new Vec2(6f, 3f));

        Ring ring2 = new Ring(this);
        ring2.setPosition(new Vec2(12f, 5f));

        Ring ring3 = new Ring(this);
        ring3.setPosition(new Vec2(18f, 2f));

        Bird bird1 = new Bird(this);
        bird1.setPosition(new Vec2(10f, 6f));

        Bird bird2 = new Bird(this);
        bird2.setPosition(new Vec2(16f, 4f));

        new RingOscillator(ring1);
        new RingOscillator(ring2);

        addStepListener(new Scroller(plane, ring1, true));
        addStepListener(new Scroller(plane, ring2, true));
        addStepListener(new Scroller(plane, ring3, true));
        addStepListener(new Scroller(plane, bird1, false));
        addStepListener(new Scroller(plane, bird2, false));
    }

    @Override
    public boolean isComplete() {
        return Game.score >= 5;
    }

    @Override
    public GameLevel getNextLevel() {
        return new Level2(game);
    }

    @Override
    public int getLevelNumber() {
        return 1;
    }

    @Override
    public String getBackgroundFile() {
        return "data/sky.png";
    }
}