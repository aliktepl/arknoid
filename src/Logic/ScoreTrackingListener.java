//319049540 Alik Teplitsky
package Logic;

import Shapes.Ball;
import Shapes.Block;

/**
 * Keeps track of the score.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Creates a new score tracker.
     *
     * @param scoreCounter - the score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * Update the scoreboard.
     *
     * @param beingHit - the block that's being hit.
     * @param hitter   - the hitting ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}
