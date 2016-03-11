import java.math.BigInteger;
/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000
 */
//much better solution with shiftLeft(1000)function.
public class _016_power_digit_sum {
	final int THOUSAND = 1000;
	final BigInteger TWO = new BigInteger("2");
	final BigInteger TEN = new BigInteger("10");

	public static void main(String[] args) {
		System.out.println(new _016_power_digit_sum().run());
	}
	private BigInteger run(){
		BigInteger answer= power_digit(THOUSAND);
		return sum(answer);
	}
	BigInteger power_digit(int power){
		if (power!=0)
		return TWO.multiply(power_digit(power-1));
		return TWO.divide(TWO);
	}
	private BigInteger sum(BigInteger a){
		if(a.compareTo(BigInteger.ZERO) > 0)
		return (a.remainder(TEN)).add(sum(a.divide(TEN)));
		return TWO.subtract(TWO);
	}
}
