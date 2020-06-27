import java.io.IOException;

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

    public static void clearConsole() throws IOException {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }

    public static void main(String[] args) {
        //TODO Create World
        //TODO Initialize Ants
        //TODO Ask how many ants to start with
        //TODO Ask How long Simulation

        int worldX = 10;
        int worldY = 10;
        int numOfLevels = 1;
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

//        man.addQueen("THEQUEEN");
        boolean canSpawn = false;
        int i = 0;
        int j = 0;
        while(!man.spawnQueen(world.getLocation(i, j, 0), "THE QUEEN")) {
            if (i < world.getLevelX()) {
                i++;
            } else if (j < world.getLevelY()){
                j++;
                i = 0;
            }
        }

        int time = 0;
        while (simFlag) { //TODO need a way to stop the sim.

            man.advanceTime();
            time++;
            world.print();
            System.out.print("\rTime: " + time + " ");
            man.printStatus();
//            System.out.print("\r");
            try {
                clearConsole();
                System.out.print("\033[H\033[2J");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
//            System.out.print("\rTime: " + time + " Queens: " + man.queens.size() + " Soliders: " + man.soldiers.size() +
//                    " Drones: " + man.drones.size() + " Brood: " + man.brood.size() + "\r");
//            if (time == 50000) {
//                int stopHere = 0;
//            }
        }


    }
}
