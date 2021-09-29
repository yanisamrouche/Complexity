package Zone_dense;

public class Main {
    public static void main(String[] args) {
        GraphMat graphMat = new GraphMat(5);
        graphMat.edge(0,1);
        graphMat.edge(0,4);
        graphMat.edge(4,2);
        graphMat.edge(4,3);
        graphMat.edge(4,1);
        graphMat.edge(1,3);
        graphMat.edge(2,3);
        graphMat.edge(1,2);

        int[] t = new int[3];
        t[0] =3;
        t[1] =1;
        t[2] =2;
        //System.out.println(graphMat.getMatrix()[3][1]);
        //System.out.println(graphMat.testZoneDense(t));
        System.out.println(graphMat.zoneDenseMax()[0]);
        System.out.println(graphMat.zoneDenseMax()[1]);
        System.out.println(graphMat.zoneDenseMax()[2]);



    }
}
