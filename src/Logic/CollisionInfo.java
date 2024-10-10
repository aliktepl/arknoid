//319049540 Alik Teplitsky
package Logic;

import Shapes.Collidable;
import Shapes.Point;

/**
 * Holds relevant info about the collision.
 */
public class CollisionInfo {

    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructs a new CollisionInfo object.
     *
     * @param collisionPoint  - The point of collision.
     * @param collisionObject - The object the ball collides with.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * Get the collision point.
     *
     * @return Point point
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Get the object the collision happens with.
     *
     * @return Collidable. collidable
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
