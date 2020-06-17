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

    public Brood layBrood() {
        return new Brood(name);
    }

    public int getOffspring() {
        return offspring;
    }
}
