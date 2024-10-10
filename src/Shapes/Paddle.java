//319049540 Alik Teplitsky
package Shapes;
import Logic.GameLevel;
import Logic.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * A paddle that moves.
 */
public class Paddle implements Sprite, Collidable {

    private Rectangle rect;
    private KeyboardSensor keyboard;

    /**
     * Create a new paddle.
     *
     * @param keyboard    - Keyboard sensor for user input.
     * @param paddleWidth the paddle width
     */
    public Paddle(KeyboardSensor keyboard, int paddleWidth) {
        Point upperLeft = new Point(400 - (double) (paddleWidth / 2), 575);
        this.rect = new Rectangle(upperLeft, 20, paddleWidth);
        this.keyboard = keyboard;
    }

    /**
     * Move the paddle left.
     */
    public void moveLeft() {
        if (this.rect.getUpperLeft().getX() >= 55) {
            this.rect.setUpperLeft(new Point(rect.getUpperLeft().getX() - 5, rect.getUpperLeft().getY()));
        }


    }

    /**
     * Move the paddle right.
     */
    public void moveRight() {
        if (this.rect.getUpperHorizontal().end().getX() <= 745) {
            this.rect.setUpperLeft(new Point(rect.getUpperLeft().getX() + 5, rect.getUpperLeft().getY()));
        }
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    /**
     * Detect if the paddle has been hit, and change the velocity of the ball depending on the section of the paddle
     * that has been hit.
     *
     * @param collisionPoint  - The point of collision.
     * @param currentVelocity - Velocity on impact.
     * @return - The new velocity after impact.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = currentVelocity;
        if (collisionPoint.getX() == rect.getLeftVertical().start().getX()
                || collisionPoint.getX() == rect.getRightVertical().start().getX()) {
            v = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        if (collisionPoint.getY() == rect.getUpperHorizontal().start().getY()) {
            if (rect.getUpperLeft().getX() < collisionPoint.getX()
                    && collisionPoint.getX() <= this.getCollisionRectangle().getUpperLeft().getX()
                    + this.getCollisionRectangle().getWidth() / 5) {
                v = Velocity.fromAngleAndSpeed(-60, 3);
            } else if (collisionPoint.getX() <= this.getCollisionRectangle().getUpperLeft().getX()
                    + (2 * this.getCollisionRectangle().getWidth()) / 5) {
                v = Velocity.fromAngleAndSpeed(-30, 3);
            } else if (collisionPoint.getX() <= this.getCollisionRectangle().getUpperLeft().getX()
                    + (3 * this.getCollisionRectangle().getWidth()) / 5) {
                v = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            } else if (collisionPoint.getX() <= this.getCollisionRectangle().getUpperLeft().getX()
                    + (4 * this.getCollisionRectangle().getWidth()) / 5) {
                v = Velocity.fromAngleAndSpeed(30, 3);
            } else if (collisionPoint.getX() < this.getCollisionRectangle().getUpperLeft().getX()
                    + this.getCollisionRectangle().getWidth()) {
                v = Velocity.fromAngleAndSpeed(60, 3);
            }
        }
        return v;
    }

    /**
     * Draw the paddle onto the surface.
     *
     * @param d - A surface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.ORANGE);
        d.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());

    }

    @Override
    public void timePassed() {
        if (keyboard.isPressed("a") || keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed("d") || keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * Add the paddle to the game.
     *
     * @param g - A game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
