//319049540 Alik Teplitsky
package Shapes;
import biuoop.DrawSurface;

/**
 * Sprite interface.
 */
public interface Sprite {
    /**
     * Draw the sprite onto the surface.
     *
     * @param d - A surface to draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * Notify the sprite that time has passed.
     */
    void timePassed();
}
