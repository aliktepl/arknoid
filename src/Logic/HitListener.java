//319049540 Alik Teplitsky
package Logic;

import Shapes.Ball;
import Shapes.Block;

/**
 * The class listens for hits.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit - the block that's being hit.
     * @param hitter   - the hitting ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
