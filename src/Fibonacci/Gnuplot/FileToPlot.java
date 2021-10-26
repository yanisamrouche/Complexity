package Fibonacci.Gnuplot;

import Fibonacci.Fibonacci;
import Fibonacci.FibonacciExp;
import Fibonacci.FibonacciIterative;
import Fibonacci.FibonacciRecursive;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;

public class FileToPlot {
    FibonacciRecursive fibonacciRecursive;
    FibonacciIterative fibonacciIterative;
    FibonacciExp fibonacciExp;
    static Chrono chrono = new Chrono();
    public static void main(String[] args) throws IOException {

        fileData(50);
    }

    public static void fileData(int n) throws IOException {
        Writer file = new FileWriter("src/Fibonacci/Gnuplot/data2.dat");
        for(int i=0; i < n ; i=i+10){
            chrono.start();
             Fibonacci fibonacciRecusrsive = new Fibonacci();
             fibonacciRecusrsive.recursive(new BigInteger(""+i));
             chrono.stop();
            file.write(i+" "+chrono.getElapsedTime()+"\n");
        }
        file.close();

    }

    //plot '/amuhome/a19028598/Bureau/ComplexityTP01/src/Fibonacci/Gnuplot/data' using 1:2 with lines title "eterative time ", '/amuhome/a19028598/Bureau/ComplexityTP01/src/Fibonacci/Gnuplot/data' using 1:3 lines axis x1y2 title "fibo de n"
}
