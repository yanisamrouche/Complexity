package MachineTuring;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GestionFichierMT gestionFichierMT = new GestionFichierMT();
        gestionFichierMT.lireListeObj("src/MachineTuring/Exo1TD3");
        MachineTuring machineTuring  = new MachineTuring(gestionFichierMT.getStates(), gestionFichierMT.getTransitions(),gestionFichierMT.getBand(), gestionFichierMT.getBlankSymbol());
        //machineTuring.printTransition();
        machineTuring.runTheMachine();

    }


}
