import java.util.Random;

public class Food {
    protected int energy;

    public Food() {
        Random rand = new Random();
        int delta = rand.nextInt(200) - 100;
        energy = 100 + delta;
    }

    public int getEnergy() {
        return energy;
    }
}
