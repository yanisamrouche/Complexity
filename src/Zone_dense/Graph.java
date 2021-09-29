package Zone_dense;
import java.util.*;

public class Graph<Label> {
    private ArrayList<Integer> listsommetsAccessible =new ArrayList<>();

    class Edge {
        public int source;
        public int destination;
        public Label label;

        public Edge(int from, int to, Label label) {
            this.source = from;
            this.destination = to;
            this.label = label;
        }
    }

    private int cardinal;

    public ArrayList<LinkedList<Edge>> getIncidency() {
        return incidency;
    }

    private ArrayList<LinkedList<Edge>> incidency;


    public Graph(int size) {
        cardinal = size;
        incidency = new ArrayList<LinkedList<Edge>>(size+1);
        for (int i = 0;i<cardinal;i++) {
            incidency.add(i, new LinkedList<Edge>());
        }
    }

    public int order() {
        return cardinal;
    }

    public void addArc(int source, int dest, Label label) {
        incidency.get(Math.abs(source)).addLast(new Edge(source,dest,label));
    }
    public Graph<Label> graphTranspose() {
        Graph<Label> newGraph = new Graph<>(cardinal);
        for (LinkedList<Edge> out_v : incidency) {
            for (Edge e : out_v) {
                newGraph.addArc(e.destination,e.source,e.label);
            }
        }
        return newGraph;
    }

    public int getCardinal() {
        return cardinal;
    }
    public String toString() {
        String result = new String("");
        result.concat(cardinal + "\n");
        for (int i = 0; i<cardinal;i++) {
            for (Edge e : incidency.get(i)) {
                result = result.concat(e.source + " ---> " + e.destination + " "
                        + e.label.toString() + "\n");
            }
        }
        return result;

    }
    public boolean inAnSource(int s){
        for (int i = 0; i<cardinal;i++) {
            for (Edge e : incidency.get(i)) {
                if(e.source == s){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * vérifie que le sommet {@code v} est un sommet valide du graphe
     *
     * @param v sommet du graphe à vérifier
     * @throws IllegalArgumentException si le sommet n'est pas valide
     */
    public void verifieSommet(int v) {
        if (v >= order())
            throw new IllegalArgumentException(String.format("Le sommet %d n'est pas valide", v));
    }

    /**
     * Renvoie la liste des voisins du sommet {@code v}.<BR>
     * Cette liste ne peut pas etre modifiée
     *
     * @param v sommet du graphe
     * @return la liste des voisins du sommet {@code v}
     * @throws IllegalArgumentException si le sommet n'est pas valide
     */

    public ArrayList<Integer> voisins(int v) {
        verifieSommet(v);
        ArrayList<Integer> arrayList =new ArrayList<>();
        List<Edge> listEdge = (incidency.get((Math.abs(v))));
        for (int i =0; i <listEdge.size() ; i++) {
            if (listEdge.get(i).source==v){
                    arrayList.add(listEdge.get(i).destination);
                }
            if (listEdge.get(i).destination==v){
                arrayList.add(listEdge.get(i).source);
            }
        }
        return arrayList;
    }

    /**
     * Renvoie vrai si et seulement si {@code u} et {@code v} sont voisins
     *
     * @param u un sommet du graphe
     * @param v un sommet du graphe
     * @return true si {@code u} et {@code v} sont voisins, false sinon
     */

    public boolean sontVoisins(int u, int v) {
        return (incidency.get(u).contains(v) || incidency.get(v).contains(u));
    }
    /**
     * cette methode l'ensemble des somets accessibles depuis un sommets
     */
    /*
    public ArrayList<Integer> accessibly(int s){
        List<Integer> listadj = voisins(s);
        if(!(listadj.isEmpty())) {
            for (Integer integer : listadj) {
                if (!(listsommetsAccessible.contains(integer))) {
                    listsommetsAccessible.add(integer);
                    accessibly(integer);
                }
            }
        }
        if(!(listsommetsAccessible.contains(s))){
            listsommetsAccessible.add(s);
        }
        return listsommetsAccessible;
    }

     */
}
