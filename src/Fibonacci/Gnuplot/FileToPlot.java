package Fibonacci.Gnuplot;

import Fibonacci.Fibonacci;

import java.io.*;
import java.math.BigInteger;


public class FileToPlot {
    public static  void replace(String name) throws IOException {
        FileWriter  file  = new FileWriter("src/Fibonacci/Gnuplot/exponentielNew.csv");
        try (BufferedReader bf = new BufferedReader(new FileReader(name))) {
            String ligne;
            int nbLignes = 0;
            int i =0;
            while ((ligne = bf.readLine()) != null) {
                if(!ligne.contains(",")){
                    //System.out.println(ligne);
                    String  line = ligne.replace(" ", ",");
                    file.write(line+"\n");
                }
                else {
                    file.write(ligne +"\n");
                    System.out.println(ligne);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.close();

    }


    static Chrono chrono = new Chrono();
    public static void main(String[] args) throws IOException {
       replace("src/Fibonacci/Gnuplot/exponentiel.csv");



        //fileData(200_000);

    }
    public static void fileData(int n) throws IOException {
        Writer file = new FileWriter("src/Fibonacci/Gnuplot/exponentiel.csv");
        for(int i=0; i <= n ; i+=20_000){
            chrono.start();
            Fibonacci fibonacciRecusrsive = new Fibonacci();
            fibonacciRecusrsive.matrixExponentiation(new BigInteger(""+i));
            chrono.stop();
            file.write(i+" "+chrono.getElapsedTime()/1000_000_000 +"\n");
        }
        file.close();
    }
    //plot '/amuhome/a19028598/Bureau/ComplexityTP01/src/Fibonacci/Gnuplot/data' using 1:2 with lines title "eterative time ", '/amuhome/a19028598/Bureau/ComplexityTP01/src/Fibonacci/Gnuplot/data' using 1:3 lines axis x1y2 title "fibo de n"
}
