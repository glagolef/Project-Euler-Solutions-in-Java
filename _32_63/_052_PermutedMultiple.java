package Project_Euler_Solutions_in_Java._32_63;

import java.util.Arrays;
/**
 * It can be seen that the number, 125874, and its double, 251748,
 * contain exactly the same digits, but in a different order.
 *
 * Find the smallest positive integer, x,
 * such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
public class _052_PermutedMultiple {
    public static void main(String[] args) {
        util.Util.print(new _052_PermutedMultiple().run());
    }
    private int run () {
        return smallestPermutedMultiple();
    }
    private int smallestPermutedMultiple() {
        for (int num = 123; true; num++) {
            String sortedNum = sortedNum(num);
            if (sortedNum.equals(sortedTwoX(num)) &&
                    sortedNum.equals(sortedThreeX(num)) &&
                    sortedNum.equals(sortedFourX(num)) &&
                    sortedNum.equals(sortedFiveX(num)) &&
                    sortedNum.equals(sortedSixX(num))) {
                        return num;
            }
        }
    }
    private String sortedTwoX(int x){
        return sortedNum(2 *x);
    }
    private String sortedThreeX(int x){
        return sortedNum(3 *x);
    }
    private String sortedFourX(int x){
        return sortedNum(4 *x);
    }
    private String sortedFiveX(int x){
        return sortedNum(5 * x);
    }
    private String sortedSixX(int x){
        return sortedNum(6 * x);
    }
    private String sortedNum(int num){
        char[] unsorted = String.valueOf(num).toCharArray();
        Arrays.sort(unsorted);
        return String.valueOf(unsorted);
    }
}
