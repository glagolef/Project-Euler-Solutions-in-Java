package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Template;
import Project_Euler_Solutions_in_Java.Utils.Util;

import java.math.BigDecimal;

/**
 * A googol (10^100) is a massive number: one followed by one-hundred zeros;
 * 100^100 is almost unimaginably large: one followed by two-hundred zeros.
 * Despite their size, the sum of the digits in each number is only 1.
 *
 * Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
 */
public class _056_PowerfulDigitSum  implements Template {
    private final int NINETY_NINE = 99;
    public static void main(String ... args){
        Util.println("Result = " + new _056_PowerfulDigitSum().run());
    }
    @Override
    public int run() {
        return getLargestPowerfulDigitSum();
    }
    private int getLargestPowerfulDigitSum(){
        int largestResult = 0;
        for(int a = NINETY_NINE; a >0; a--){
            BigDecimal temp = new BigDecimal(a);
            for( int b = NINETY_NINE; b > 0; b--){
                int digitSum = combineDigits(temp.pow(b));
                if (largestResult < digitSum){
                    largestResult = digitSum;
                }
            }
        }
        return largestResult;
    }
    private int combineDigits(Number num){
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        int result = 0;
        for(char c : num.toString().toCharArray()){
            result += Character.getNumericValue(c);
        }
        return result;
    }

}
