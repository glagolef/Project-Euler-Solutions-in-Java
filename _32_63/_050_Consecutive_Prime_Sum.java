package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime,
 * contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class _050_Consecutive_Prime_Sum {
    private static HashSet<Integer> primesHS = new HashSet<>();
    private static final int ONE_MILLION = 1000000;
    private static final int ONE_HUNDRED = 100;
    public static void main(String[] args) {
        util.Util.print(new _050_Consecutive_Prime_Sum().run(ONE_MILLION));
    }
    public int run (int maxNum) {
        populatePrimes(maxNum);
        return largestSumOfPrimesBelowN(maxNum);
    }
    private int largestSumOfPrimesBelowN(int n){
        ArrayList<Integer> primesAL = new ArrayList<>();//for traversing
        primesAL.addAll(primesHS);
        Collections.sort(primesAL);
        int largestSumOfPrimes = 0;
        int largestSequence = 0;
        for(int p1 = 0; p1<primesAL.size()-1; p1++){
            int currentSum = primesAL.get(p1);
            int currentLargestSequence = 1;
            for(int p2 = p1+1; currentSum<n && p2<primesAL.size(); p2++){
                int p2Val = primesAL.get(p2);
                currentSum+=p2Val;
                currentLargestSequence++;
                if(primesHS.contains(currentSum)){
                    if(largestSequence< currentLargestSequence){
                        largestSequence = currentLargestSequence;
                        largestSumOfPrimes = currentSum;
                    }
                }
            }
        }
        return largestSumOfPrimes;
    }
    private void populatePrimes(int n){
        if(primesHS.isEmpty())
            Util.populateCollWithPrimesBelowN(primesHS, n);
    }

}
