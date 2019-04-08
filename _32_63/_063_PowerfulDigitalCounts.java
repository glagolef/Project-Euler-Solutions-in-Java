package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.math.BigInteger;
/**
 * The 5-digit number, 16807=7^5, is also a fifth power.
 * Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
 *
 * How many n-digit positive integers exist which are also an nth power?
 */
public class _063_PowerfulDigitalCounts {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Util.println("Result = " + new _063_PowerfulDigitalCounts().run());
        long end = System.currentTimeMillis();
        Util.println("Total time: " + (end - start) * 0.001 + " s");
    }

    public int run() {
        int counter = 0;
        for(int i = 1; i < 10; i ++){
            for(int j = 1; ; j ++){
                BigInteger iPowJ = new BigInteger(String.valueOf(i)).pow(j);
                int digits = getNumberOfDigits(iPowJ);
                if(Math.abs(digits - j) > 2){
                    break;
                } else if (digits == j){
                    counter++;
                }
            }
        }
        return counter;
    }
    private int getNumberOfDigits(Number numberOfDigits){
        return String.valueOf(numberOfDigits).length();
    }
}
