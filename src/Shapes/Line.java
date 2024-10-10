//319049540 Alik Teplitsky
package Shapes;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Line.
 *
 * @author Alik Teplitsky
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Constructor.
     *
     * @param start first point in the line.
     * @param end   second point in the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor.
     *
     * @param x1 - x of the first point.
     * @param y1 - y of the first point.
     * @param x2 - x of the second point.
     * @param y2 - y of the second point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * calculate the length of the line.
     *
     * @return double - the length of the line.
     */
    public double length() {
        //distance formula.
        return this.start.distance(end);
    }

    /**
     * Calculate the middle point of the line.
     *
     * @return Point - middle point of the line.
     */
    public Point middle() {
        //middle formula.
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     * get the start point.
     *
     * @return Point - start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * get the end point.
     *
     * @return Point - end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * Test if this line is intersecting with other line.
     *
     * @param other - another line.
     * @return boolean - true if intersecting, false if not.
     */
    public boolean isIntersecting(Line other) {
        if (this.touching(other) != null || this.congruence(other) || this.equals(other)) {
            return true;
        } else {
            Point inter = findIntersection(other);
            return ((this.start.distance(inter) <= this.length()) && (this.end.distance(inter) <= this.length())
                    && (other.start.distance(inter) <= other.length())
                    && (other.end.distance(inter) <= other.length()));
        }
    }

    /**
     * The function check if to lines are touching only at their starts or ends.
     *
     * @param other - another line.
     * @return boolean - true if they are touching
     */
    public Point touching(Line other) {
        //check if there is a single touching point at the end of the lines.
        if ((this.start.equals(other.start) || this.start.equals(other.end)) && !congruence(other)) {
            return this.start;
        }
        if ((this.end.equals(other.start) || this.end.equals(other.end)) && !congruence(other)) {
            return this.end;
        } else {
            return null;
        }
    }

    /**
     * The function checks if two line are overlapping each other, and returns true if they do and false if they don't.
     *
     * @param other - another line.
     * @return boolean - true if there is the lines overlap, false if they don't
     */
    public boolean congruence(Line other) {
        //incline
        double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
        //y-axis intersection.
        double b1 = (this.start.getY() - m1 * this.start.getX());
        double b2 = (other.start.getY() - m2 * other.start.getX());
        //test if the lines are vertical and have the same x value.
        if ((this.start.getX() == this.end.getX()) && (other.start.getX() == other.end.getX())
                && (this.start.getX() == other.start.getX()) && (this.end.getX() == other.start.getX())
                && (this.end.getX() == other.end.getX())
                && (this.start.getX() == other.end.getX())) {
            //test if one of the lines is completely above the other.
            if ((other.start.getY() > this.start.getY() && other.end.getY() > this.start.getY()
                    && Math.max(this.start.getY(), this.end.getY()) > Math.min(other.start.getY(), other.end.getY()))
                    || (other.start.getY() < this.start.getY() && other.end.getY() < this.start.getY()
                    && Math.max(other.start.getY(), other.end.getY()) > Math.min(this.start.getY(), this.end.getY()))) {
                return false;
            }
        }
        //test if the line are vertical but have a different x value.
        if (this.start.getX() == this.end.getX() && other.start.getX() == other.end.getX()
                && this.start.getX() != other.start.getX()) {
            return false;
        }
        //test the rest of the cases.
        return (((this.start.distance(other.start) < this.length() && other.end.distance(this.end) < other.length())
                || (this.start.distance(other.end) < this.length() && other.start.distance(this.end) < other.length())
                || (this.end.distance(other.end) < this.length() && other.start.distance(this.start) < other.length())
                || (this.end.distance(other.start) < this.length() && other.end.distance(this.start) < other.length()))
                && ((m1 == m2) && (b1 == b2)));
    }

    /**
     * return the point of intersection.
     *
     * @param other - another line
     * @return Point - the point of intersection, or null if no such point.
     */
    public Point intersectionWith(Line other) {
        if (this.touching(other) != null) {
            return this.touching(other);
        } else if (this.isIntersecting(other) && !this.congruence(other) && !this.equals(other)) {
            return findIntersection(other);
        }
        return null;
    }

    /**
     * check if two lines are equal.
     *
     * @param other - another line
     * @return true if they are equal, false if they are not.
     */
    public boolean equals(Line other) {
        return (this.start.getX() == other.start.getX() && this.start.getY() == other.start.getY()
                && this.end.getX() == other.end.getX() && this.end.getY() == other.end.getY())
                || (this.start.getY() == other.start.getX() && this.start.getX() == other.start.getY()
                && this.end.getY() == other.end.getX() && this.end.getX() == other.end.getY());
    }

    /**
     * test if the lines are perpendicular to each other and are parallel to the axes.
     *
     * @param other - another line
     * @return Point - the point of intersection.
     */
    public Point perpendicularParallel(Line other) {
        double x, y;

        if (this.start.getY() == this.end.getY() && other.end.getX() == other.start.getX()) {
            y = this.start.getY();
            x = this.start.getX();
            return new Point(x, y);
        }
        if (other.start.getY() == other.end.getY() && this.start.getX() == this.start.getX()) {
            y = other.start.getY();
            x = this.start.getX();
            return new Point(x, y);
        }
        return null;
    }

    /**
     * Calculate the intersection point using various formulas depending on the angle of the lines.
     *
     * @param other - another line
     * @return Point - intersection point.
     */
    public Point findIntersection(Line other) {
        double x;
        double y;
        //incline of the lines.
        double m1 = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        double m2 = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
        //y intersection of the lines.
        double b1 = (this.start.getY() - m1 * this.start.getX());
        double b2 = (other.start.getY() - m2 * other.start.getX());
        x = (m2 * other.end.getX() - m1 * this.start.getX() + this.start.getY() - other.end.getY()) / (m2 - m1);
        y = m1 * (x - this.start.getX()) + this.start.getY();
        //if the lines are perpendicular
        if (m1 * m2 == -1) {
            return this.perpendicularParallel(other);
        }
        //if one of the lines is vertical.
        if (this.start.getY() == this.end.getY()) {
            y = this.start.getY();
            x = (y - b2) / m2;
        }
        //if one of the lines is vertical.
        if (other.start.getY() == other.end.getY()) {
            y = other.start.getY();
            x = (y - b1) / m1;
        }
        //if one of the lines is horizontal.
        if (this.start.getX() == this.end.getX()) {
            x = this.start.getX();
            y = m2 * x + b2;
        }
        //if one of the lines is horizontal.
        if (other.start.getX() == other.end.getX()) {
            x = other.start.getX();
            y = m1 * x + b1;
        }
        return new Point(x, y);
    }


    /**
     * Find the closest intersection point with the rectangle to the start of the line.
     *
     * @param rect - A rectangle
     * @return Point - The closest intersection point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> points = new ArrayList<Point>();
        Line line = new Line(this.start(), this.end());
        points = rect.intersectionPoints(line);
        if (!points.isEmpty()) {
            Point min = points.get(0);
            for (Point p : points) {
                if (p == null) {
                    continue;
                }
                if (line.start().distance(p) < line.start().distance(min)) {
                    min = p;
                }
            }
            return min;
        }
        return null;
    }
}

