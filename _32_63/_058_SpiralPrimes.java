package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

/**
 * Starting with 1 and spiralling anticlockwise in the following way,
 * a square spiral with side length 7 is formed.
 *
 * 37 36 35 34 33 32 31
 * 38 17 16 15 14 13 30
 * 39 18  5  4  3 12 29
 * 40 19  6  1  2 11 28
 * 41 20  7  8  9 10 27
 * 42 21 22 23 24 25 26
 * 43 44 45 46 47 48 49
 *
 * It is interesting to note that the odd squares lie along the bottom right diagonal,
 * but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime;
 * that is, a ratio of 8/13 ≈ 62%.
 *
 * If one complete new layer is wrapped around the spiral above,
 * a square spiral with side length 9 will be formed.
 * If this process is continued, what is the side length of the square spiral
 * for which the ratio of primes along both diagonals first falls below 10%?
 */
public class _058_SpiralPrimes {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Util.println("Result = " + new _058_SpiralPrimes().run());
        long end = System.currentTimeMillis();
        Util.println("Total time: " + (end - start) * 0.001 + " s");
    }

    public int run() {
        return lengthOfSpiralBelowTenPercentPrimes();
    }

    private int lengthOfSpiralBelowTenPercentPrimes(){
        float percentage = 100;
        int lengthOfSpiral = 1;
        int diagonals = 1, primes = 0;
        for(int diagonalNum = 1, offset = 2 ;percentage >= 10 ; lengthOfSpiral+=2, offset+=2 ){
            for(int count = 0; count < 4; diagonals ++, count++){
                diagonalNum+=offset;
                if(Util.isPrime(diagonalNum)) {
                    primes ++;
                }
            }
            percentage = getPercentage(primes,diagonals);
        }
        return lengthOfSpiral;
    }

    private float getPercentage(int primes, int diagonals){
        return ((float) primes / diagonals) * 100;
    }
}
