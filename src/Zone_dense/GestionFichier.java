package Zone_dense;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe GestionAppli permet de gérer les I/O de l'utilisateur, les paramètres et les arguments ainsi que le menu
 *
 */
public class GestionFichier {
    public static final int PRECISION = 0;

    public ArrayList<Integer> getSubvertices() {
        return subvertices;
    }

    public int getPoidsMax() {
        return sizeGraph;
    }

    /**
     * Permet de lire le fichier indiqué par le chemin, de lire les objets et de les instancier dans une liste
     *
     * @param chemin le sac à résoudre
     * @return ArrayList<Objet> objets
     *
     */
    private static int sizeGraph;
    private  ArrayList<Integer> subvertices ;

    public int getSizeGraph() {
        return sizeGraph;
    }

    public GestionFichier(){

    }

    public  ArrayList<ArrayList<Integer>> lireListeObj(String chemin) throws IOException {
        //try-with-resources pour s'assurer que le bf se ferme bien même en cas d'exceptions
        try (BufferedReader bf = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            int nbLignes = 0;
            int i =0;
            ArrayList<ArrayList<Integer>> listsEdge = new ArrayList<>();
            while ((ligne = bf.readLine()) != null) {
                if(nbLignes ==0){
                    sizeGraph = Integer.parseInt(ligne);
                }
                if(nbLignes ==1){
                    subvertices = new ArrayList<>();
                    String[] objProp = ligne.split(" ");

                    for (int j = 0; j <objProp.length ; j++) {
                        subvertices.add( Integer.parseInt(objProp[j]));
                    }

                }
                if(nbLignes>=2){

                    String[] objProp = ligne.split(" ");
                    ArrayList<Integer> listEdge = new ArrayList<>();
                    listEdge.add(Integer.parseInt(objProp[0]));listEdge.add(Integer.parseInt(objProp[1]));
                    listsEdge.add(listEdge);

                }
                nbLignes++;


            }
            return listsEdge;
        } catch (FileNotFoundException e) {
            throw new IOException("Ouverture du fichier impossible");
        }
    }
}