package Logic;

import Shapes.Block;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 3.
 */
public class Level3 implements LevelInformation {

    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 3.
     */
    public Level3() {
        this.numberOfBalls = 2;
        this.initialBallVelocities = new ArrayList<Velocity>();
        for (int i = 0; i < 2; i++) {
            this.initialBallVelocities().add(Velocity.fromAngleAndSpeed(0, 3));
        }
        this.paddleSpeed = 5;
        this.paddleWidth = 80;
        this.levelName = "Level 3";
        Point upperLeft = new Point(0, 0);
        Rectangle rect = new Rectangle(upperLeft, 600, 800);
        Block bg = new Block(rect);
        bg.setColor(Color.GREEN);
        this.background = bg;
        this.blocks = new ArrayList<Block>();
        for (int i = 0; i < 10; i++) {
            upperLeft = new Point(250 + i * 50, 100);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.GRAY);
            blocks.add(b);
        }
        for (int i = 0; i < 9; i++) {
            upperLeft = new Point(300 + i * 50, 120);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.RED);
            blocks.add(b);
        }
        for (int i = 0; i < 8; i++) {
            upperLeft = new Point(350 + i * 50, 140);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.YELLOW);
            blocks.add(b);
        }
        for (int i = 0; i < 7; i++) {
            upperLeft = new Point(400 + i * 50, 160);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.BLUE);
            blocks.add(b);
        }
        for (int i = 0; i < 6; i++) {
            upperLeft = new Point(450 + i * 50, 180);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            b.setColor(Color.WHITE);
            blocks.add(b);
        }
        this.numberOfBlocksToRemove = 40;
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
