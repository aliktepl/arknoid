package Logic;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {

    private Counter score;

    /**
     * Instantiates a new Game flow.
     */
    public GameFlow() {
        this.score = new Counter(0);
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.score);
            if (levels.indexOf(levelInfo) == levels.size() - 1) {
                level.setLast();
            }
            level.initialize();
            while (level.getBallCounter().getValue() > 0 && level.getBlockCounter().getValue() > 0) {
                level.run();
            }
            if (level.getBallCounter().getValue() == 0) {
                break;
            }
        }
    }
}
