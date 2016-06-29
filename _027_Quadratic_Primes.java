public class _027_Quadratic_Primes {
//n*n+a*n+b
	public static void main(String[] args) {
		System.out.println(new _027_Quadratic_Primes().run());
	}
	private int run(){
		int a=-999;
		int b=1;
		boolean chain=true;
		int longest_chain=41;
		int result=0;
		//test
		for (int i=0; i<80; i++)
			System.out.println(i + ": " + isPrime(i*i -79*i+1601));
		
		for(int i=999; a<i;a++){
			b=1;
			for(int j=999;j>b; b++){
				boolean chain_break=false;
				for(int n=0; chain_break==false;n++){
//					if(a==1 && b==41)
//						System.out.println("here we are");
					int calculation = n*n+a*n+b;
					if(isPrime(calculation)){
						if(n>longest_chain){
							longest_chain = n;
							result = a*b;
							System.out.println("a = " + a + ", b = " + b + ": Longest chain = " + longest_chain + " ; result (a*b) = " + result);
						}
					}else chain_break=true;
					
				}
			}
		}
		return result;
	}
	public boolean isPrime(int num){
		if(num<0)
			return false;
		for(double j=2; j<=Math.sqrt((double) num);j++){
			double temp = (double)num%j;
			if(temp==0 )
				return false;
		}
		return true;
	}
}