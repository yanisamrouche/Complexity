package MachineTuring;

import java.util.ArrayList;

public class MachineTuring {

    private ArrayList<State> states = new ArrayList<>();


    private String blankSymbol;

    private ArrayList<Transition> transitions;

    private ArrayList<String> band = new ArrayList<String>();

    private  int headBand;

    //private int numberOfStates;

    private State currentState ;

    public MachineTuring(ArrayList<State> states, ArrayList<Transition> transitions,  ArrayList<String> band, String blankSymbol ){
        this.states =states;
        this.transitions =transitions;
        this.band =band;
        this.blankSymbol = blankSymbol;
    }


    public  void addTransition(State source, State nextState, String symbolRead, String symbolWrite, int direction){
        Transition transition = new Transition(source, symbolRead, nextState, symbolWrite, direction);
        transitions.add(transition);
    }


    public void runTheMachine(){
        startingState();
        while (!currentState.isAcceptingState()){
            String readSymbol = band.get(headBand);
            System.out.println(readSymbol);
            Transition transition = readTransition(readSymbol);
            if (transition != null){
                if(transition.getNextState().isAcceptingState()){
                    System.out.println("\n" + " l'entrée est accepté ");
                    break;
                }
                band.set(headBand, transition.getSymbolWrite());
                headBand += transition.getDirection();
                System.out.println(band + "tête de lecture à l'index : "+ headBand );
                addBlankToBand();
            }

            else {
                currentState.setAcceptingState(true);
                System.out.println("Le mot n'est pas accepté");
            }
            currentState = transition.getNextState();

            }
        }


    public Transition readTransition(String readSymbol){
        for (Transition transition: transitions) {
            System.out.println(transitions.size());
            if(readSymbol.equals(transition.getSymbolRead()))
                return transition;
        }
        return null;
    }

    public void addBlankToBand(){
        if(headBand <0) band.add(0, blankSymbol);
        if(headBand > band.size()) band.add(blankSymbol);
    }


    public void startingState(){
        for (State state: states ) {
            if(state.isStartingState()){
                currentState = state;

                headBand =0;
            }
        }
    }
}

