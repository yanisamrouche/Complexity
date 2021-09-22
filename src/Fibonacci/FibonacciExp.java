package Fibonacci;

public class FibonacciExp {
    static int[][] P = new int[2][2];
    /* version 03 */
    public static int[][] fillmat(){
        P[0][0] = 0;
        P[0][1] = 1;
        P[1][0] = 1;
        P[1][1] = 1;
        //printMat(P);
        return P;
    }

    public static void printMat(int[][] m){
        for (int i=0; i<m.length;i++){
            System.out.print("|");
            for (int j=0; j<m.length;j++){
                System.out.print( " " +m[i][j] +" ");
            }
            System.out.println("|");

        }
    }
    public static void printMatV(int[][] m){
        for (int i=0; i<2;i++){
            System.out.print("|");
            for (int j=0; j<1;j++){
                System.out.print( " " +m[i][j] +" ");
            }
            System.out.println("|");

        }
    }

    public static int[][] multMat(int[][] A, int[][] B){
        for(int i=0; i<2;i++){
            for (int j=0; j<2;j++){
                P[i][j] = 0;
                for(int k=0;k<2;k++){
                    P[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        //printMat(P);
        return P;
    }

    public static int [][] multiplication(int [][] A ,int [][] B){
        int[][] r = new int[A[0].length][B[1].length];
        for(int i=0; i<A.length;i++){
            for (int j=0; j<B[0].length;j++){
                r[i][j] = 0;
                for(int k=0;k<B.length;k++){
                    r[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return r;
    }


    public static int[][] powMat(int[][] mat, int p){
        int[][] r = new int[mat.length][mat.length];
        for(int i=0; i<mat.length;i++){
            for(int j=0; j<mat.length;j++){
                r[i][j] = mat[i][j];
            }
        }
        if(p > 1){
            if(p%2==0 ){
                r= multMat(r,r);

                r= powMat(r,(p/2));
            }else{
                r= multMat(r,powMat(r,(p-1)));

            }
        }

        //printMat(r);
        return r;
    }

    public static int fiboExp(int p){
        int[][] res = new int[2][1];
        int[][] fib = new int[2][1];
        fib[0][0] = 0;
        fib[1][0] = 1;
        int[][] InitMat = {{0,1}, {1,1}};
        res = multiplication(powMat(InitMat,p),fib);
        return res[0][0];


    }

}
