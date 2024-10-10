//319049540 Alik Teplitsky
package Shapes;

import Logic.CollisionInfo;
import Logic.GameLevel;
import Logic.GameEnvironment;
import Logic.Velocity;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Ball.
 *
 * @author Alik Teplitsky
 */
public class Ball implements Sprite {
    private static final int DEFAULT_V = 0;
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private Paddle paddle;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor.
     *
     * @param center - center point of the ball.
     * @param r      - radius of the ball.
     * @param color  - color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.color = color;
        this.r = r;
        this.setVelocity(DEFAULT_V, DEFAULT_V);
    }

    /**
     * Constructor.
     *
     * @param x     - x of the center point.
     * @param y     - y of the center point.
     * @param r     - radius of the ball.
     * @param color - color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.setVelocity(DEFAULT_V, DEFAULT_V);
    }

    /**
     * Get x of the center.
     *
     * @return int - x of the center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Get y of the center point.
     *
     * @return int - y of the center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Get the radius of the ball.
     *
     * @return int - radius.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Get the color of the ball.
     *
     * @return java.awt.Color - color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draw the ball.
     *
     * @param surface - the surface on which to draw the ball.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * Set the velocity.
     *
     * @param v - A velocity object.
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     * Set the velocity which change of x and change of y.
     *
     * @param dx - change on the x-axis.
     * @param dy - change on the y-axis.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * Get the velocity of the ball.
     *
     * @return v - Velocity of the ball.
     */
    public Velocity getVelocity() {
        return v;
    }

    /**
     * Get a paddle for the ball.
     *
     * @param paddle - A paddle
     */
    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    /**
     * Set the game environment.
     *
     * @param environment - A game environment.
     */
    public void setGameEnvironment(GameEnvironment environment) {
        this.gameEnvironment = environment;
    }

    /**
     * Move the ball one step according the velocity set. If the ball hits the one of the blocks, change the
     * direction of the ball on the relevant axis.
     */
    public void moveOneStep() {
        Point p = new Point(this.getX() + this.getVelocity().getDx(), this.getY() + this.getVelocity().getDy());
        Line trajectory = new Line(this.center, p);
        CollisionInfo closestCollision = gameEnvironment.getClosestCollision(trajectory);
        if (closestCollision != null) {
            this.center = new Point(closestCollision.collisionPoint().getX() - this.getVelocity().getDx(),
                    closestCollision.collisionPoint().getY() - this.getVelocity().getDy());
            this.v = closestCollision.collisionObject().hit(this, closestCollision.collisionPoint(),
                    this.getVelocity());
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    @Override
    public void timePassed() {
        if (checkPaddle()) {
            this.center = new Point(this.getX(), paddle.getCollisionRectangle().getUpperHorizontal().start().getY()
            - this.getVelocity().getDy());
        }
        moveOneStep();
    }

    /**
     * Add the ball to the game.
     *
     * @param g - A game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Remove the ball from the game.
     *
     * @param g - a game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * Check if the ball is inside the paddle.
     *
     * @return boolean - true if the ball is inside the paddle
     */
    public boolean checkPaddle() {
        return this.center.getX() < this.paddle.getCollisionRectangle().getRightVertical().start().getX()
                && this.center.getX() > this.paddle.getCollisionRectangle().getLeftVertical().start().getX()
                && this.center.getY() > this.paddle.getCollisionRectangle().getUpperHorizontal().start().getY()
                && this.center.getY() < this.paddle.getCollisionRectangle().getLowerHorizontal().start().getY();
    }
}
