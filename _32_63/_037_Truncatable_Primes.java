package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by glagolef on 24/12/2018.
 * The number 3797 has an interesting property.
 * Being prime itself, it is possible to continuously remove digits from left to right,
 * and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class _037_Truncatable_Primes {
    public static void main(String[] args) {

        System.out.println(new _037_Truncatable_Primes().run());
    }
    public int run (){
        int result = 0;
        for(int i = 8, count = 0; count < 11; i++){
            if( primesOnLeftSide(i) && primesOnRightSide(i)) {
                Util.print(i);
                count++;
                result += i;
            }
        }
        return result;
    }
    public boolean primesOnLeftSide(int num){
        String numberAsString = String.valueOf(num);
        for(int startIndex = 0, endIndex = 1; endIndex<= numberAsString.length(); endIndex++){
            String subString = numberAsString.substring(startIndex,endIndex);
            int numFromString = Integer.parseInt(subString);
            if(!Util.isPrime(numFromString)){
                return false;
            }
        } return true;
    }
    public boolean primesOnRightSide(int num){
        String numberAsString = String.valueOf(num);
        for(int startIndex = 1, endIndex = numberAsString.length(); startIndex< endIndex; startIndex++){
            String subString = numberAsString.substring(startIndex,endIndex);
            int numFromString = Integer.parseInt(subString);
            if(!Util.isPrime(numFromString)){
                return false;
            }
        } return true;
    }


}
