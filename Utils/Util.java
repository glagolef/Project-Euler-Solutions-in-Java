package Project_Euler_Solutions_in_Java.Utils;
import java.util.HashSet;
import java.util.stream.IntStream;
/**
 * Created by pglagolevschi on 24/12/2018.
 */
public class Util {
    public static Integer largestPrime = 0;
    public static HashSet<Integer> primes = new HashSet<>();
 /*
 * A simple but slow method of verifying the primality of a given number n is known as trial division
 * It consists of testing whether n is a multiple of any integer between 2 and \sqrt{n}
 */

    public static boolean isPrime(int num){
        if(num < 2)
            return false;
//        if(num<=largestPrime){
//            return primes.contains(num);
//        }
        for(double j=2; j<=Math.sqrt((double) num);j++){
            double temp = (double)num%j;
            if(temp==0 ) {
                return false;
            }
        }
//        primes.add(num);
//        largestPrime = num;
        return true;
    }
public static void print( Comparable T){
    System.out.println(T);
}
}
