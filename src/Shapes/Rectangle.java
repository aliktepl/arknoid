//319049540 Alik Teplitsky
package Shapes;
import java.util.ArrayList;
import java.util.List;

/**
 * A rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Line upperHorizontal;
    private Line lowerHorizontal;
    private Line leftVertical;
    private Line rightVertical;

    /**
     * Create a new rectangle.
     *
     * @param upperLeft - The upper left edge.
     * @param height    - The height of the rectangle
     * @param width     - The width of the rectangle;
     */
    public Rectangle(Point upperLeft, double height, double width) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        lines();
    }

    /**
     * Calculate the lines of the rectangle.
     */
    public void lines() {
        Point upperRight = new Point(getUpperLeft().getX() + this.width, getUpperLeft().getY());
        Point lowerLeft = new Point(getUpperLeft().getX(), getUpperLeft().getY() + this.height);
        Point lowerRight = new Point(getUpperLeft().getX() + this.width, getUpperLeft().getY() + this.height);
        this.upperHorizontal = new Line(upperLeft, upperRight);
        this.lowerHorizontal = new Line(lowerLeft, lowerRight);
        this.leftVertical = new Line(upperLeft, lowerLeft);
        this.rightVertical = new Line(upperRight, lowerRight);
    }

    /**
     * Calculate the intersection points between the rectangle and a given line.
     *
     * @param line - A line object.
     * @return List - A list of the intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<Point>();
        if (line.isIntersecting(upperHorizontal)) {
            points.add(line.intersectionWith(this.upperHorizontal));
        }
        if (line.isIntersecting(lowerHorizontal)) {
            points.add(line.intersectionWith(this.lowerHorizontal));
        }
        if (line.isIntersecting(this.leftVertical)) {
            points.add(line.intersectionWith(this.leftVertical));
        }
        if (line.isIntersecting(this.rightVertical)) {
            points.add(line.intersectionWith(this.rightVertical));
        }
        return points;
    }

    /**
     * Get the right vertical line.
     *
     * @return Line right vertical
     */
    public Line getRightVertical() {
        return this.rightVertical;
    }

    /**
     * Get the left vertical line.
     *
     * @return Line left vertical
     */
    public Line getLeftVertical() {
        return this.leftVertical;
    }

    /**
     * Get the lower horizontal line.
     *
     * @return Line lower horizontal
     */
    public Line getLowerHorizontal() {
        return this.lowerHorizontal;
    }

    /**
     * Get the upper horizontal line.
     *
     * @return Line upper horizontal
     */
    public Line getUpperHorizontal() {
        return this.upperHorizontal;
    }

    /**
     * Get the width of the rectangle.
     *
     * @return double width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Get the height of the rectangle.
     *
     * @return double. height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Get the upper left point of the rectangle.
     *
     * @return Point upper left
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Set the upper left point and calculate the lines.
     *
     * @param upperLeft - A point.
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
        lines();
    }

}
