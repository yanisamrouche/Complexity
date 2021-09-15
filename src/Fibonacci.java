import java.math.BigInteger;

public class Fibonacci {
    static int[][] P = new int[2][2];

    public static long timeComplexity(int n, String functionName){
        System.out.println("pour n = "+n);
        long time =0;
        switch (functionName){
            case "fibonacciIterative":
                long start = System.nanoTime();
                fibonacciIterative(n);
                long end = System.nanoTime();
                time = end - start;

                break;
            case "fibonacciRecursive":
                long s = System.nanoTime();
                fibonacciRecursive(n);
                long e = System.nanoTime();
                time = e - s;
                break;
        }
        return time;
    }

    public static int fibonacciRecursive(int n){
        if(n <= 1){
            return n;
        }



        return fibonacciRecursive(n -1 ) + fibonacciRecursive(n-2);
    }

    public static int fibonacciIterative(int n){
        int[] fib = new int[n+1];
        if(n <= 1){
            return n;
        }
        fib[0] = 0;
        fib[1] = 1;

        for(int i=2; i<n+1; i++){
            fib[i] =  fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

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

    public static int[][] powMat(int[][] mat, int p){
        int[][] r = new int[mat.length][mat.length];
        for(int i=0; i<mat.length;i++){
            for(int j=0; j<mat.length;j++){
                r[i][j] = mat[i][j];
            }
        }
        for(int i=1; i<p; i++){
            r = multMat(mat,r);
        }
        //printMat(r);
        return r;
    }
    public static void main(String[] args){
        //Fibonacci fibonacci = new Fibonacci();
        System.out.println("Fibonnaci version recursive : "+fibonacciRecursive(4));
        System.out.println("temps : "+timeComplexity(15,"fibonacciRecursive") +" nanosecondes");
        System.out.println("--------------------------------------------------------");
        System.out.println("Fibonnaci version iterative : "+fibonacciIterative(15));
        System.out.println("temps : "+timeComplexity(15,"fibonacciIterative") + " nanosecondes");
        System.out.println("--------------------------------------------------------");
        printMat(fillmat());
        System.out.println();
        int[][] m = {{1,2},
                     {2,2}};
        printMat(multMat(m,m));
        System.out.println();
        printMat(powMat(m,2));

    }







}
