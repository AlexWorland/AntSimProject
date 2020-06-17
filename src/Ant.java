public class Ant {
    protected String name;
    protected int age;
    protected String type;
    protected int energy;
    protected String nameOfQueen;

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

    public void antDeath() {
        Main.removeAnt(this);
    }

    public void advanceTime() {
        age++;
    }

    public void eat(Food f) {
        energy += f.getEnergy();
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
