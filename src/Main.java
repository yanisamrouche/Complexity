import Fibonacci.Fibonacci;
import MachineTuring.GestionFichierMT;
import MachineTuring.MachineTuring;
import Zone_dense.Graphe;
import Zone_dense.Subvertices;
import Zone_dense.ZoneDense;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.ui.view.Viewer;
import java.io.IOException;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length ==3){
            String  mini_projet = args[0];
            String methode = args[1];
            String input = args[2];

            switch (mini_projet){
                case "Fibonacci":
                    Fibonacci fibonacci = new Fibonacci();
                    switch (methode){
                        case "recursive":
                            System.out.println("Le résultat de fibonacci recursive pour n= "+ input + " est " +fibonacci.recursive(new BigInteger(input)));
                            break;
                        case "iterative":
                            System.out.println("Le résultat de fibonacci iterative pour n= "+ input + " est " +fibonacci.iterative(new BigInteger(input)));
                            break;
                        case "exponentiation":
                            System.out.println("Le résultat de fibonacci exponetntiation pour n= "+ input + " est " +fibonacci.matrixExponentiation(new BigInteger(input)));
                            break;
                    }
                    break;
                case "ZoneDense":
                    Graphe graphe = new Graphe(input);
                    ZoneDense zoneDense = new ZoneDense(graphe);
                    switch (methode){
                        case "TestZoneDense":
                            System.out.println("Tu test les sommets suivants "+ graphe.getSubVertices() );
                            System.out.println(((zoneDense.testZoneDense(graphe, new Subvertices(graphe.getSubvertices())))? "le sous ensemble de sommets : " +graphe.getSubVertices() + " est une Zone Dense " :  "le sous ensemble de sommets : " +graphe.getSubVertices() + " n'est pas une Zone Dense "  ) );
                            break;
                        case "ZoneDenseMaximal":
                            Subvertices subvertices = zoneDense.maximalDensityArea(graphe);
                            System.out.println("le sous ensemble de sommet suivant contitue une Zone Dense Maximal : " + subvertices.printSubGraph());
                            graphe.paintGraphe();

                            for (int i = 0; i < subvertices.size() ; i++) {
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

                        case "ZoneDenseMaximum":
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
                    break;
            }
        }
        if (args.length == 2){
            String  mini_projet = args[0];
            String fichier= args[1];
            if(mini_projet.equals("MachineTuring")){
                GestionFichierMT gestionFichierMT = new GestionFichierMT();
                gestionFichierMT.lireListeObj(fichier);
                MachineTuring machineTuring  = new MachineTuring(gestionFichierMT.getStates(), gestionFichierMT.getTransitions(),gestionFichierMT.getBand(), gestionFichierMT.getBlankSymbol());
                machineTuring.runTheMachine();
            }

        }
        // java Main Fibonacci FibonrecuacciRecursive n;
        // java Main MachineTuring run  nomFichier;
        // java Main ZoneDense FibonrecuacciRecursive n;
        //
    }
}
