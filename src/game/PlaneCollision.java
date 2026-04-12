package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class PlaneCollision implements CollisionListener {

    private final Game game;
    private final GameLevel level;

    public PlaneCollision(Game game, GameLevel level) {
        this.game = game;
        this.level = level;
    }

    @Override
    public void collide(CollisionEvent e) {

        if (e.getOtherBody() instanceof Ring ring) {
            Game.score++;
            ring.setPosition(new Vec2(Game.RESPAWN_X, Game.randomY()));
        }

        if (e.getOtherBody() instanceof Bird bird) {
            Game.lives--;

            bird.setPosition(new Vec2(Game.RESPAWN_X, Game.randomY()));
            bird.setLinearVelocity(new Vec2(-Game.SCROLL_SPEED, 0));

            if (Game.lives <= 0) {
                game.showGameOver();
                return;
            }
        }

        if (e.getOtherBody() instanceof Spike spike) {
            Game.lives--;

            spike.setPosition(new Vec2(Game.RESPAWN_X, Game.randomY()));
            spike.setLinearVelocity(new Vec2(-Game.SCROLL_SPEED, 0));

            if (Game.lives <= 0) {
                game.showGameOver();
                return;
            }
        }

        if (e.getOtherBody() instanceof LaserShot shot) {
            Game.lives--;
            shot.destroy();

            if (Game.lives <= 0) {
                game.showGameOver();
                return;
            }
        }

        if (e.getOtherBody() instanceof Ground) {
            game.showGameOver();
            return;
        }

        if (level.isComplete()) {
            game.goNextLevel();
        }
    }
}