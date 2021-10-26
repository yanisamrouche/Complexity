package MachineTuring;

import java.util.ArrayList;

public class State {

    private String name;

    private boolean acceptingState = false;
    private boolean startingState  = false;

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingState(boolean startingState) {
        this.startingState = startingState;
    }

    private final ArrayList<Transition> transitions = new ArrayList<>();

    public State(){

    }
    public State( String name){
        this.name = name;
    }

    public boolean isAcceptingState(){
        return  acceptingState;
    }
    public void setAcceptingState(boolean acceptingState){
        this.acceptingState = acceptingState;
    }

    public boolean isStartingState() {
        return startingState;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public void printTransition(){
        for(Transition transition : transitions){
            transition.printTransition();
            System.out.println();
        }
    }
}
