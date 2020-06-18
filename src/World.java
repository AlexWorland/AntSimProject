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

    public void print() {
        for (Level l: levels
             ) {
            l.print();
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