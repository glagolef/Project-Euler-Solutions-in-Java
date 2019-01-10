package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.*;

/**
 * The arithmetic sequence, 1487, 4817, 8147,
 * in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class _049_Prime_Permutations {
    public static void main(String[] args) {
        util.Util.print(new _049_Prime_Permutations().run());
    }
    public String run () {
        HashSet<Integer> skipList = new HashSet<>();
        for(int i = 1488; i <9999; i++){
            ArrayList<Integer> results = new ArrayList<>();
            if(skipList.contains(i)){
                continue;
            }
            getValidPermutations(i, results, skipList);

            if(results.size() < 3){
                continue;
            }

            for(int num1 = 0; num1 < results.size(); num1 ++){{
                for(int num2 = 0; num2 < results.size(); num2 ++){
                    if(num1 == num2){
                        continue;
                    }
                    int valOfNum1 = results.get(num1);
                    int valOfNum2 = results.get(num2);
                    int diff = valOfNum2 - valOfNum1;
                    int valOfNum3 = valOfNum2 + diff;
                    if(results.contains(valOfNum3)){
                        StringBuilder sb = new StringBuilder();
                        return sb.append(valOfNum1).append(valOfNum2).append(valOfNum3).toString();
                    }
                    if(results.size() == 3){
                        break;
                    }
                }
                if(results.size() == 3){
                    break;
                }
            }
            }
        }
        return "";
    }
    public void getValidPermutations(int i, ArrayList<Integer> results, HashSet<Integer> skipList){
        HashSet<Integer> permutations = new HashSet<>();
        ArrayList<Integer> permutationsAL = new ArrayList<>();
        Util.getPermutations(i, permutations);
        permutationsAL.addAll(permutations);
        Collections.sort(permutationsAL);

        for(int num : permutationsAL){
            if(num < i || skipList.contains(num)){
                continue;
            } else if (!Util.isPrime(num)){
                skipList.add(num);
            } else{
                results.add(num);
            }
        }
    }
}
