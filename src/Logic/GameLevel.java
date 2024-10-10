//319049540 Alik Teplitsky
package Logic;

import Shapes.Ball;
import Shapes.Block;
import Shapes.Collidable;
import Shapes.Paddle;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Sprite;
import Shapes.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The game class, which defines the game.
 */
public class GameLevel implements Animation {

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private LevelInformation information;
    private Counter blockCounter;
    private Counter ballCounter;
    private AnimationRunner runner;
    private boolean running;
    private Counter score;
    private boolean last;
    private KeyboardSensor keyboard;

    /**
     * Create a new game.
     *
     * @param information the information
     * @param score       the score
     */
    public GameLevel(LevelInformation information, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = new AnimationRunner(new GUI("Game", 800, 600), new Sleeper());
        this.information = information;
        this.score = score;
        this.last = false;
    }

    /**
     * Gets ball counter.
     *
     * @return the ball counter
     */
    public Counter getBallCounter() {
        return ballCounter;
    }

    /**
     * Gets block counter.
     *
     * @return the block counter
     */
    public Counter getBlockCounter() {
        return blockCounter;
    }

    /**
     * Adds a collidable to the game.
     *
     * @param c - A collidable.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Adds a sprite to the game.
     *
     * @param s - sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Initializes a new game, with the GUI, Sleeper, Balls, and blocks.
     */
    public void initialize() {
        GUI gui = this.runner.getGui();
        Sleeper sleeper = this.runner.getSleeper();
        List<Collidable> collidables = new ArrayList<>();
        this.keyboard = gui.getKeyboardSensor();
        this.blockCounter = new Counter(information.numberOfBlocksToRemove());
        BlockRemover blockRemover = new BlockRemover(this, this.blockCounter);
        ScoreTrackingListener scoreboard = new ScoreTrackingListener(score);
        ScoreIndicator indicator = new ScoreIndicator(score, information);
        this.createBorders();
        indicator.addToGame(this);
        for (Block b : this.information.blocks()) {
            b.addHitListener(blockRemover);
            b.addHitListener(scoreboard);
            b.addToGame(this);
        }
        Paddle paddle = new Paddle(this.keyboard, information.paddleWidth());
        paddle.addToGame(this);
        List<Ball> balls = new ArrayList<>();
        if (this.information.levelName().equals("Level 1")) {
            balls.add(new Ball(400, 500, 3, Color.WHITE));
        }
        if (this.information.levelName().equals("Level 2")) {
            balls.add(new Ball(200, 300, 3, Color.WHITE));
            balls.add(new Ball(250, 250, 3, Color.WHITE));
            balls.add(new Ball(300, 200, 3, Color.WHITE));
            balls.add(new Ball(350, 150, 3, Color.WHITE));
            balls.add(new Ball(450, 150, 3, Color.WHITE));
            balls.add(new Ball(500, 200, 3, Color.WHITE));
            balls.add(new Ball(550, 250, 3, Color.WHITE));
            balls.add(new Ball(600, 300, 3, Color.WHITE));
        }
        if (this.information.levelName().equals("Level 3")) {
            balls.add(new Ball(480, 500, 3, Color.WHITE));
            balls.add(new Ball(320, 500, 3, Color.WHITE));
        }
        if (this.information.levelName().equals("Level 4")) {
            balls.add(new Ball(360, 500, 3, Color.WHITE));
            balls.add(new Ball(420, 450, 3, Color.WHITE));
            balls.add(new Ball(480, 500, 3, Color.WHITE));
        }
        for (Ball ball : balls) {
            ball.setGameEnvironment(environment);
            for (Ball b : balls) {
                ball.setVelocity(this.information.initialBallVelocities().get(balls.indexOf(ball)));
            }
            ball.setPaddle(paddle);
            ball.addToGame(this);
        }
    }

    /**
     * The animation algorithm.
     */
    public void run() {
        this.running = true;
        this.runner.run(this);
    }

    /**
     * Creates 4 block at the edges of the screen to act a borders.
     */
    public void createBorders() {
        this.ballCounter = new Counter(this.information.numberOfBalls());
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        Block right = new Block(new Rectangle(new Point(750, 50), 550, 50));
        right.setColor(Color.GRAY);
        Block left = new Block(new Rectangle(new Point(0, 50), 550, 50));
        left.setColor(Color.GRAY);
        Block down = new Block(new Rectangle(new Point(50, 610), 50, 700));
        down.setColor(Color.GRAY);
        down.addHitListener(ballRemover);
        Block scoreboard = new Block(new Rectangle(new Point(0, 0), 25, 800));
        scoreboard.setColor(Color.CYAN);
        Block up = new Block(new Rectangle(new Point(0, 25), 25, 800));
        up.setColor(Color.GRAY);
        right.addToGame(this);
        left.addToGame(this);
        down.addToGame(this);
        scoreboard.addToGame(this);
        up.addToGame(this);
    }

    /**
     * Removes a collidable from the game environment.
     *
     * @param c - Collidable.
     */
    public void removeCollidable(Collidable c) {
        List<Collidable> collidables = this.environment.getCollidables();
        collidables.remove(c);
        environment.setCollidables(collidables);
    }

    /**
     * Remove the block from the sprite collection.
     *
     * @param s - Sprite.
     */
    public void removeSprite(Sprite s) {
        List<Sprite> spriteList = this.sprites.getSpriteList();
        spriteList.remove(s);
        this.sprites.setSpriteList(spriteList);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.information.getBackground().drawOn(d);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            KeyPressStoppableAnimation press = new KeyPressStoppableAnimation(keyboard, "space", this);
            this.runner.run(new PauseScreen(this.keyboard, press));
        }
        if (blockCounter.getValue() == 0) {
            score.increase(100);
            if (this.last) {
                KeyPressStoppableAnimation press = new KeyPressStoppableAnimation(keyboard, "space", this);
                this.runner.run(new YouWin(this.keyboard, this.runner, this.score.getValue(), press));
            }
            d = runner.getGui().getDrawSurface();
            this.information.getBackground().drawOn(d);
            this.sprites.drawAllOn(d);
            runner.getGui().show(d);
            this.running = false;
        }
        if (ballCounter.getValue() == 0) {
            KeyPressStoppableAnimation press = new KeyPressStoppableAnimation(keyboard, "space", this);
            this.runner.run(new GameOver(this.keyboard, this.runner, this.score.getValue(), press));
        }

    }

    /**
     * Sets last.
     */
    public void setLast() {
        this.last = true;
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
