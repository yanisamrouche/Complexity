package Fibonacci;

public class FibonacciIterative {
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
}
