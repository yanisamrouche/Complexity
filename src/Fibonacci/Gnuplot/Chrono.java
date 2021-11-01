package Fibonacci.Gnuplot;

import java.io.*;

public class Chrono {

    private long lastStartTime;
    private boolean running = false;
    private long elapsedTime = 0;


    public void start() {
        if (running) return;
        running = true;
        lastStartTime = System.nanoTime();
    }


    public double stop() {
        if (running) {
            running = false;
            elapsedTime = elapsedTime + System.nanoTime() - lastStartTime;
        }
        return getElapsedTime();
    }


    public double getElapsedTime() {
        return  (double) elapsedTime;
    }

    public void restart() {
        reset();
        start();
    }

    public void reset() {
        elapsedTime = 0;
        running = false;
    }

    public void replace(String name) throws IOException {
        FileWriter  file  = new FileWriter("src/Fibonacci/Gnuplot/iterative.dat");
        try (BufferedReader bf = new BufferedReader(new FileReader(name))) {
            String ligne;
            int nbLignes = 0;
            int i =0;

            while ((ligne = bf.readLine()) != null) {

                if(!ligne.contains(",")){
                    ligne.replace(" ", ",");
                    file.write(ligne);

                }
                else file.write(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.close();

    }
}