package Zone_dense;

import org.graphstream.stream.ProxyPipe;
import org.graphstream.ui.view.Viewer;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws InterruptedException, IOException {
        Graphe graphe = new Graphe("/Users/ousmanecisse/Desktop/COURS_MASTER1/COMPLEXITÉ/TP1_Etude_des_complexites/src/Exemple/matrix0");
        ZoneDense zoneDense =new ZoneDense(graphe);
        Subvertices subvertices = zoneDense.maximalDensityArea(graphe);
        System.out.println("subevertices " +subvertices.getVertices());
        graphe.paintGraphe();

        for (int i = 0; i <subvertices.size() ; i++) {
            graphe.getGraph().getNode(""+subvertices.getVertices().get(i)).setAttribute("ui.style", "fill-color: rgb(242, 37, 0); size: 25px; stroke-mode: plain; stroke-color: rgb(242, 37, 0); stroke-width:25px;shadow-mode: plain; shadow-width: 15px; shadow-color: #999; shadow-offset: 3px, -3px;text-size:20px;");
            for (int j = i+1; j < subvertices.size(); j++) {
                graphe.getGraph().getEdge(""+subvertices.getVertices().get(i)+""+subvertices.getVertices().get(j)).setAttribute("ui.style", "fill-color: rgb(242, 37, 0); size: 2px; stroke-mode: plain; stroke-color: rgb(242, 37, 0);");
            }
        }
        System.setProperty("org.graphstream.ui", "swing");
        Viewer viewer = graphe.getGraph().display();

        ProxyPipe pipe = viewer.newViewerPipe();
        pipe.addAttributeSink(graphe.getGraph());
        while (true) {
            Thread.sleep(100);

            pipe.pump();

        }


        /*

        Graph graph = new MultiGraph("Tutorial 1");

        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        for (int i = 0; i <graphe.getNbVertices() ; i++) {
            graph.addNode(""+i);
        }
        for (int i = 0; i <graphe.getNbVertices(); i++) {
            for (int j = i+1; j <graphe.getNbVertices(); j++) {
                if(graphe.isEdge(i,j)){
                    graph.addEdge(""+i+""+j, ""+i, ""+j);
                }
            }
        }
        graph.setAttribute("ui.size", 100);

        for (Node node :graph){
            node.setAttribute("ui.style", "fill-mode: plain;");
            node.setAttribute("ui.label", node.getId());
            node.setAttribute("ui.size", 300);
            node.setAttribute("ui.style", "fill-color: rgb(22, 113, 113);");
        }
        for (int k = 0; k < graph.getEdgeCount(); k++) {

            graph.getEdge(k).setAttribute("ui.size", 50);
            graph.getEdge(k).setAttribute("ui.style", "stroke-mode: plain;");
            graph.getEdge(k).setAttribute("ui.style", "fill-color: rgb(22, 113, 113);");

        }




        System.setProperty("org.graphstream.ui", "swing");
        Viewer viewer = graph.display();
// Create a pipe coming from the viewer ...
        ProxyPipe pipe = viewer.newViewerPipe();
// ... and connect it to the graph
        pipe.addAttributeSink(graph);
        while (true) {
            // a small delay, avoids full CPU load
            Thread.sleep(100);
            // consume the events stored in the buffer, if any
            pipe.pump();

            // in the development version the previous two instructions can be replaced by
            // pipe.blockingPump();

            // now "xyz" attributes of the nodes are updated and we can use them, for example
            //double[] xyz = Toolkit.nodePosition(graph, "A");

        }



         */
    }



    }

