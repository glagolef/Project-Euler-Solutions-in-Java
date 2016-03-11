
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
		long largest=0;
		long n = (long) 600851475143.0;
		for (long i=1; i < n/2; i++){
			boolean prime = true;
			if(n%i==0){
				for(double j=2; j<=Math.sqrt((double) i) && prime==true;j++){
					if( i%j==0)
						prime=false;
				}
				if(prime){
					largest=i;
					System.out.println(", " + largest);
				}
			}
		}
		
	}

}
