package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.ArrayList;
import java.util.HashSet;
/**
 * By replacing the 1st digit of the 2-digit number *3,
 * it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit,
 * this 5-digit number is the first example having seven primes among the ten generated numbers,
 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * Consequently 56003, being the first member of this family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 *
 */
public class _051_PrimeDigitReplacements {
    private ArrayList<Integer> primesAL = new ArrayList<>(); //for traversing
    private HashSet<Integer> primesHS = new HashSet<>();//for lookup
    private int largestPrime = Util.FIRST_PRIME;
    private final char [] NUMBERS = "012".toCharArray();
    public static void main(String[] args) {
        util.Util.print(new _051_PrimeDigitReplacements().run(8));
    }
    private int run (int xFamily) {
        int startingMinNum = 10000;
        int result = 0;
        for(int min = startingMinNum; result == 0; largestPrime = min, min *= 10){
            result = getSmallestPrimeWithXFamilyBelowN(min, xFamily);
        }
        return result;
    }
    private int getSmallestPrimeWithXFamilyBelowN(int maxNum, int xFamily){
        if(largestPrime < maxNum){
            populatePrimes(maxNum);
        }
        ArrayList<Integer> tmpAL = new ArrayList<>();
        for(int i = 0; i <= primesAL.size()-xFamily; i++){
            int num = primesAL.get(i);
            for(char c : NUMBERS){
                maybeGetMatchingIndexes(c, num, tmpAL);
                if(tmpAL.size() != 0){
                    c = getNextChar(c);
                    int yFamily = countReplacementsInCombos(tmpAL, num, c, xFamily);
                    tmpAL.clear();
                    if(yFamily==xFamily){
                        return num;
                    }
                }
            }
        }
        return 0;
    }
    //this would need to rewritten to generate all possible combinations of size > 2, if the indexes of the answer were > 3
    private int countReplacementsInCombos(ArrayList<Integer> indexes, int num , char startingChar, int xFamily){
        int result = countReplacements(indexes, num , startingChar);
        if( result != xFamily) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i + 1 < indexes.size(); i++, tmp.remove((Integer) i)) {
                tmp.add(indexes.get(i));
                for (int j = i + 1; j < indexes.size(); j++, tmp.remove((Integer) j)) {
                    tmp.add(indexes.get(j));
                    result = countReplacements(tmp, num, startingChar);
                    if (result == xFamily) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private int countReplacements(ArrayList<Integer> indexes, int num , char c){
        StringBuilder st = new StringBuilder();
        st.append(num);
        int xFamilyCounter = 1;
        for(char currentChar = c; currentChar <= '9'; currentChar = getNextChar(currentChar)){
            num = replaceIndexesOfNumWithC(st, indexes, currentChar);
            if(primesHS.contains(num)){
                xFamilyCounter++;
            }
        }
        return xFamilyCounter;
    }
    private int replaceIndexesOfNumWithC(StringBuilder sb, ArrayList<Integer> indexes, char c){
        String valueOfC = String.valueOf(c);
        for(int i : indexes){
            sb.replace(i, i+1, valueOfC);
        }
        return Integer.parseInt(sb.toString());
    }
    private void maybeGetMatchingIndexes(char searchChar, int num, ArrayList<Integer> al){
        String st = String.valueOf(num);
        for(int i = 0; i < st.length(); i++){
            char c = st.charAt(i);
            if(c == searchChar){
                al.add(i);
            }
        }
        if(al.size() <2){
            al.clear();
        }

    }
    private char getNextChar(char c){
        int cValue = (int) c + 1;
        return (char)cValue;
    }
    private void populatePrimes(int n){
        primesAL.clear();
        primesHS.clear();
        Util.populateCollWithPrimesAboveXBelowY(primesAL, n, n*10);
        primesHS.addAll(primesAL);
    }
}
