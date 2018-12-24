package Project_Euler_Solutions_in_Java._01_31;

public class _015_lattice_patterns {
	/*
	 * The following iterative sequence is defined for the set of positive integers:
	 * n - n/2 (n is even)
	 * n - 3n + 1 (n is odd)
	 * Using the rule above and starting with 13, we generate the following sequence:
	 * 13 - 40 - 20 - 10 - 5 - 16 - 8 - 4 - 2 - 1
	 * Which starting number, under one million, produces the longest chain?
	 * 										                 (2N)
	 * this is a binomial question; answer (one bracket) =   ( N)
	 */										   
		final int TWENTY = 20;
		public static void main(String[] args) {
			System.out.println(new _015_lattice_patterns().run());
		}
		private long run(){
			long answer= binomial(40, 20);
			return answer;
		}
		public static long binomial(int nx2, int n){
			long [] b = new long [nx2+1];
			b[0] = 1;
			for(int i = 1; i<=nx2; i++){
				b[i]=1;
				for( int j = i-1; j>0; j--)
					b[j] += b[j-1];
			}
			return b[n];
			
		}
}
