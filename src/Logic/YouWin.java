package Logic;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type You win.
 */
public class YouWin extends KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private AnimationRunner runner;
    private int score;

    /**
     * Instantiates a new You win.
     *
     * @param k         the k
     * @param runner    the runner
     * @param score     the score
     * @param decorated the decorated
     */
    public YouWin(KeyboardSensor k, AnimationRunner runner, int score, KeyPressStoppableAnimation decorated) {
        super(k, "enter", decorated);
        this.keyboard = k;
        this.runner = runner;
        this.score = score;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(200, d.getHeight() / 2, "You Win! Your score is " + score, 32);
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
