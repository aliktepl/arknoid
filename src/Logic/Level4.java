package Logic;

import Shapes.Block;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 4.
 */
public class Level4 implements LevelInformation {

    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 4.
     */
    public Level4() {
        this.numberOfBalls = 3;
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.initialBallVelocities().add(Velocity.fromAngleAndSpeed(-30, 3));
        this.initialBallVelocities().add(Velocity.fromAngleAndSpeed(0, 3));
        this.initialBallVelocities().add(Velocity.fromAngleAndSpeed(30, 3));
        this.paddleSpeed = 5;
        this.paddleWidth = 80;
        this.levelName = "Level 4";
        Point upperLeft = new Point(0, 0);
        Rectangle rect = new Rectangle(upperLeft, 600, 800);
        Block bg = new Block(rect);
        bg.setColor(new Color(0x7D7DE0));
        this.background = bg;
        this.blocks = new ArrayList<Block>();
        for (int i = 0; i < 14; i++) {
            upperLeft = new Point(50 + i * 50, 100);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.GRAY);
            blocks.add(b);
        }
        for (int i = 0; i < 14; i++) {
            upperLeft = new Point(50 + i * 50, 120);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.RED);
            blocks.add(b);
        }
        for (int i = 0; i < 14; i++) {
            upperLeft = new Point(50 + i * 50, 140);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.YELLOW);
            blocks.add(b);
        }
        for (int i = 0; i < 14; i++) {
            upperLeft = new Point(50 + i * 50, 160);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.GREEN);
            blocks.add(b);
        }
        for (int i = 0; i < 14; i++) {
            upperLeft = new Point(50 + i * 50, 180);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.WHITE);
            blocks.add(b);
        }
        for (int i = 0; i < 14; i++) {
            upperLeft = new Point(50 + i * 50, 200);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.PINK);
            blocks.add(b);
        }
        for (int i = 0; i < 14; i++) {
            upperLeft = new Point(50 + i * 50, 220);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.CYAN);
            blocks.add(b);
        }
        this.numberOfBlocksToRemove = 105;
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
