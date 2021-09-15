import java.math.BigInteger;

public class Fibonacci {
    static int[][] P = new int[2][2];
    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Fibonnaci version recursive : "+fibonacciRecursive(4));
        System.out.println("temps : "+timeComplexity(15,"fibonacciRecursive") +" nanosecondes");
        System.out.println("--------------------------------------------------------");
        System.out.println("Fibonnaci version iterative : "+fibonacciIterative(15));
        System.out.println("temps : "+timeComplexity(15,"fibonacciIterative") + " nanosecondes");
        System.out.println("--------------------------------------------------------");
        fillmat();

    }

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
        for (int i=0; i<2;i++){
            System.out.print("|");
            for (int j=0; j<2;j++){
                System.out.print( " " +P[i][j] +" ");
            }
            System.out.println("|");

        }
        return P;

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
        return P;
    }





}
