import java.util.ArrayList;
import java.util.Random;

public class World {
    private int numOfLevels;
    private final ArrayList<Level> levels;
    private int  levelX;
    private int levelY;
    private int defaultLevelXY = 128;

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
        levels.add(new Level(levelX, levelY, numOfLevels));
        numOfLevels++;
    }

    public World(int x, int y, int numOfLevels) {
        this.numOfLevels = numOfLevels;
        levelX = x;
        levelY = y;
        levels = new ArrayList<Level>();
        for (int i = 0; i < numOfLevels; i++) {
            levels.add(new Level(levelX, levelY, i));
        }
    }

    public void addLevel() {
        levels.add(new Level(levelX, levelY, numOfLevels));
        numOfLevels++;
    }

    public Level getLevel(int level) {
        return levels.get(level);
    }

    public Location getLocation(int x, int y, int level) {
        int a = x;
        int b = y;
        int c = level;
        return levels.get(c).getLocation(a, b);
    }

    public int getNumOfLevels() {
        return numOfLevels;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public int getLevelX() {
        return levelX;
    }

    public int getLevelY() {
        return levelY;
    }

    public void print() {
        for (Level l: levels
             ) {
            l.print();
            System.out.print("\n\n");
        }
    }

//    public void addLevel(int x, int y) {
//        levels.add(new Level(x, y));
//        numOfLevels++;
//    }
//
//    public void addLevel() {
//        levels.add(new Level(levelX, levelY));
//        numOfLevels++;
//    }

}

class Level {
    protected final int x;
    protected final int y;
    protected final int level;
    protected ArrayList<ArrayList<Location>> locationList = new ArrayList<ArrayList<Location>>();
    protected int[][] levelData;
    protected int[][] foodData;

    public Level(int xy) {
        x = xy;
        y = xy;
        this.level = 0;
        levelData = new int[x][y];
        levelGenerate(x, y);
    }

    public Level(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
        levelData = new int[x][y];
        levelGenerate(x, y);
    }

    private void levelGenerate(int x, int y) {
        locationList = initialize(x,y,locationList);
        locationList = wallsGen(locationList);
        locationList = foodGen(locationList);
    }

    public ArrayList<ArrayList<Location>> wallsGen(ArrayList<ArrayList<Location>> list) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Random rand = new Random();
                int q = rand.nextInt();
                list.get(i).get(j).setIsWall(q % 2 == 0);
            }
        }
        return list;
    }

    /*
    TODO might want to make food not appear in walls. Maybe thats ok, but they need to dig the wall first
     */
    public ArrayList<ArrayList<Location>> foodGen(ArrayList<ArrayList<Location>> list) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Random rand = new Random();
                int q = rand.nextInt();
                list.get(i).get(j).setHasFood(q % 3 == 0);
            }
        }
        return list;
    }

//    public int[][] wallsGenerator(int [][] levelData) {
//        for (int i = 0; i < x; i++) {
//            locationList.add(new ArrayList<Location>());
//            for (int j = 0; j < y; j++) {
//                Random rand = new Random();
//                int q = rand.nextInt();
//                if (q % 2 == 0) {
//                    levelData[i][j] = 0;
//                    locationList.get(i).add()
//                } else {
//                    levelData[i][j] = 1;
//                }
//            }
//        }
//        return levelData;
//    }

    public int[][] foodGenerator(int[][] foodData) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Random rand = new Random();
                int q = rand.nextInt();
                if (q % 3 == 0) {
                    foodData[i][j] = 1;
                } else {
                    foodData[i][j] = 0;
                }
            }
        }
        return foodData;
    }

    public ArrayList<ArrayList<Location>> initialize(int x, int y, ArrayList<ArrayList<Location>> list) {
        for (int i = 0; i < y; i++) {
            list.add(new ArrayList<Location>());
            for (int j = 0; j < x; j++) {
                list.get(i).add(new Location(i, j, level));
            }
        }
        return list;
    }

    public Location getLocation(int x, int y) {
        return locationList.get(y).get(x);
    }

    public int[][] getLevelData() {
        return levelData;
    }

    public void print() {
        for (ArrayList<Location> ar: locationList
             ) {
            for (Location l: ar
                 ) {
                if (l.getIsWall()) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
                if (l.getHasFood()) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
                System.out.print("    ");
            }
            System.out.println();
        }
    }
}