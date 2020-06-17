import java.lang.invoke.TypeDescriptor;
import java.util.ArrayList;

public class AntManager {

    ArrayList<Queen> queens = new ArrayList<Queen>();
    ArrayList<Drone> drones = new ArrayList<Drone>();
    ArrayList<Soldier> soldiers = new ArrayList<Soldier>();
    ArrayList<Brood> brood = new ArrayList<Brood>();
    ArrayList<Ant> deadAnts = new ArrayList<Ant>();
    protected int droneThreshold;
    protected int soldierThreshold;
    protected int queenThreshold;


    public AntManager() {
        droneThreshold = 100;
        soldierThreshold = 100;
        queenThreshold = 1;
    }

    public void addAntFromBrood(Brood b) {
        if (queens.size() < queenThreshold) {
            queens.add(new Queen(String.valueOf(System.currentTimeMillis())));
        } else if (drones.size() < droneThreshold) {
            drones.add(new Drone(b));
        } else if (soldiers.size() < soldierThreshold) {
            soldiers.add(new Soldier(b));
        }
    }

    public void addBrood(Queen q) {
        brood.add(new Brood(q.name));
    }

    public void addQueen(String s) {
        queens.add(new Queen(s));
    }

    public void addDrone() {
        drones.add(new Drone());
    }

    public void addSoldier() {

    }

    public void removeAnt(Ant a) {
        deadAnts.add(a);
        String s = a.getType();
        switch (s) {
            case "drone": {
                drones.remove(a); // Might be weird
            }
            case "soldier": {
                soldiers.remove(a);
            }
            case "queen": {
                queens.remove(a);
            }
        }
    }

}
