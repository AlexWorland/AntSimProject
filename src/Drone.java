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


}