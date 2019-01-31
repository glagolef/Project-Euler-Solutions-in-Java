package Project_Euler_Solutions_in_Java.Utils;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
/**
 * Created by glagolef on 24/12/2018.
 */
public class Util {
    public static final String SORTED_PANDIGITAL = "123456789";
    public static final String PATH = Paths.get(".\\src\\Project_Euler_Solutions_in_Java").toAbsolutePath().normalize().toString();
    public static final int FIRST_PRIME = 2;

 /*
 * A simple but slow method of verifying the primality of a given number n is known as trial division
 * It consists of testing whether n is a multiple of any integer between 2 and \sqrt{n}
 */

    public static boolean isPrime(int num){
        if(num < 2)
            return false;
        for(double j=2; j<=Math.sqrt((double) num);j++){
            double temp = (double)num%j;
            if(temp==0 ) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPandigitalIncomplete(int num) {
        return isPandigitalIncomplete(Integer.toString(num));
    }
    public static boolean isPandigitalIncomplete(String num){
        char[] stringToChar = num.toCharArray();
            HashSet hs = new HashSet();
            for(char c : stringToChar){
                hs.add(c);
            }
            return !hs.contains('0') && hs.size() == num.length();
    }
    public static boolean isPandigital(int num) {
        return isPandigital(Integer.toString(num));
    }
    public static boolean isPandigital(StringBuilder num) {
        return isPandigital(num.toString());
    }
    public static boolean isPandigital(String num){
        char[] stringToChar = num.toCharArray();
        Arrays.sort(stringToChar);
        StringBuilder sb = new StringBuilder();
        sb.append(stringToChar);
        return sb.toString().equals(SORTED_PANDIGITAL);
    }
    /*
     * Credit to https://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string?page=1&tab=votes#tab-top
     */
    public static void getPermutations(int str, Collection<Integer> al) {
        ArrayList<String> strAL = new ArrayList<>();
        getPermutations("", Integer.toString(str),strAL);
        for(String s : strAL){
            al.add(Integer.parseInt(s));
        }
    }
    public static void getPermutations(String str, Collection<String> al) {
        getPermutations("", str, al);
    }
    public static void getPermutations(String prefix, String str, Collection<String> al) {
        int n = str.length();
        if (n == 0) {
            al.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                getPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), al);
        }
    }
    public static void populateCollWithPrimesAboveXBelowY(Collection<Integer> hs, int x, int y){
        for(int i = x; i<y; i++){
            if (isPrime(i)){
                hs.add(i);
            }
        }
    }
    public static void populateCollWithPrimesBelowN(Collection<Integer> hs, int n){
        populateCollWithPrimesAboveXBelowY(hs, 1, n);
    }
    public static double getNCR(int n, int r){
        return  getFactorialOfN(n) / getFactorialOfN(r) / getFactorialOfN(n-r);
    }
    public static double getFactorialOfN(double n){
        return n == 1 ?  n : n * getFactorialOfN(n-1);
    }
    public static void print( Comparable T){
        System.out.print(T);
    }
public static void println( Comparable T){
    System.out.println(T);
}
    public static class WrapLong{
        public long num;
        public WrapLong(long num){
            this.num = num;
        }
    }
}


