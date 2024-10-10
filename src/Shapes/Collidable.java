//319049540 Alik Teplitsky
package Shapes;
import Logic.Velocity;
import biuoop.DrawSurface;

/**
 * Collidable interface.
 */
public interface Collidable {

    /**
     * Gets the collidable rectangle.
     *
     * @return - Rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notifies the object it has been hit.
     *
     * @param hitter          - The ball that hits the block.
     * @param collisionPoint  - The point of collision.
     * @param currentVelocity - Velocity on impact.
     * @return - The new velocity after the impact.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * Draws the object on the surface.
     *
     * @param surface - A surface to draw on.
     */
    void drawOn(DrawSurface surface);
}
