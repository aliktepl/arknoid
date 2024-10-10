package Logic;

import Shapes.Block;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 */
public class Level1 implements LevelInformation {

    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 1.
     */
    public Level1() {
        this.numberOfBalls = 1;
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.initialBallVelocities().add(Velocity.fromAngleAndSpeed(0, 3));
        this.paddleSpeed = 5;
        this.paddleWidth = 80;
        this.levelName = "Level 1";
        Point upperLeft = new Point(0, 0);
        Rectangle rect = new Rectangle(upperLeft, 600, 800);
        Block bg = new Block(rect);
        bg.setColor(Color.BLACK);
        this.background = bg;
        upperLeft = new Point(375, 200);
        rect = new Rectangle(upperLeft, 50, 50);
        Block b = new Block(rect);
        b.setColor(Color.RED);
        this.blocks = new ArrayList<Block>();
        this.blocks.add(b);
        this.numberOfBlocksToRemove = 1;
    }

    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
}
