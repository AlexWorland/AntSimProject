public class Brood extends Ant{

    protected int timeTillGrown;
    protected String nameOfQueen;

    public Brood() {
        age = 0;
        timeTillGrown = 100; //TODO Come up with clever way to randomize time remaining
    }

    public Brood(String queenName) {
        age = 0;
        timeTillGrown = 100; //TODO Come up with clever way to randomize time remaining
        nameOfQueen = queenName;
    }

    @Override
    public void advanceTime() {
        super.advanceTime();
        timeTillGrown--;
        if (timeTillGrown == 0) {
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
