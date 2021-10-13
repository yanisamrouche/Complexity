package Zone_dense;

import org.graphstream.stream.ProxyPipe;
import org.graphstream.ui.view.Viewer;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws InterruptedException, IOException {
        Graphe graphe = new Graphe("/amuhome/a19028598/Bureau/ComplexityTP01/src/Exemple/matrix0");
        ZoneDense zoneDense =new ZoneDense(graphe);
        Subvertices subvertices = zoneDense.maximalDensityArea(graphe);
        System.out.println("subevertices " +subvertices.getVertices());
        graphe.paintGraphe();

        for (int i = 0; i <subvertices.size() ; i++) {
            graphe.getGraph().getNode(""+subvertices.getVertices().get(i)).setAttribute("ui.style", "fill-color: rgb(242, 37, 0); size: 25px; stroke-mode: plain; stroke-color: rgb(242, 37, 0); stroke-width:25px;shadow-mode: plain; shadow-width: 15px; shadow-color: #999; shadow-offset: 3px, -3px;text-size:20px;");
            for (int j = i+1; j < subvertices.size(); j++) {
                graphe.getGraph().getEdge(""+subvertices.getVertices().get(i)+""+subvertices.getVertices().get(j)).setAttribute("ui.style", "fill-color: rgb(242, 37, 0); size: 2px; stroke-mode: plain; stroke-color: rgb(242, 37, 0);shape: cubic-curve;");
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
    }
    }

