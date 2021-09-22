package Fibonacci;

public class Fibonacci {


    public static long timeComplexity(int n, String functionName){
        System.out.println("pour n = "+n);
        long time =0;
        switch (functionName){
            case "fibonacciIterative":
                long start = System.nanoTime();
                FibonacciIterative.fibonacciIterative(n);
                long end = System.nanoTime();
                time = end - start;

                break;
            case "fibonacciRecursive":
                long s = System.nanoTime();
                FibonacciRecursive.fibonacciRecursive(n);
                long e = System.nanoTime();
                time = e - s;
                break;
            case "fibonacciExponentiation":
                long st = System.nanoTime();
                FibonacciExp.fiboExp(n);
                long en = System.nanoTime();
                time = en - st;
                break;
        }
        return time;
    }





    public static void main(String[] args){
        //Fibonacci.Fibonacci fibonacci = new Fibonacci.Fibonacci();
        System.out.println("Fibonnaci version recursive : "+FibonacciRecursive.fibonacciRecursive(30));
        System.out.println("temps : "+timeComplexity(30,"fibonacciRecursive") +" nanosecondes");
        System.out.println("--------------------------------------------------------");
        System.out.println("Fibonnaci version iterative : "+FibonacciIterative.fibonacciIterative(30));
        System.out.println("temps : "+timeComplexity(30,"fibonacciIterative") + " nanosecondes");
        System.out.println("--------------------------------------------------------");
        System.out.println();
        System.out.println("Fibonnaci version exponentiation de matrice : "+FibonacciExp.fiboExp(30));
        System.out.println("temps : "+timeComplexity(30,"fibonacciExponentiation") + " nanosecondes");
    }







}