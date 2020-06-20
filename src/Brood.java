public class Brood extends Ant{

    protected int timeTillGrown;
    protected boolean hasGrown = false;


    public Brood() {
        age = 0;
        timeTillGrown = 112; //TODO Come up with clever way to randomize time remaining
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
        if (energy < 50 && food != null) {
            eat();
        }
        timeTillGrown--;
        if (timeTillGrown == 0) {
            hasGrown = true;
            Grow();
        }
    }

    public void recieveFood(Food f) {
        food = f;
    }

    public boolean canRecieveFood() {
        return (food == null);
    }

    public void Grow() {
        Main.addAntFromBrood(this); // TODO NEED TO LOOK AT. What happens when growing time comes and theres already an ant on the tile?
    }



    public int getTimeTillGrown() {
        return timeTillGrown;
    }
}
