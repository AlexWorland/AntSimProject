public class Location {

    private int x;
    private int y;
    private int level; // 0 = top level
    private boolean hasFood;
    private Food food;
    private boolean isWall;
    private boolean hasAnt;
    private boolean hasBrood;
    private Brood brood;
    private Ant ant;

    public Location(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
        hasFood = false;
        isWall = false;
        hasAnt = false;
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

    public boolean getHasAnt() {
        return hasAnt;
    }

    public void addAnt(Ant a) {
        hasAnt = true;
        ant = a;
    }

    public void addAntFromBrood(Ant a) {
        hasAnt = true;
        hasBrood = false;
        brood = null;
        ant = a;
    }

    public Ant removeAnt() {
        hasAnt = false;
        Ant a = ant;
        ant = null; //PROBABY BAD. COPY METHOD PROBABLY NEEDED
        return a;
    }

    public void addBrood(Brood b) {
        hasBrood = true;
        brood = b;
    }

    public Brood moveBrood() {
        hasBrood = false;
        Brood b = brood;
        brood = null;
        return b;
    }

    public void removeBrood() {
        hasBrood = false;
        brood = null;
    }

    public boolean getHasBrood() {
        return hasBrood;
    }

    public boolean canPlaceBrood() {
        return (!isWall && !hasBrood && !hasFood);
    }

    public boolean canPlaceDirt() {
        return (!isWall && !hasFood && !hasBrood);
    }

    public boolean canRemoveDirt() {
        // return (!)
        /* TODO: Figure out if dirt can be removed. (Only if no food and no brood, although if its a wall its -
                assumed that no ants/brood can be present.)
         */
    }

    public void placeDirt() {
        isWall = true;
    }

    public void removeDirt() {
        isWall = false;
    }

    public boolean canPlaceFood() {
        return (!hasFood && !isWall);
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

        if(hasAnt) {
            System.out.print("A");
        } else {
            System.out.print("0");
        }

        if (hasBrood) {
            System.out.print("B");
        } else {
            System.out.print("0");
        }
    }
}
