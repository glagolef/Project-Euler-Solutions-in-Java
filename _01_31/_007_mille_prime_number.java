package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Utils.Util;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */
public class _007_mille_prime_number {
	public static void main(String[] args) {
		long start=System.currentTimeMillis();
		Util.println("Result = " + new _007_mille_prime_number().run());
		long end=System.currentTimeMillis();
		Util.println("Total time: " + (end - start) * 0.001 + " s");
	}
	public int run(){
		int requestedN = 10001;
		int result = 1;
		for(int count = 0;count < requestedN ;result++) {
			count += Util.isPrime(result) ? 1 : 0;
		}
		return result-1;
	}

}
