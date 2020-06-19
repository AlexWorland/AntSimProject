import org.jetbrains.annotations.NotNull;

public class Drone extends Ant {

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

    }

    public void feedBrood() { //TODO brood feeding mechanism

    }


}
