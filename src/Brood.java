public class Brood extends Ant{

    protected int timeTillGrown;
    protected boolean hasGrown = false;


    public Brood() {
        age = 0;
        timeTillGrown = 100; //TODO Come up with clever way to randomize time remaining
    }

    public Brood(String queenName) {
        age = 0;
        lifespan = 150;
        type = "brood";
        timeTillGrown = 100; //TODO Come up with clever way to randomize time remaining
        nameOfQueen = queenName;
        name = this.toString();
    }

    @Override
    public void advanceTime() {
        super.advanceTime();
        timeTillGrown--;
        if (timeTillGrown == 0) {
            hasGrown = true;
            Grow();
        }
    }

    public void Grow() {
        Main.addAntFromBrood(this);
    }



    public int getTimeTillGrown() {
        return timeTillGrown;
    }
}
