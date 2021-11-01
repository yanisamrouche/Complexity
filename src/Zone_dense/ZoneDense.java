package Zone_dense;

import java.util.LinkedList;
import java.util.Queue;

public class ZoneDense {


    private Graphe graphe;
    private  Subvertices subvertices ;


    public ZoneDense(Graphe graphe, Subvertices subvertices){
        this.graphe = graphe;
        this.subvertices =subvertices;
    }

    public ZoneDense(Graphe graphe) {
        this.graphe = graphe;
    }

    /**
     * Question 1 Verification Zone dense
     * @author CISSE Ousmane
     * Complexité : l'algortihme est en O(n^2), puisque la taille de l'entrée est O((n^2) +n) alors
     * la complexité en taille de l'entreé est O(n^2). Ce qui nous donne une complexité de temps linéaire.
     */
    public boolean testZoneDense(Graphe graphe, Subvertices  subvertices){
        if (subvertices.size()<2) return false;
        for (int i = 0; i <subvertices.size() ; i++) {
            for (int j = i+1; j <subvertices.size() ; j++) {
                if(!(graphe.isEdge(subvertices.getVertices().get(i), subvertices.getVertices().get(j))))
                    return false;
            }
        }
        return true;
    }
    /**
     * Question 2 trouver une Zone dense maxiamale
     * @author CISSE Ousmane
     *
     * Complexité : La complexité est O(n^3) car on une boucle en n*(n^2)(qui la complexite de la méthode isDenseArea)
     */

    public Subvertices  maximalDensityArea(Graphe graphe){
        Subvertices maximalSubVertices = new Subvertices();
        maximalSubVertices.add(0);

        for (int i = 1; i < graphe.getMatrix().size() ; i++) {
            maximalSubVertices.add(i);
            if(!(testZoneDense(graphe, maximalSubVertices)))
                maximalSubVertices.removeAt(maximalSubVertices.size() - 1);
        }
        return maximalSubVertices;

    }

    /**
     * Question 3 Trouver une zone dense maximum (Méthode "complète"))
     *
     */

    public Subvertices maximumDensityAreaComplete(Graphe graphe){
        Subvertices currentCombination  = new Subvertices() ;
        Queue<Subvertices> combinationsQueue = new LinkedList<>();
        Subvertices firstSubgraph = new Subvertices();

        for (int i = 0; i < graphe.getNbVertices() ; i++) {
            firstSubgraph.add(i);
        }
        combinationsQueue.add(firstSubgraph);
        if (!combinationsQueue.isEmpty())
            currentCombination = combinationsQueue.poll();
        if (testZoneDense(graphe,currentCombination))return currentCombination;
        addNextCombinationsToExplore(combinationsQueue, currentCombination);
        if(!combinationsQueue.isEmpty())
            currentCombination = combinationsQueue.poll();

        while (!combinationsQueue.isEmpty() && currentCombination.size()>1){
            if(testZoneDense(graphe, currentCombination))
                return currentCombination;

            addNextCombinationsToExplore(combinationsQueue, currentCombination);
            currentCombination = combinationsQueue.poll();
        }

        return currentCombination;
    }


    /**
     * cette methode nous permet de calculer une nouvelle combinaision
     *
     */

    public void addNextCombinationsToExplore(Queue<Subvertices> combinationsQueue, Subvertices currentCombination ){

        for (int i = currentCombination.size()-1;i>=0 ; i--) {
            Subvertices newCombination = currentCombination.clone();
            newCombination.removeAt(i);
            if(! (combinationsQueue.contains(newCombination)))
                combinationsQueue.add(newCombination);
        }
    }


}
