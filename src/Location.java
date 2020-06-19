public class Location {

    private int x;
    private int y;
    private int level; // 0 = top level
    private boolean hasFood;
    private Food food;
    private boolean isWall;
    private boolean containsAnt;
    private boolean containsBrood;
    private Brood brood;
    private Ant ant;

    public Location(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
        hasFood = false;
        isWall = false;
        containsAnt = false;
        ant = null;
    }

//    public Location() {
//        x = 0;
//        y = 0;
//        level = 0;
//        hasFood = false;
//        isWall = false;
//    }

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

    public boolean getContainsAnt() {
        return containsAnt;
    }

    public void addAnt(Ant a) {
        containsAnt = true;
        ant = a;
    }

    public void addAntFromBrood(Ant a) {
        containsAnt = true;
        containsBrood = false;
        brood = null;
        ant = a;
    }

    public Ant removeAnt() {
        containsAnt = false;
        Ant a = ant;
        ant = null; //PROBABY BAD. COPY METHOD PROBABLY NEEDED
        return a;
    }

    public void addBrood(Brood b) {
        containsBrood = true;
        brood = b;
    }

    public Brood moveBrood() {
        containsBrood = false;
        Brood b = brood;
        brood = null;
        return b;
    }

    public void removeBrood() {
        containsBrood = false;
        brood = null;
    }

    public boolean getContainsBrood() {
        return containsBrood;
    }

    public boolean canLayBrood() {
        return (!isWall && !containsBrood);
    }

    public void print() {

        if (isWall) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }

        if (hasFood) {
            System.out.print("F");
        } else {
            System.out.print("0");
        }

        if(containsAnt) {
            System.out.print("A");
        } else {
            System.out.print("0");
        }

        if (containsBrood) {
            System.out.print("B");
        } else {
            System.out.print("0");
        }
    }
}
