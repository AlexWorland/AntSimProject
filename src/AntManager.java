import java.lang.invoke.TypeDescriptor;
import java.util.ArrayList;
import java.util.ListIterator;

public class AntManager {

    ArrayList<Queen> queens = new ArrayList<Queen>();
    ArrayList<Drone> drones = new ArrayList<Drone>();
    ArrayList<Soldier> soldiers = new ArrayList<Soldier>();
    ArrayList<Brood> brood = new ArrayList<Brood>();
    ArrayList<Ant> deadAntsList = new ArrayList<Ant>();
    protected int droneThreshold;
    protected int soldierThreshold;
    protected int queenThreshold;


    public AntManager() {
        droneThreshold = 1000;
        soldierThreshold = 700;
        queenThreshold = 10;
    }

    public void addAntFromBrood(Brood b) {
        if (queens.size() < queenThreshold) {
            queens.add(new Queen(b));
        } else if (drones.size() < droneThreshold) {
            drones.add(new Drone(b));
        } else if (soldiers.size() < soldierThreshold) {
            soldiers.add(new Soldier(b));
        }
    }

    public void advanceTime() {
        ArrayList<Ant> deadAnts = new ArrayList<Ant>();
        ArrayList<Brood> grownBrood = new ArrayList<Brood>();
        for (Brood b : brood
        ) {
            b.advanceTime();
            if (b.isDead) {
                deadAnts.add(b);
                deadAntsList.add(b);
            }
            if (b.hasGrown) {
                grownBrood.add(b);
            }
        }

        if (grownBrood.size() > 0) {
            brood.removeAll(grownBrood);
        }

        if (deadAnts.size() > 0) {
            brood.removeAll(deadAnts);
            deadAnts.clear();
        }

        for (Drone d : drones
        ) {
            d.advanceTime();
            if (d.isDead) {
                deadAnts.add(d);
                deadAntsList.add(d);
            }
        }

        if (deadAnts.size() > 0) {
            drones.removeAll(deadAnts);
            deadAnts.clear();
        }

        for (Soldier s : soldiers
        ) {
            s.advanceTime();
            if (s.isDead) {
                deadAnts.add(s);
                deadAntsList.add(s);
            }
        }

        if (deadAnts.size() > 0) {
            soldiers.removeAll(deadAnts);
            deadAnts.clear();
        }

        for (Queen q : queens
        ) {
            q.advanceTime();
            if (q.isDead) {
                deadAnts.add(q);
                deadAntsList.add(q);
            }
        }

        if (deadAnts.size() > 0) {
            queens.removeAll(deadAnts);
            deadAnts.clear();
        }
    }

    public void removeAnts() {

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

//    public void removeAnt(Ant a) {
//        deadAnts.add(a);
//        String s = a.getType();
//        switch (s) {
//            case "drone": {
//                drones.remove(a); // Might be weird
//            }
//            case "soldier": {
//                soldiers.remove(a);
//            }
//            case "queen": {
//                queens.remove(a);
//            }
//            case "brood": {
//                brood.remove(a);
//            }
//        }
//    }

}
