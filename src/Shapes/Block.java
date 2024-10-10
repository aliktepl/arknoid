//319049540 Alik Teplitsky
package Shapes;
import Logic.GameLevel;
import Logic.HitListener;
import Logic.HitNotifier;
import Logic.Velocity;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A Class that defines a block the ball can collide with.
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * Create a new rectangular block.
     *
     * @param rect - A rectangle.
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        //Default color.
        this.color = Color.GRAY;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * Get the rectangle.
     *
     * @return Rectangle rect
     */
    public Rectangle getRect() {
        return this.rect;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = currentVelocity;
        if (collisionPoint.getX() == rect.getLeftVertical().start().getX()
                || collisionPoint.getX() == rect.getRightVertical().start().getX()) {
            v = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        } else if (collisionPoint.getY() == rect.getUpperHorizontal().start().getY()
                || collisionPoint.getY() == rect.getLowerHorizontal().start().getY()) {
            v = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else if (collisionPoint.equals(rect.getUpperLeft()) || collisionPoint.equals(rect.getUpperHorizontal().end())
                || collisionPoint.equals(rect.getLowerHorizontal().start())
                || collisionPoint.equals(rect.getLowerHorizontal().end())) {
            v = new Velocity(-currentVelocity.getDx(), -currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return new Velocity((int) v.getDx(), (int) v.getDy());
    }

    /**
     * Draws the block unto the surface.
     *
     * @param surface - A surface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) rect.getUpperLeft().getX(), (int) rect.getUpperLeft().getY(),
                (int) rect.getWidth(), (int) rect.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * Adds the block to the game.
     *
     * @param g - A game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Set the color of the block.
     *
     * @param color - A color for the block.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Removes the block from the game.
     *
     * @param game - A game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
