package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

/**
 * It was proposed by Christian Goldbach that every odd composite number
 * can be written as the sum of a prime and twice a square.
 * 9 = 7 + 2×12
 * 15 = 7 + 2×22
 * 21 = 3 + 2×32
 * 25 = 7 + 2×32
 * 27 = 19 + 2×22
 * 33 = 31 + 2×12
 *
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written
 * as the sum of a prime and twice a square?
 */
public class _046_Goldbachs_Other_Conjecture {
    public static void main(String[] args) {
        util.Util.print(new _046_Goldbachs_Other_Conjecture().run());
    }
    public int run () {
        for(int i = 33; true; i += 2){
            if(isOddComposite(i) && ! followsGoldback(i)){
                return i;
            }
        }
    }
    public boolean followsGoldback(int n){
        for(int i = 1, twiceSqOfI = getTwiceSqOfN(i);twiceSqOfI < n ; i++, twiceSqOfI = getTwiceSqOfN(i)){
            int diff = n - twiceSqOfI;
            if (Util.isPrime(diff)){
                return true;
            }
        }
        return false;
    }
    public int getTwiceSqOfN(int n){
        return n * n * 2;
    }
    public boolean isOddComposite(int n){
        for ( int i = 3; i < n; i+=2){
            if ( n % i == 0)
                return true;
        }
        return false;
    }
}
