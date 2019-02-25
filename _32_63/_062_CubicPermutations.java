package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.*;

/**
 * The cube, 41063625 (3453), can be permuted to produce two other cubes:
 * 56623104 (3843) and 66430125 (4053).
 * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
 *
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */
public class _062_CubicPermutations {
    private HashMap<String, ArrayList<Long>> cubes = new HashMap();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Util.println("Result = " + new _062_CubicPermutations().run(5));
        long end = System.currentTimeMillis();
        Util.println("Total time: " + (end - start) * 0.001 + " s");
    }

    public long run(int numberOfCubes) {
        for (int i = 1; ; i++) {
            long cubeOfI = getCubeOfN(i);

            String sortedNum = sortNumToString(cubeOfI);
            if (cubes.containsKey(sortedNum)) {
                ArrayList al = cubes.get(sortedNum);
                al.add(cubeOfI);
                if (al.size() == numberOfCubes) {
                    return (long) al.get(0);
                }
            } else {
                ArrayList al = new ArrayList<Long>();
                al.add(cubeOfI);
                cubes.put(sortedNum, al);
            }
        }
    }

    private String sortNumToString(long cubeOfI) {
        char[] charArray = String.valueOf(cubeOfI).toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    private long getCubeOfN(long n) {
        return n * n * n;
    }
}
