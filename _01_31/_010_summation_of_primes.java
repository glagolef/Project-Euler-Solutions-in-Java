package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Utils.Util;

public class _010_summation_of_primes {
	/*
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.
	 */
	final int TWO_MILLION = 2000000;
	public static void main(String[] args) {
		System.out.println(new _010_summation_of_primes().run());
	}
	public long run(){
		long sum=0;
		for(int i = 2; i < TWO_MILLION; i++)
			if(Util.isPrime(i))
				sum+=i;
		return sum;
	}
}
