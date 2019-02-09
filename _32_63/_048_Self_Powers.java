package Project_Euler_Solutions_in_Java._32_63;

import java.math.BigDecimal;

/**
 * The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class _048_Self_Powers {
    public final BigDecimal DIVISOR = new BigDecimal(10000000000L);
    public static void main(String[] args) {
        util.Util.print(new _048_Self_Powers().run());
    }
    public String run () {
        BigDecimal result = new BigDecimal(0);
        for( int i = 1; i<= 1000; i++){
            BigDecimal tmp = new BigDecimal(i);
            tmp = tmp.pow(i);
            result = reduceToTen(result.add (tmp));

        }
        return result.toString();
    }
    public BigDecimal reduceToTen(BigDecimal num){
        return num.remainder(DIVISOR);
    }
}
