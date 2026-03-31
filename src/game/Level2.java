package game;

import org.jbox2d.common.Vec2;

public class Level2 extends GameLevel {

    public Level2(Game game) {
        super(game);
        populate();
    }

    @Override
    public void populate() {

        Ring ring1 = new Ring(this);
        ring1.setPosition(new Vec2(8f, 2f));

        Ring ring2 = new Ring(this);
        ring2.setPosition(new Vec2(14f, 6f));

        Ring ring3 = new Ring(this);
        ring3.setPosition(new Vec2(20f, 3f));

        Bird bird1 = new Bird(this);
        bird1.setPosition(new Vec2(10f, 6f));

        Bird bird2 = new Bird(this);
        bird2.setPosition(new Vec2(16f, 4f));

        Bird bird3 = new Bird(this);
        bird3.setPosition(new Vec2(22f, 5f));

        new RingOscillator(ring1);
        new RingOscillator(ring2);

        addStepListener(new Scroller(plane, ring1, true));
        addStepListener(new Scroller(plane, ring2, true));
        addStepListener(new Scroller(plane, ring3, true));
        addStepListener(new Scroller(plane, bird1, false));
        addStepListener(new Scroller(plane, bird2, false));
        addStepListener(new Scroller(plane, bird3, false));
    }

    @Override
    public boolean isComplete() {
        return Game.score >= 12;
    }

    @Override
    public GameLevel getNextLevel() {
        return new Level3(game);
    }

    @Override
    public int getLevelNumber() {
        return 2;
    }

    @Override
    public String getBackgroundFile() {
        return "data/sky2.png";
    }
}