public class Queen extends Ant {

    protected int offspring;
    protected String ogName;

    public Queen(String name) {
        age = 0;
        type = "queen";
        this.name = name;
        ogName = this.toString();
        lifespan = 400;
    }

    public Queen(Brood b) {
        age = 0;
        type = "queen";
        name = this.toString();
        ogName = b.nameOfQueen;
        lifespan = 400;
    }

    @Override
    public void advanceTime() {
        super.advanceTime();
        layBrood();
    }

    public void layBrood() {
        if(location.canPlaceBrood()) {
            offspring++;
            Main.addBrood(this);
        } else {
            //DO NOTHING
        }
    }

    public int getOffspring() {
        return offspring;
    }
}
