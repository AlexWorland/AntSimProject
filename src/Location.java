public class Location {

    private int x;
    private int y;
    private int level; // 0 = top level
    private boolean hasFood;
    private Food food;
    private boolean isWall;

    public Location(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
        hasFood = false;
        isWall = false;
    }

    public Location() {
        x = 0;
        y = 0;
        level = 0;
        hasFood = false;
        isWall = false;
    }

//    public Location(World w, int x, int y, int level) {
//        this.x = x;
//        this.y = y;
//        this.level = level;
//        hasFood = w.
//    }

    public boolean getHasFood() {
        return hasFood;
    }

    public void setHasFood(boolean b) {
        hasFood = b;
        food = new Food(); //DEBUG PURPOSE REMOVE FROM FINAL
        if (b) {
            food = new Food();
        } else {
            food = null;
        }
    }

    public Food getFood() {
        return food;
    }

    public boolean getIsWall() {
        return isWall;
    }

    public void setIsWall(boolean b) {
        isWall = b;
    }

    public Location getLocation() {
        return this;
    }

    public void setLocation(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }

    public int[] getCoordinates() {
        return new int[]{x, y, level};
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }
}
