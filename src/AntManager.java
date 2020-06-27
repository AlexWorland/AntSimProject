import java.util.ArrayList;

public class AntManager {

    private final ArrayList<Queen> queens = new ArrayList<Queen>();
    private final ArrayList<Drone> drones = new ArrayList<Drone>();
    private final ArrayList<Soldier> soldiers = new ArrayList<Soldier>();
    private final ArrayList<Brood> brood = new ArrayList<Brood>();
    private final ArrayList<Ant> deadAntsList = new ArrayList<Ant>();
    private final int droneThreshold;
    private final int soldierThreshold;
    private final int queenThreshold;


    public AntManager() {
        droneThreshold = 30000;
        soldierThreshold = 20000;
        queenThreshold = 1000;
    }

    public void addAntFromBrood(Brood b) {
        if (queens.size() < queenThreshold) {
            queens.add(new Queen(b));
            b.getLocation().addAntFromBrood(queens.get(queens.size()-1));
        } else if (drones.size() < droneThreshold) {
            drones.add(new Drone(b));
            b.getLocation().addAntFromBrood(drones.get(drones.size()-1));
        } else if (soldiers.size() < soldierThreshold) {
            soldiers.add(new Soldier(b));
            b.getLocation().addAntFromBrood(soldiers.get(soldiers.size()-1));
        }
    }

    public void advanceTime() {
        ArrayList<Ant> deadAnts = new ArrayList<Ant>();
        ArrayList<Brood> grownBrood = new ArrayList<Brood>();

        //TODO: Check if brood, drones, and queens are empty.

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
        brood.get(brood.size()-1).setLocation(q.getLocation());
        q.getLocation().addBrood(brood.get(brood.size()-1));
    }

    public void addQueen(String s) {
        queens.add(new Queen(s));
    }

    public void addDrone() {
        drones.add(new Drone());
    }

    public void addSoldier() {

    }

    public void printStatus() {
        System.out.print("Queens: " + queens.size() + " Soldiers: " + soldiers.size() +
                " Drones: " + drones.size() + " Brood: " + brood.size() + " Dead: " + deadAntsList.size());
    }

//    public void spawnAnt(Ant a, Location l) {
//        if(l.getIsWall()) {
//            //TODO Something
//         } else if (!l.getContainsAnt()) {
//            a.setLocation(l);
//            l.addAnt(a);
//        }
//    }

    public boolean spawnQueen(Location l, String name) {
        if (validSpawnCheck(l)) {
            Queen q = new Queen(name);
            q.setLocation(l);
            l.addAnt(q);
            queens.add(q);
            return true;
        } else {
            System.out.println("Space already occupied by ant or wall.");
            return false;
        }
    }

    public void spawnSoldier(Location l) {
        if (validSpawnCheck(l)) {
            Soldier s = new Soldier();
            s.setLocation(l);
            l.addAnt(s);
            soldiers.add(s);
        } else {
            System.out.println("Space already occupied by ant or wall.");
        }
    }

    public void spawnDrone(Location l) {
        if (validSpawnCheck(l)) {
            Drone d = new Drone();
            d.setLocation(l);
            l.addAnt(d);
            drones.add(d);
        } else {
            System.out.println("Space already occupied by ant or wall.");
        }
    }

    public void spawnBrood(Location l) {
        if (validSpawnCheck(l)) {
            Brood b = new Brood();
            b.setLocation(l);
            l.addAnt(b);
            brood.add(b);
        } else {
            System.out.println("Space already occupied by ant or wall.");
        }
    }

    public boolean validSpawnCheck(Location l) {
        if (l.getIsWall()) {
            return false;
        } else return !l.getHasAnt();
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
