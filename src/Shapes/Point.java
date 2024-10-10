//319049540 Alik Teplitsky
package Shapes;

/**
 * The type Point.
 *
 * @author Alik Teplitsky
 */
public class Point {
    private double x;
    private double y;
    private static final double EPSILON = Math.pow(10, -10);

    /**
     * Constructor.
     *
     * @param x - x value of the point.
     * @param y - y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * calculate the distance between 2 points.
     *
     * @param other - another point.
     * @return double - distance between this point and other point.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * checks if 2 point are equal.
     *
     * @param other - another point.
     * @return true if the points are the same, false if not.
     */
    public boolean equals(Point other) {
        return ((Math.abs(this.getX() - other.getX()) < EPSILON) && (Math.abs(this.getY() - other.getY()) < EPSILON));
    }

    /**
     * Get X.
     *
     * @return double - the x value of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Get Y.
     *
     * @return double -  the y value of the point.
     */
    public double getY() {
        return this.y;
    }
}
