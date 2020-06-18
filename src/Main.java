import java.util.ArrayList;

public class Main {
    private static AntManager man;
    public static void addAntFromBrood(Brood b) {
        man.addAntFromBrood(b);
    }

//    public static void removeAnt(Ant a) {
//        man.removeAnt(a);
//    }

    public static void addBrood(Queen q) {
        man.addBrood(q);
    }

    public static void main(String[] args) {
        //TODO Create World
        //TODO Intialize Ants
        //TODO Ask how many ants to start with
        //TODO Ask How long Simulation

        int worldX = 10;
        int worldY = 10;
        int numOfLevels = 20;
        man = new AntManager();
        World world = new World(worldX, worldY, numOfLevels);
        world.print();
        boolean simFlag = true;

//        for (Level l: world.levels
//             ) {
//            for (int[] a: l.levelData
//                 ) {
//                for (int b: a
//                     ) {
//                    System.out.print(b + " ");
//                }
//                System.out.println();
//            }
//        }

        man.addQueen("THEQUEEN");

        int time = 0;
        while (simFlag) {

            man.advanceTime();
            time++;
            System.out.print("\rTime: " + time + " ");
            man.printStatus();
            System.out.print("\r");

//            System.out.print("\rTime: " + time + " Queens: " + man.queens.size() + " Soliders: " + man.soldiers.size() +
//                    " Drones: " + man.drones.size() + " Brood: " + man.brood.size() + "\r");
//            if (time == 50000) {
//                int stopHere = 0;
//            }
        }


    }
}
