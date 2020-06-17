public class Queen extends Ant {

    protected int offspring;

    public Queen() {
        age = 0;
        type = "queen";
    }

    public Queen(String name) {
        age = 0;
        type = "queen";
        this.name = name;
    }

    public void layBrood() {
        offspring++;
        Main.addBrood(this);
    }

    public int getOffspring() {
        return offspring;
    }
}
