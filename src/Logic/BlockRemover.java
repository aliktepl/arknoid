//319049540 Alik Teplitsky
package Logic;

import Shapes.Ball;
import Shapes.Block;

/**
 * Handles the removal of a block.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Block remover constructor.
     *
     * @param game          - a game.
     * @param removedBlocks - blocks to be removed.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Removes the hit block from the game.
     * @param beingHit - the block that's being hit.
     * @param hitter - the hitting ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeFromGame(game);
    }
}
