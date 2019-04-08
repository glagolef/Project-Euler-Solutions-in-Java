package Project_Euler_Solutions_in_Java._64_95;

import Project_Euler_Solutions_in_Java.Utils.Fraction;
import Project_Euler_Solutions_in_Java.Utils.Util;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * The square root of 2 can be written as an infinite continued fraction.
 * <p>
 * √2 = 1 + (1/ (2+ 1/ ( 2+1/ (2+1/ (2 +...)))))
 * <p>
 * The infinite continued fraction can be written, √2 = [1;(2)],
 * (2) indicates that 2 repeats ad infinitum. In a similar way, √23 = [4;(1,3,1,8)].
 * <p>
 * It turns out that the sequence of partial values of continued fractions
 * for square roots provide the best rational approximations.
 * Let us consider the convergents for √2.
 * <p>
 * 1 + 1/2 = 3/2
 * 1 + 1/(2+1/2) = 7/5
 * 1 +1/(2+1/(2+1/2)) = 17/12
 * 1 +1/(2+1/(2+1/(2+1/2))) = 41/29
 * <p>
 * Hence the sequence of the first ten convergents for √2 are:
 * 1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
 * <p>
 * What is most surprising is that the important mathematical constant,
 * e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
 * <p>
 * The first ten terms in the sequence of convergents for e are:
 * <p>
 * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
 * The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
 * <p>
 * Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 */
public class _065_ConvergentsOfE {
    private Stack<Integer> denums = new Stack<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Util.println("Result = " + new _065_ConvergentsOfE().run());
        long end = System.currentTimeMillis();
        Util.println("Total time: " + (end - start) * 0.001 + " s");
    }

    public Object run() {
        populateStack();
        return sumOfDigits(calculateExpansions().getNumerator());
    }

    private int sumOfDigits(BigDecimal num) {
        int result = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            result += Character.getNumericValue(c);
        }
        return result;
    }

    private Fraction calculateExpansions() {
        Fraction result = new Fraction(new BigDecimal(1), new BigDecimal(denums.pop()));
        while (!denums.isEmpty()) {
            Fraction temp = new Fraction(denums.pop(),
                    result.getNumerator(), result.getDenominator());
            result = new Fraction(temp.getDenominator(), temp.getNumerator());
        }
        BigDecimal final_numerator = result.getNumerator().add(
                result.getDenominator().multiply(new BigDecimal(2)));
        result.setNumerator(final_numerator);
//        Util.println(result.getNumerator() + "/" + result.getDenominator());
        return result;
    }

    private void populateStack() {
        for (int i = 0, threes = 1, twos = 2; i < 99; i++, threes++) {
            switch (threes) {
                case 2: {
                    denums.push(twos);
                    twos += 2;
                    break;
                }
                case 3: {
                    threes = 0;
                }
                case 1: {
                    denums.push(1);
                    break;
                }
            }
        }
    }
}
