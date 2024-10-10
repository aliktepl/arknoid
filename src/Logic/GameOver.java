package Logic;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Game over.
 */
public class GameOver extends KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor keyboard;
    private AnimationRunner runner;
    private int score;

    /**
     * Instantiates a new Game over.
     *
     * @param k         the k
     * @param runner    the runner
     * @param score     the score
     * @param decorated the decorated
     */
    public GameOver(KeyboardSensor k, AnimationRunner runner, int score, KeyPressStoppableAnimation decorated) {
        super(k, "space", decorated);
        this.runner = runner;
        this.score = score;

    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(50, d.getHeight() / 2, "Game Over. Your score is " + score, 32);
        super.doOneFrame(d);
        if (shouldStop()) {
            runner.getGui().close();
        }
    }

    @Override
    public boolean shouldStop() {
        return super.shouldStop();
    }
}
