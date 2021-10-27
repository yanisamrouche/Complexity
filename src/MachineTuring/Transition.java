package MachineTuring;

public class Transition {
    private String symbolRead ;
    private String symbolWrite;
    private  State source;
    private int direction;  // positif(>0)----> à droite; négatif(>0) ---> à gauche

    private  State  nextState;

    public Transition(State source, String symbolRead, State nextState, String symbolWrite, int direction){
        this.source =source;
        this.nextState = nextState;
        this.symbolRead = symbolRead;
        this.symbolWrite = symbolWrite;
        this.direction = direction;

    }
    public void printTransition(){
        System.out.println("etat : "+ source.getName()  + " symbole lu  (" + symbolRead + ")"+ ",  état suivant  (" + nextState.getName()+ ")," + " on écrit (" + symbolWrite +")"+ ",  " + ((direction !=0)?(direction>0)? " --->" : " <---" : " don't Move")  );
        //System.out.println("if : " + symbolRead + " && " + source.getName() + " then write : "+ symbolWrite +" , next state : " + nextState.getName() + ((direction !=0)?(direction>0)? " Move to right" : " Move to left" : " don't Move"));
    }

    public String getSymbolRead() {
        return symbolRead;
    }

    public String getSymbolWrite() {
        return symbolWrite;
    }

    public State getSource() {
        return source;
    }

    public int getDirection() {
        return direction;
    }

    public State getNextState() {
        return nextState;
    }
}
