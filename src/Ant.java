public class Ant {
    protected String name;
    protected int age;
    protected String type;
    protected int energy;
    protected String nameOfQueen;
    protected int lifespan;
    protected boolean isDead = false;
    protected Location location;
    protected int moveSpeed;

    public Ant() {
        age = 0;
        type = "ant";
    }

    public Ant(Brood b) {
        age = 0;
        type = "ant";
//        nameOfQueen = b.get
    }

    public Ant(String name) {
        age = 0;
        this.name = name;
        type = "ant";
    }

    public void advanceTime() {
        age++;
        if (age >= lifespan) {
            this.isDead = true;
        }
    }

    public void eat(Food f) {
        energy += f.getEnergy();
    }

    public void setLocation(int x, int y, int level, World w) {
       location = w.getLevel(level).getLocation(x, y);
    }

    public void setLoctaion(int x, int y, World w) {
        location = w.getLevels().get(location.getLevel()).getLocation(x, y);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
