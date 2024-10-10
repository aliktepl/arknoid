//319049540 Alik Teplitsky
package Logic;

import Shapes.Point;

/**
 * The type Velocity.
 *
 * @author Alik Teplitsky
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor.
     *
     * @param dx - x-axis change rate.
     * @param dy - y-axis change rate.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Create a new Velocity object, which uses an angle and a speed value to calculate the dx and dy.
     *
     * @param angle - the angle at which the ball moves.
     * @param speed - the speed of the ball.
     * @return Velocity - A new velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radians = Math.toRadians(angle);
        double dx = Math.sin(radians) * speed;
        double dy = -Math.cos(radians) * speed;
        return new Velocity((int) dx, (int) dy);
    }

    /**
     * get the x-axis differential.
     *
     * @return double - dx
     */
    public double getDx() {
        return dx;
    }

    /**
     * get the y-axis differential.
     *
     * @return double - dy.
     */
    public double getDy() {
        return dy;
    }

    /**
     * Apply the new velocity to the ball, changing the coordinates of the center point.
     *
     * @param p - A point, usually the center point of a ball.
     * @return Point - the point after applying the velocity to it.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}
