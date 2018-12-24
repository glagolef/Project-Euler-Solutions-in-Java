package Project_Euler_Solutions_in_Java._01_31;

public class _007_mille_prime_number {
	public static void main(String[] args) {
		System.out.println(new _007_mille_prime_number().run());
	}
	public int run(){
//		Seven_mille_prime_number a = new Seven_mille_prime_number();
		int primeNum=0;
		for(int i=1, j=0;j<=10001 ;i++)
			if(isPrime(i)){
				j++;
				primeNum=i;
//				System.out.println(j + "th prime number = " + primeNum);
			}
		return primeNum;
	}
	/*
     * A simple but slow method of verifying the primality of a given number n is known as trial division
     * It consists of testing whether n is a multiple of any integer between 2 and \sqrt{n} 
	 */
	public boolean isPrime(int num){
				for(double j=2; j<=Math.sqrt((double) num);j++){
					double temp = (double)num%j;
					if(temp==0 )
						return false;
				}
		return true;
	}
}
