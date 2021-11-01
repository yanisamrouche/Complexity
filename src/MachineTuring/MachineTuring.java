package MachineTuring;

import java.util.ArrayList;

public class MachineTuring {
    /**
     * une liste de type State qui contient nos états.
     */
    private ArrayList<State> states = new ArrayList<>();
    /**
     *  String qui va contenir notre symbole blanc.
     */
    private String blankSymbol;
    /**
     * une liste de type Transition qui contient les transitions récupérer dans le fichier.
     */
    private ArrayList<Transition> transitions;
    /**
     * une liste de type String  elle va contenir le mot d’entrée l'exécution.
     */

    private ArrayList<String> band = new ArrayList<String>();

    /***
     * un entier qui représente la tête du ruban.
     */
    private int headBand;



    /***
     * de type State une variable qui nous donne l’état courant.
     */
    private State currentState;

    //private int numberOfStates;

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }



    public MachineTuring(ArrayList<State> states, ArrayList<Transition> transitions, ArrayList<String> band, String blankSymbol) {
        this.states = states;
        this.transitions = transitions;
        this.band = band;
        this.blankSymbol = blankSymbol;
    }


    public void addTransition(State source, State nextState, String symbolRead, String symbolWrite, int direction) {
        Transition transition = new Transition(source, symbolRead, nextState, symbolWrite, direction);
        transitions.add(transition);
    }


    public void runTheMachine() {
        startingState();
        correctionDeNotreAlgo();
        Transition transition= null;
        while (!currentState.isAcceptingState()) {
            String readSymbol = band.get(headBand);
            transition = readTransition(currentState, readSymbol);
            if (transition != null){
                if (transition.getNextState().isAcceptingState()) {
                    band.set(headBand, transition.getSymbolWrite());
                    transition.printTransition();
                    System.out.println(band + "tête de lecture à l'index : " + headBand);
                    //headBand += transition.getDirection();
                    System.out.println("l'entré est  accepté");
                    break;

                }
            }
            else {
                System.out.println("l'entré n'est pas eccepte");
                break;

            }

            band.set(headBand, transition.getSymbolWrite());
            transition.printTransition();
            System.out.println(band + "tête de lecture à l'index : " + headBand);
            headBand += transition.getDirection();

            addBlankToBand();
            currentState = transition.getNextState();
        }


    }



    public Transition readTransition(State currentState, String readSymbol){
        for (Transition transition: transitions) {
            if(readSymbol.equals(transition.getSymbolRead()) && transition.getSource().getName().equals(currentState.getName()))
                return transition;
        }
        return null;
    }

    public void addBlankToBand(){
        if(headBand <0) {
            band.add(0, blankSymbol);
        }
        if(headBand >= band.size()){
            band.add(blankSymbol);
        }
    }


    public void startingState(){
        for (State state: states ) {
            if(state.isStartingState()){
                currentState = state;
                headBand =0;
                return;
            }
        }
    }
    public void printTransition (){
        for (Transition transition: transitions) {
            if(transition.getNextState().isAcceptingState())
                System.out.println(transition.getNextState().getName());
        }
    }
    public void correctionDeNotreAlgo(){
        for (Transition transition :transitions){
            for (State state :states){
                if(transition.getNextState().getName().equals(state.getName())){
                    if (state.isAcceptingState())
                        transition.getNextState().setAcceptingState(true);
                }
            }
        }
    }
}

