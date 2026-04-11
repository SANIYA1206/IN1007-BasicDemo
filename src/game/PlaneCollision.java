package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 * Handles all collisions involving the player's plane.
 */
public class PlaneCollision implements CollisionListener {

    private final Game game;
    private final GameLevel level;

    public PlaneCollision(Game game, GameLevel level) {
        this.game = game;
        this.level = level;
    }

    @Override
    public void collide(CollisionEvent e) {

        // ---------------------------
        // Collect Ring → Increase Score
        // ---------------------------
        if (e.getOtherBody() instanceof Ring ring) {
            Game.score++;
            ring.setPosition(new Vec2(Game.RESPAWN_X, Game.randomY()));
            return; // Prevent multiple actions in one collision
        }

        // ---------------------------
        // Hit Bird → Lose Life
        // ---------------------------
        if (e.getOtherBody() instanceof Bird bird) {
            Game.lives--;

            // Move bird away to avoid repeated collisions
            bird.setPosition(new Vec2(Game.RESPAWN_X, Game.randomY()));
            bird.setLinearVelocity(new Vec2(-Game.SCROLL_SPEED, 0));

            if (Game.lives <= 0) {
                game.showGameOver();
                return;
            }
        }

        // ---------------------------
        // Hit Spike → Lose Life
        // ---------------------------
        if (e.getOtherBody() instanceof Spike spike) {
            Game.lives--;

            spike.setPosition(new Vec2(Game.RESPAWN_X, Game.randomY()));
            spike.setLinearVelocity(new Vec2(-Game.SCROLL_SPEED, 0));

            if (Game.lives <= 0) {
                game.showGameOver();
                return;
            }
        }

        // ---------------------------
        // Hit Laser Barrier → Lose Life
        // ---------------------------
        if (e.getOtherBody() instanceof LaserBarrier) {
            Game.lives--;

            if (Game.lives <= 0) {
                game.showGameOver();
                return;
            }
        }

        // ---------------------------
        // Check Level Completion
        // ---------------------------
        if (level.isComplete()) {
            game.goNextLevel();
        }
    }
}