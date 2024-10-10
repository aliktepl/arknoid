//319049540 Alik Teplitsky
package Logic;
import Shapes.Collidable;
import Shapes.Line;
import Shapes.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * The game environment.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * Create a new game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * Get the list of collidables.
     *
     * @return List of collidables.
     */
    public List<Collidable> getCollidables() {
        return collidables;
    }

    /**
     * Add a list of collidables.
     *
     * @param collidables - A list of collidables.
     */
    public void setCollidables(List<Collidable> collidables) {
        this.collidables = collidables;
    }

    /**
     * Add a collidable.
     *
     * @param c - a collidable object.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * Finds the closest collision point of a ball with the collidable object.
     *
     * @param trajectory - The ball's trajectory
     * @return - CollisionInfo - Info about the point of collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> points = new ArrayList<Point>();
        List<Collidable> temp = new ArrayList<Collidable>();
        int isColliding = 0;
        Point closestPoint;
        Collidable closestCollidable;
        for (Collidable c : collidables) {
            if (trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle()) != null) {
                points.add(trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle()));
                temp.add(c);
                isColliding = 1;
            }
        }
        if (isColliding == 1) {
            closestPoint = points.get(0);
            closestCollidable = temp.get(0);
            for (Point p : points) {
                if (trajectory.start().distance(p) < trajectory.start().distance(closestPoint)) {
                    closestPoint = p;
                    closestCollidable = temp.get(points.indexOf(p));
                }
            }
        } else {
            return null;
        }
        return new CollisionInfo(closestPoint, closestCollidable);
    }
}
