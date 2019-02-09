package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.math.BigDecimal;
import java.util.HashMap;
/**
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 *
 * By expanding this for the first four iterations, we get:
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 * The next three expansions are 99/70, 239/169, and 577/408,
 * but the eighth expansion, 1393/985, is the first example
 * where the number of digits in the numerator exceeds the number of digits in the denominator.
 *
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 *
 */
public class _057_SquareRootConvergents {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Util.println("Result = " + new _057_SquareRootConvergents().run());
        long end=System.currentTimeMillis();
        Util.println("Total time: " + (end - start) * 0.001 + " s");
    }
    private HashMap<Integer, Fraction> hashMap = new HashMap<>();
    public int run() {
        int counter = 0;
        for(int i = 2; i < 1000; i++) {
            counter += doesNumeratorExceedDenominator(i) ? 1 : 0;
        }
        return counter;
    }
    private boolean doesNumeratorExceedDenominator(int stack_count){
        Fraction fr = calculateFractionFromStack((stack_count));
        return (fr.numerator.toString().length() > fr.denominator.toString().length());
    }
    private Fraction calculateFractionFromStack(int stack_count){
        Fraction half = new Fraction(BigDecimal.ONE,new BigDecimal(2));
        Fraction result = half.clone();
        for (int i = 0; i < stack_count; i++){
            int hashCode = (half.denominator + " " + result.numerator + " " + result.denominator).hashCode();

            if(hashMap.containsKey(hashCode)) {
                result = hashMap.get(hashCode);
            } else {
                Fraction temp = new Fraction(half.denominator.intValue(), result.numerator, result.denominator);
                result = new Fraction(temp.denominator, temp.numerator);
                hashMap.put(hashCode, result.clone());
            }
        }
        result.numerator = result.numerator.add(result.denominator);
        return result;
    }

    private class Fraction{
        int whole;
        BigDecimal numerator, denominator;
        Fraction (BigDecimal numerator, BigDecimal denominator){
            this.numerator = numerator;
            this.denominator = denominator;
            reduceToGCD();
        }
        Fraction (int whole, BigDecimal numerator, BigDecimal denominator){
            this(numerator.add(denominator.multiply(new BigDecimal( whole))), denominator);
        }
        void reduceToGCD(){
            BigDecimal gcd = Util.getGCD(numerator, denominator);
            numerator = numerator.divide( gcd);
            denominator = denominator.divide( gcd);
        }
        public String toString(){
            return whole == 0 ? numerator.toString() + "/" + denominator.toString() : whole + " " + numerator.toString() + "/" + denominator.toString() ;
        }
        public Fraction clone(){
            return new Fraction(this.numerator, this.denominator);
        }
    }
}
