import java.util.ArrayList;

public class Main {
    private static AntManager man;

    public static void addAntFromBrood(Brood b) {
        man.addAntFromBrood(b);
    }

    public static void removeAnt(Ant a) {
        man.removeAnt(a);
    }

    public static void main(String[] args) {
        //TODO Create World
        //TODO Intialize Ants
        //TODO Ask how many ants to start with
        //TODO Ask How long Simulation

        man = new AntManager();


        boolean simFlag = true;


//        queens.add(new Queen("the queen"));
//        while (simFlag) {
//
//            for (Queen q: queens
//                 ) {
//                brood.add(q.layBrood());
//            }
//
//        }


    }
}
