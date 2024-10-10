//319049540 Alik Teplitsky


import Logic.LevelInformation;
import Logic.Level1;
import Logic.Level2;
import Logic.Level3;
import Logic.Level4;
import Logic.GameFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * Main game class.
 */
public class Ass6Game {
    /**
     * Main driver function of the game.
     *
     * @param args - User input
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        for (String s : args) {
            switch (s) {
                case "1":
                    levels.add(new Level1());
                    break;
                case "2":
                    levels.add(new Level2());
                    break;
                case "3":
                    levels.add(new Level3());
                    break;
                case "4":
                    levels.add(new Level4());
                    break;
                default:
                    break;
            }
        }
        if (levels.size() == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }
        GameFlow flow = new GameFlow();
        flow.runLevels(levels);
    }
}
