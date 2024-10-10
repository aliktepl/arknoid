//319049540 Alik Teplitsky
package Shapes;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of sprite objects.
 */
public class SpriteCollection {

    private List<Sprite> spriteList;

    /**
     * Create a new collection of sprites, held in a list.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<Sprite>();
    }

    /**
     * Add a sprite to the list.
     *
     * @param s - Sprite
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }

    /**
     * get the list of sprites.
     *
     * @return List of sprites.
     */
    public List<Sprite> getSpriteList() {
        return spriteList;
    }

    /**
     * Set a sprite list.
     *
     * @param spriteList - A new sprite list.
     */
    public void setSpriteList(List<Sprite> spriteList) {
        this.spriteList = spriteList;
    }

    /**
     * Notify all the sprites that time has passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<Sprite>(spriteList);
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }

    /**
     * Draw all the sprites on the surface.
     *
     * @param d - DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : spriteList) {
            s.drawOn(d);
        }
    }
}
