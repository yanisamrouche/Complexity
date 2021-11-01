package MachineTuring;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length > 0){
            String  nomFichier = args[0];
            GestionFichierMT gestionFichierMT = new GestionFichierMT();
            gestionFichierMT.lireListeObj(nomFichier);
            MachineTuring machineTuring  = new MachineTuring(gestionFichierMT.getStates(), gestionFichierMT.getTransitions(),gestionFichierMT.getBand(), gestionFichierMT.getBlankSymbol());
            //machineTuring.printTransition();
            machineTuring.runTheMachine();
        }
        else {
            System.out.println("il faut mettre un argument : le nom du fichier ");
        }
    }


}
