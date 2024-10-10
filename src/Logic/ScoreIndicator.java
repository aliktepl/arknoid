//319049540 Alik Teplitsky
package Logic;

import Shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Indicates the score on the screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private LevelInformation information;

    /**
     * Constructor for the score indicator.
     *
     * @param score       - the score of the player.
     * @param information the information
     */
    public ScoreIndicator(Counter score, LevelInformation information) {
        this.score = score;
        this.information = information;
    }

    /**
     * draws the scoreboard to the surfrace.
     *
     * @param d - A surface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(400, 20, "Score: " + this.score.getValue(), 20);
        d.drawText(600, 20, "Level Name: " + this.information.levelName(), 20);
    }

    @Override
    public void timePassed() {

    }

    /**
     * Adds the scoreboard to the game.
     *
     * @param game - a game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}
