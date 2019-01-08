package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2.
 * The first ten pentagonal numbers are:
 * 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
 * diff = 4,7,10,13,16,19,22,25,28
 * diff2 =
 * It can be seen that P4 + P7 = 22 + 70 = 92 = P8.
 * However, their difference, 70 − 22 = 48, is not pentagonal.
 *
 * Find the pair of pentagonal numbers, Pj and Pk,
 * for which their sum and difference are pentagonal and D = |Pk − Pj| is minimised;
 * what is the value of D?
 */
public class _044_Pentagon_Numbers {
    public static void main(String[] args) {
        util.Util.print(new _044_Pentagon_Numbers().run());
    }
    public int run () {
        HashMap<Integer, Long> pentagonalNumbers = new HashMap<>();
        HashSet<Long> hs = new HashSet<>();
        pentagonalNumbers.put(1, (long) 1);
        pentagonalNumbers.put(2, (long) 5);
        WrapLong longestPN = new WrapLong(0);
        for(int i = 2; true; i++) {
                for(int j = i/4+1; j<i; j++) {
                    long valOfI = pentagonalNumbers.get(i);
                    long valOfJ = pentagonalNumbers.get(j);
                    long diff = valOfI - valOfJ;
                    long sum = valOfI + valOfJ;
                    if(isPentagonal(pentagonalNumbers, hs, sum, longestPN) && isPentagonal(pentagonalNumbers, hs, diff, longestPN)) {
                        Util.print("i = " + valOfI + "; j = " + valOfJ + "; resulting D = " + diff);
                        return (int) diff;
                    }
                }
        }
    }
    public boolean isPentagonal(HashMap<Integer, Long> hm, HashSet<Long> hs, long currentValue, WrapLong largestValue){
        {
            if(currentValue >= largestValue.num) {
                generatePentagonals(hm, hs, currentValue, largestValue);
            }
            return hs.contains(currentValue);
        }
    }
    public void generatePentagonals(HashMap<Integer, Long> hm, HashSet<Long> hs, long currentValue, WrapLong largestValue){
        for (int latestN = hm.size() + 1; currentValue > largestValue.num; latestN++) {
            long nextVal = getNextPentagonal(latestN);
            largestValue.num = nextVal;
            hm.put(latestN, nextVal);
            hs.add(nextVal);
        }
    }
    public long getNextPentagonal (long n){
        return (n * (3 * n - 1)) / 2;
    }
    class WrapLong{
        long num;
        WrapLong(long num){
            this.num = num;
        }
    }
}