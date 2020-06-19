import org.jetbrains.annotations.NotNull;

public class Drone extends Ant {

    private boolean hasFood;
    private boolean hasDirt;
    private boolean hasBrood;
    private Food food;

    public Drone() {
        age = 0;
        type = "drone";
    }

    public Drone(String name) {
        age = 0;
        type = "drone";
        this.name = name;
    }

    public Drone(Brood b) {
        age = 0;
        type = "drone";
        name = b.getName();
        nameOfQueen = b.nameOfQueen; // Set and Get methods?
        lifespan = 125;
    }

    public void dig() {
        if (location.getIsWall()) {
            location.setIsWall(false);
            energy -= 10;
        }
    } //TODO need this to be worked out

    public void moveDirt() { //TODO maybe make a dirt object? Probably dont need to but might not hurt?

    }

    public void placeDirt() {
        if(!location.getHasFood()) {
            location.setHasFood(true);
        }
        // TODO if not then needs to look somewhere else
    }

    public void feedBrood() { //TODO brood feeding mechanism

    }

    public void pickUpDirt() {
        if (location.can) {
            hasDirt = true;
        }
    }

    public void pickUpFood() {

    }

    public void pickUpBrood() {

    }

    public boolean isHandsFull() {
        return (hasDirt || hasFood || hasBrood);
    }

    @Override
    public void move(World w) {
        super.move(w);
    }
}
