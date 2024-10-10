package Logic;

import Shapes.Block;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The type Level 2.
 */
public class Level2 implements LevelInformation {

    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;
    private int numberOfBlocksToRemove;

    /**
     * Instantiates a new Level 2.
     */
    public Level2() {
        this.numberOfBalls = 10;
        this.initialBallVelocities = new ArrayList<Velocity>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(-60, 3));
            }
            if (i > 5) {
                this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(60, 3));
            }
        }
        this.paddleSpeed = 5;
        this.paddleWidth = 500;
        this.levelName = "Level 2";
        Point upperLeft = new Point(0, 0);
        Rectangle rect = new Rectangle(upperLeft, 600, 800);
        Block bg = new Block(rect);
        bg.setColor(Color.WHITE);
        this.background = bg;
        this.blocks = new ArrayList<Block>();
        int count = 0;
        for (int i = 0; i < 14; i++) {
            upperLeft = new Point(50 + i * 50, 100);
            rect = new Rectangle(upperLeft, 20, 50);
            Block b = new Block(rect);
            if (count <= 1) {
                b.setColor(Color.RED);
            } else if (count <= 3) {
                b.setColor(Color.ORANGE);
            } else if (count <= 5) {
                b.setColor(Color.YELLOW);
            } else if (count <= 7) {
                b.setColor(Color.GREEN);
            } else if (count <= 9) {
                b.setColor(Color.BLUE);
            } else if (count <= 11) {
                b.setColor(Color.PINK);
            } else if (count <= 13) {
                b.setColor(Color.CYAN);
            }
            this.blocks.add(b);
            count++;
        }
        this.numberOfBlocksToRemove = 14;
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
