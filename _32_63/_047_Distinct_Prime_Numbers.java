package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Find the first four consecutive integers to have four distinct prime factors each.
 * What is the first of these numbers?
 */
public class _047_Distinct_Prime_Numbers {
//    public HashSet<Integer> primesHS = new HashSet<>();
    public ArrayList<Integer> primes = new ArrayList<>();
    public int largestPrime = 0;
    public static void main(String[] args) {
        util.Util.print(new _047_Distinct_Prime_Numbers().run());
    }
    public int run () {
        generateNextPrimes();
        return twoDistinctPrimeFactorNumber();
    }
    public int twoDistinctPrimeFactorNumber(){
        for(int i = 170; true; i++) {
            if (i > largestPrime) {
                generateNextPrimes(i);
            }
            if(consecutiveHasPrimeDividors(i, 4, 4))
                return i;
        }
    }
    public boolean consecutiveHasPrimeDividors(int i, int consecutiveN, int primeDividors){
        if (consecutiveN == 0)
            return true;
        else if((hasNPrimeDivisors(primeDividors, i, new HashSet<>()))){
            return consecutiveHasPrimeDividors(i+1, consecutiveN -1, primeDividors);
        } else return false;
    }
    public boolean hasNPrimeDivisors(int numOfDivisors, int num, HashSet<Integer> hs){
        if(numOfDivisors == 0)
            return true;
        for(int p : primes){
            if(hs.contains(p)) {
                continue;
            } else if(p >= num){
                if(numOfDivisors == 1 && p == num)
                    return true;
                else {
                    break;
                }
            } else if ( isDivisibleBy(num,p)){
                int newnum = num / p;
                hs.add(p);
                return hasNPrimeDivisors(numOfDivisors-1, newnum,  hs);
            }
            }
        return false;
    }

    public boolean isDivisibleBy(int dividend, int divisor){
        return dividend % divisor == 0;
    }
    public void generateNextPrimes(){
        generateNextPrimes(largestPrime+1);
    }
    public void generateNextPrimes(int num){
        int oldSize = primes.size();
        for(int i  = largestPrime+1; num >= largestPrime || primes.size() < oldSize+10; i ++){
            if(Util.isPrime(i)){
//                primesHS.add(i);
                primes.add(i);
                largestPrime = i;
            }
        }
    }

}
