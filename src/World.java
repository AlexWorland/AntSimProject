import java.util.ArrayList;
import java.util.Random;

public class World {
    protected int numOfLevels;
    protected ArrayList<Level> levels;
    protected int  levelX;
    protected int levelY;
    protected int defaultLevelXY = 128;

    public World() {
        numOfLevels = 0;
        levels = new ArrayList<Level>();
        levels.add(new Level(defaultLevelXY));
        numOfLevels++;
    }

    public World(int x, int y) {
        numOfLevels = 0;
        levels = new ArrayList<Level>();
        levelX = x;
        levelY = y;
        levels.add(new Level(levelX, levelY));
        numOfLevels++;
    }

    public void addLevel(int x, int y) {
        levels.add(new Level(x, y));
        numOfLevels++;
    }

    public void addLevel() {
        levels.add(new Level(levelX, levelY));
        numOfLevels++;
    }

}

class Level {
    protected final int x;
    protected final int y;
    protected int[][] levelData;

    public Level(int xy) {
        x = xy;
        y = xy;
        levelGenerate(x, y);
    }

    public Level(int x, int y) {
        this.x = x;
        this.y = y;
        levelGenerate(x, y);
    }

    private void levelGenerate(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Random rand = new Random();
                int q = rand.nextInt();
                if (q % 2 == 0) {
                    levelData[i][j] = 0;
                } else {
                    levelData[i][j] = 1;
                }
            }
        }
    }



    public int[][] getLevelData() {
        return levelData;
    }
}