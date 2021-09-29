package Zone_dense;

public class GraphMat {

    private int size;
    private int[][] matrix;

    /**
     * constructeur de la classe GrapheMat
     * @param size
     */
    public GraphMat(int size){
        this.size =size;
        this.matrix = new int[size][size];
    }

    public void edge(int source, int dest){
        matrix[source][dest] = 1;
        matrix[dest][source] = 1;
    }


    public int getSize() {
        return size;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * QUESTION 1
     * test de zone dense dans un graphe
     * @param tableau
     * @return
     * Complexité : l'algortihme est en O(n^2), puisque la taille de l'entrée est O((n^2) +n) alors
     * la complexité en taille de l'entreé est O(n^2). Ce qui nous donne une complexité de temps linéaire.
     */
    public boolean testZoneDense(int[] tableau){
        if(tableau.length ==1){
            return true;
        }
        for (int i = 0; i <this.size ; i++) {
            for (int j = i+1; j <this.size ; j++) {
                if (isIn(i, tableau) && isIn(j, tableau) ){
                    if (matrix[i][j] ==0)
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isIn(int i , int[] tab){
        for (int j = 0; j <tab.length ; j++) {
            if(tab[j] == i)
                return true;
        }
        return false;
    }

    public int[] zoneDenseMax(){
        int[] tableau = new int[size];
        for (int i = 0; i <size ; i++) {
            if(!isIn(i, tableau)){
                tableau[i] =i;
            }
            if(!testZoneDense(tableau))
                tableau[i] =0;
        }
        return tableau;
    }

    }



