package Project_Euler_Solutions_in_Java.Utils;

import java.io.*;

import static Project_Euler_Solutions_in_Java.Utils.Util.isPrime;

public class GeneratePrimesToTextFile {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new GeneratePrimesToTextFile().run();
        long end = System.currentTimeMillis();
        Util.println("Total time: " + (end - start) * 0.001 + " s");
    }

    public void run() {
        String path = Util.PATH + "\\src\\";
        String fileName = "primes.txt";
        long x = 100000000;
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter( new FileWriter(path + fileName));
            for(long i = 2; i<x; i++){
                if (isPrime(i)){
                    writer.write(i + ",");
                }
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(writer!= null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
