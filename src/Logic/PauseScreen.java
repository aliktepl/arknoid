package Logic;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Pause screen.
 */
public class PauseScreen extends KeyPressStoppableAnimation implements Animation {
    private KeyPressStoppableAnimation press;
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k         the k
     * @param decorated the decorated
     */
    public PauseScreen(KeyboardSensor k, KeyPressStoppableAnimation decorated) {
        super(k, "enter", decorated);
        this.keyboard = k;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        super.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return super.shouldStop();
    }
}
