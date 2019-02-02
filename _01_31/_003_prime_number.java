package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Utils.Util;

public class _003_prime_number {
/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * A simple but slow method of verifying the primality of a given number n is known as trial division
 * It consists of testing whether n is a multiple of any integer between 2 and \sqrt{n}
 * 
 */

	public static void main(String[] args) {
		Util.println(new _003_prime_number().run());
	}
 public long run(){
	 long dividend = 600851475143L;

	 for (long divisor=(long)Math.sqrt((double) dividend); divisor > 1; divisor--){
	 	 if(Util.isPrime(divisor) && Util.isLongMultiple(dividend, divisor)){
	 	 	return divisor;
		 }
	 }
	 return 0;
 }

}
