
public class Fourteen_Longest_Collatz {
/*
 * The following iterative sequence is defined for the set of positive integers:
 * n - n/2 (n is even)
 * n - 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 - 40 - 20 - 10 - 5 - 16 - 8 - 4 - 2 - 1
 * Which starting number, under one million, produces the longest chain?
 */
	final int MILLION = 1000000;
	public static void main(String[] args) {
		System.out.println(new Fourteen_Longest_Collatz().run());
	}
	
	private long run(){
		int longest_chain=0;
		long longest_chain_i=1;
		for(long i=1; i<MILLION;i++){
			if(chain(i)>longest_chain){
				longest_chain = chain(i);
				longest_chain_i = i;
			}
		}
		return longest_chain_i;
	}
	private int chain(long i){
		int seq=1;
		while(i>1){
			if(i%2==0)
				i= even(i);
			else i = odd(i);
			seq++;
		}
		return seq;
	}
	private long odd(long a){
		return 3*a + 1;
	}
	private long even(long a){
		return a/2;
	}
}
