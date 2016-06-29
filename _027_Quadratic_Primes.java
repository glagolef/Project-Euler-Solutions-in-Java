
public class _027_Quadratic_Primes {
	public static void main(String[] args) {
		System.out.println(new _027_Quadratic_Primes().run());
	}
	private int run(){
		for (int i=0; i<80; i++)
			System.out.println(i + ": " + isPrime(i*i -79*i+1601));
		return 0;
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
