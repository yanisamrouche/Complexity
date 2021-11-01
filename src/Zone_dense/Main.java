package Zone_dense;

import org.graphstream.stream.ProxyPipe;
import org.graphstream.ui.view.Viewer;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws InterruptedException, IOException {
        Graphe graphe = new Graphe("/Users/ousmanecisse/Desktop/COURS_MASTER1/COMPLEXITÉ/TP1_Etude_des_complexites/src/Exemple/matrix0");
        //System.out.println(graphe.getSubVertices());
        ZoneDense zoneDense =new ZoneDense(graphe);
        //System.out.println(graphe.getSubVertices().getVertices());
        //System.out.println(((zoneDense.testZoneDense(graphe, new Subvertices(graphe.getSubvertices())))? "le sous ensemble de sommets : " +graphe.getSubVertices() + " est une Zone Dense " :  "le sous ensemble de sommets : " +graphe.getSubVertices() + " n'est pas une Zone Dense "  ) );

        Subvertices subverticesMaximum = zoneDense.maximumDensityAreaComplete(graphe);
        System.out.println("le sous ensemble de sommet suivant contitue une Zone Dense maximum : " + subverticesMaximum.printSubGraph());
        graphe.paintGraphe();

        for (int i = 0; i <subverticesMaximum.size() ; i++) {
            graphe.getGraph().getNode(""+subverticesMaximum.getVertices().get(i)).setAttribute("ui.style", "fill-color: rgb(242, 37, 0); size: 25px; stroke-mode: plain; stroke-color: rgb(242, 37, 0); stroke-width:25px;shadow-mode: plain; shadow-width: 15px; shadow-color: #999; shadow-offset: 3px, -3px;text-size:20px;");
            for (int j = i+1; j < subverticesMaximum.size(); j++) {
                graphe.getGraph().getEdge(""+subverticesMaximum.getVertices().get(i)+""+subverticesMaximum.getVertices().get(j)).setAttribute("ui.style", "fill-color: rgb(242, 37, 0); size: 2px; stroke-mode: plain; stroke-color: rgb(242, 37, 0);");
            }
        }
        System.setProperty("org.graphstream.ui", "swing");
        Viewer viewer1 = graphe.getGraph().display();

        ProxyPipe pipe1 = viewer1.newViewerPipe();
        pipe1.addAttributeSink(graphe.getGraph());
        while (true) {
            Thread.sleep(100);

            pipe1.pump();

        }




    }



    }

