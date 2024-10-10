//319049540 Alik Teplitsky
package Logic;

import Shapes.Ball;
import Shapes.Block;

/**
 * Removes a ball from the game if it falls of the screen.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Ball remover constructor.
     *
     * @param game         - a game.
     * @param removedBalls - balls to be removed.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * Removes the hitting ball from the game.
     * @param beingHit - the block that's being hit.
     * @param hitter - the hitting ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(game);
    }
}
