package Project_Euler_Solutions_in_Java.Utils;
import java.util.stream.IntStream;
/**
 * Created by pglagolevschi on 24/12/2018.
 */
public class Util {
    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }
    /*
 * A simple but slow method of verifying the primality of a given number n is known as trial division
 * It consists of testing whether n is a multiple of any integer between 2 and \sqrt{n}
 */
    public static boolean isPrime2(int num){
        for(double j=2; j<=Math.sqrt((double) num);j++){
            double temp = (double)num%j;
            if(temp==0 )
                return false;
        }
        return true;
    }
}
