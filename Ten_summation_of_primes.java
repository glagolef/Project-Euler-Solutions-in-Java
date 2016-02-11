public class Ten_summation_of_primes {
	/*
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * Find the sum of all the primes below two million.
	 */
	final int TWO_MILLION = 2000000;
	public static void main(String[] args) {
		System.out.println(new Ten_summation_of_primes().run());
	}
	public long run(){
		long sum=0;
		for(int i = 2; i < TWO_MILLION; i++)
			if(isPrime(i))
				sum+=i;
		return sum;
	}
	public boolean isPrime(int num){
		for(double j=2; j<=Math.sqrt((double) num);j++){
			double temp = (double)num%j;
			if(temp==0 )
				return false;
		}
		return true;
	}
}
