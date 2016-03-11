import java.math.BigInteger;
/*
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */
public class _020_factorial_digit_sum {

	public static void main(String[] args) {
		System.out.println(new _020_factorial_digit_sum().run());
	}
	private int run(){
		int sum=0;
		BigInteger n = BigInteger.ONE;
		BigInteger ten = BigInteger.TEN;
		for(int i=1; i<100; i++)
			n = n.multiply(BigInteger.valueOf(i));
		while(n.compareTo(BigInteger.ZERO) == 1){
			sum+=n.mod(ten).intValue();
			n = n.divide(ten);
		}
	return sum;
	}

}
