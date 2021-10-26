package Zone_dense;
import GestionAlgo.GestionFichier;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import java.io.IOException;
import java.util.ArrayList;

public class Graphe {

    private Graph graph;

    private int nbVertices;
    private ArrayList<ArrayList<Boolean>> matrix;

    public Graphe(int nbVertices){
        this.nbVertices = nbVertices;
        matrix = new ArrayList<>();
        for (int i = 0; i <nbVertices ; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j <nbVertices ; j++) {
                matrix.get(i).add(false);
            }
        }
    }

    public Graphe(String filename) throws IOException {
        ArrayList<ArrayList<Integer>> arrayLists = new GestionFichier().lireListeObj(filename);
        this.nbVertices = new GestionFichier().getSizeGraph();
        this.setMatrix(new Graphe(nbVertices).getMatrix());
        for (int i = 0; i <arrayLists.size() ; i++) {
            for (int j = 0; j <2 ; j++) {
                setEdge(arrayLists.get(i).get(0), arrayLists.get(i).get(1),true);
            }
        }
        printGraph();

    }
    public void printGraph() {
        for (int i = 0; i < nbVertices; i++) {
            System.out.println();
            for (int j = 0; j < nbVertices; j++)
                System.out.print((matrix.get(i).get(j) ? "1" : "0") + "  ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public Graph getGraph() {
        return graph;
    }

    public void paintGraphe() throws InterruptedException {
        graph = new MultiGraph("Tutorial 1");
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");

        for (int i = 0; i <getNbVertices() ; i++) {
            graph.addNode(""+i).setAttribute("xy", i, i+1);
        }
        for (int i = 0; i < nbVertices; i++) {
            for (int j = i+1; j < nbVertices; j++) {
                if(isEdge(i,j)){
                    graph.addEdge(""+i+""+j, ""+i, ""+j);
                }
            }
        }
        graph.setAttribute("ui.size", 100);
        graph.setAttribute("ui.style", "padding: 40px");

        graph.nodes().forEach(n -> n.setAttribute("label", n.getId().toLowerCase()));

            for (Node node :graph){
                node.setAttribute("ui.style", " fill-color: #DEE; size: 25px; stroke-mode: plain; stroke-color: #555;stroke-width:25px;shadow-mode: plain; shadow-width: 15px; shadow-color: #999; shadow-offset: 3px, -3px;text-size:20px;");
            }
        for (int k = 0; k < graph.getEdgeCount(); k++) {

            graph.getEdge(k).setAttribute("ui.size", 50);
            graph.getEdge(k).setAttribute("ui.style", "stroke-mode: plain;");
            graph.getEdge(k).setAttribute("ui.style", "fill-color: rgb(22, 113, 113);size: 2px;stroke-mode: plain;");

        }
        //graph.setAttribute("ui.stylesheet", "graph { fill-mode: image-scaled-ratio-max; fill-image: url('/Users/ousmanecisse/Pictures/fanart1.jpg');}");
        /*

            for (int k = 0; k < graph.getEdgeCount(); k++) {

                graph.getEdge(k).setAttribute("ui.size", 50);
                graph.getEdge(k).setAttribute("ui.style", "stroke-mode: plain;");
                graph.getEdge(k).setAttribute("ui.style", "fill-color: rgb(22, 113, 113);");

            }
             */
        }



    public Boolean isEdge(int firstVertice, int secondVertice) {
        return matrix.get(firstVertice).get(secondVertice);
    }

    public void setNbVertices(int nbVertices) {
        this.nbVertices = nbVertices;
    }

    public void setMatrix(ArrayList<ArrayList<Boolean>> matrix) {
        this.matrix = matrix;
    }

    public ArrayList<ArrayList<Boolean>> getMatrix() {
        return matrix;
    }

    public int getNbVertices() {
        return nbVertices;
    }

    public void setEdge(int firstVertice , int secondVertice, boolean edge){

        if(firstVertice != secondVertice){
            matrix.get(firstVertice).set(secondVertice,edge);
            matrix.get(secondVertice).set(firstVertice,edge);
        }
    }

    public Subvertices getSubVertices(){
        ArrayList<Integer> subVertices = new ArrayList<>();
        System.out.println();
        return  new Subvertices();
    }
}
