
public class Drone extends Ant {

    private boolean hasFood;
    private boolean hasDirt;
    private boolean hasBrood;
    private Food food;
    private Brood brood;

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

        //TODo: need a way to determine which direction to be dug.

        if (location.canRemoveDirt() && !hasDirt && energy > 10) {
            location.removeDirt();
            energy -= 10;
            hasDirt = true;
        }
    }

    public void dig(Location l) {
        if (l.canRemoveDirt() && !hasDirt && energy > 10) {
            l.removeDirt();
            energy -= 10;
            hasDirt = true;
        }
    }

    // public void moveDirt() {} //TODO maybe make a dirt object? Probably dont need to but might not hurt?

    public void placeDirt() {
        if (location.canPlaceDirt() && hasDirt) {
            hasDirt = false;
            location.placeDirt();
        }
        // TODO if not then needs to look somewhere else
    }

    public void feedBrood() { //TODO brood feeding mechanism

    }

    public void pickUpDirt() {
        if (location.canRemoveDirt() && !hasDirt) {
            hasDirt = true;
            location.removeDirt();
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
