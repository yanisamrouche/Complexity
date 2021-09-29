package Zone_dense;

import java.util.ArrayList;

public class TestVerification {



    /*
    Question 1 : Test de vérification
    **/

    public boolean isDenseArea(Graph G, ArrayList<Integer> list){
        for (int i = 0; i <list.size() ; i++) {
            ArrayList<Integer> adjency = G.voisins(list.get(i));
            if(G.order() -1 != adjency.size() );
            return false;
        }
        return true;
    }
}
