package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Template;
import Project_Euler_Solutions_in_Java.Utils.Util;

/**
 * There are exactly ten ways of selecting three from five, 12345:
 *
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 *
 * In combinatorics, we use the notation, 5C3 = 10.
 *
 * In general,nCr =	n!/(r!(n−r)!)
 * where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 *
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 */
public class _053_CombinatoricSelections implements Template{
    public final int ONE_MILLION = 1000000;
    public static void main(String[] args) {
        util.Util.print(new _053_CombinatoricSelections().run());
    }
    public int run () {
        return combinatoricsOverOneMillion();
    }
    public int combinatoricsOverOneMillion(){
        int counter = 0;
        for (int n = 23; n <= 100; n ++){
            double nCr = 0;
            boolean isOverOneMill = false;
            for ( int r = 1;  r < n; r ++){
                nCr = Util.getNCR(n, r);
                if ( nCr > ONE_MILLION){
                    counter++;
                    isOverOneMill = true;
                }else if( isOverOneMill && nCr < ONE_MILLION){
                    break;
                }
            }
        }
        return counter;
    }
}
