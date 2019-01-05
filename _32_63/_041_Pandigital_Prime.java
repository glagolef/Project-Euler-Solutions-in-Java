package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.ArrayList;

/**
 * We shall say that an n-digit number is pandigital if it makes use
 * of all the digits 1 to n exactly once. For example,
 * 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */
public class _041_Pandigital_Prime {
    public static void main(String[] args) {
        Util.print(new _041_Pandigital_Prime().run());
    }
    public int run () {
        ArrayList<Integer> al = new ArrayList<>();
//        Util.getPermutations(987654321, al);
//        Util.getPermutations(87654321, al);
        Util.getPermutations(7654321, al);
        for(int index : al){
            if(Util.isPrime(index)){
                return index;
            }
        }
        return 0;
    }
}
