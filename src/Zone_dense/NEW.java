package Zone_dense;

import java.util.ArrayList;

public class NEW {
    public static void main(String[] args) {
        Graphe graphe = new Graphe(7);
        graphe.setEdge(0,1,true);
        graphe.setEdge(0,2,true);
        graphe.setEdge(0,3,true);
        graphe.setEdge(0,4,true);
        graphe.setEdge(0,5,true);
        graphe.setEdge(1,3,true);
        graphe.setEdge(1,2,true);
        graphe.setEdge(2,3,true);
        graphe.setEdge(2,4,true);
        graphe.setEdge(2,5,true);
        graphe.setEdge(3,4,true);
        graphe.setEdge(3,5,true);
        graphe.setEdge(4,5,true);
        ArrayList<Integer>  subVertices = new ArrayList<>();
        Subvertices Sub = new Subvertices(subVertices);
        subVertices.add(0);subVertices.add(1);subVertices.add(4);
        ZoneDense zoneDense = new ZoneDense(graphe);
        System.out.println("-------Methode complete------------");
        System.out.println(zoneDense.maximalDensityAreaComplete(graphe).getVertices());
        System.out.println();
        System.out.println(" liste des sommets "+ graphe.getMatrix().get(0));
        graphe.printGraph();
    }
}
