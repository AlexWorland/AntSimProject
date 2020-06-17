public class Soldier extends Ant {

    public Soldier() {
        age = 0;
        type = "soldier";
    }

    public Soldier(String name) {
        age = 0;
        type = "soldier";
        this.name = name;
    }

    public Soldier(Brood b) {
        age = 0;
        type = "soldier";
        name = b.getName();
        nameOfQueen = b.nameOfQueen;
        lifespan = 190;
    }

}
