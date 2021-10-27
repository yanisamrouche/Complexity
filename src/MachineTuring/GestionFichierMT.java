package MachineTuring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestionFichierMT {
    private ArrayList<State> states ;
    private ArrayList<String> band ;
    private ArrayList<Transition> transitions ;
    private String blankSymbol;

    public void lireListeObj(String chemin) throws IOException {
        try (BufferedReader bf = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            int nbLignes = 0;
            int i =0;
            ArrayList<ArrayList<Integer>> listsEdge = new ArrayList<>();
            transitions = new ArrayList<>();
            while ((ligne = bf.readLine()) != null) {
                if(nbLignes ==0){
                    states = new ArrayList<>();
                    String[] objProp = ligne.split(" ");
                    for (int j = 0; j <objProp.length -2 ; j++) {
                        states.add(new State(objProp[j]));
                    }
                    String inital = objProp[objProp.length -2];
                    State stateInial =  new State(inital);
                    for (State state: states) {
                        if (state.getName().equals(stateInial.getName())){
                            state.setStartingState(true);
                        }
                    }
                    String finale = objProp[objProp.length -1];
                    State finaleState =  new State(finale);
                    for (State state: states) {
                        if (state.getName().equals(finaleState.getName())){
                            state.setAcceptingState(true);
                        }
                    }

                }
                if(nbLignes ==1){
                    char[] tab  = ligne.toCharArray();
                    band = new ArrayList<>();
                    if (tab.length ==0){
                        band.add("B");
                    }
                    for (int j = 0; j <tab.length ; j++) {
                        String charat = String.valueOf(tab[j]);
                        band.add(charat);

                    }


                }
                if(nbLignes ==2){
                    String[] objaProp = (ligne.split(" "));
                    blankSymbol = objaProp[0];

                }
                if(nbLignes>2){


                    String[] objProp = ligne.split(" ");
                    transitions.add(new Transition(new State(objProp[0]),objProp[1],new State(objProp[2]),objProp[3],Integer.parseInt(objProp[4])));

                }
                nbLignes++;



            }
        } catch (FileNotFoundException e) {
            throw new IOException("Ouverture du fichier impossible");
        }
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public ArrayList<String> getBand() {
        return band;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public String getBlankSymbol() {
        return blankSymbol;
    }
}
