package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Utils.Util;

import java.util.ArrayList;

public class _027_Quadratic_Primes {
//n*n+a*n+b
    final int ONEK = 1000;
	public static void main(String[] args) {
		System.out.println(new _027_Quadratic_Primes().run());
	}
	private int run(){
		int longest_chain = 0;
        int longest_a = 0;
        int longest_b = 0;
		//test
//		for (int i=0; i<80; i++)
//			System.out.println(i + ": " + Util.isPrime2(i*i -79*i+1601));
		
		for(int a=0; a<ONEK; a++){
			for(int b=0;b<=ONEK; b++){
                ArrayList<int[]> possiblePrimes = getPrimeVariants(longest_chain, a, b);
                if(possiblePrimes.isEmpty())
                    continue;
                for(int[] nums : possiblePrimes){
                    int numA = nums[0];
                    int numB = nums[1];
                    int longestResForNums = getLongestResult(longest_chain, numA, numB);
                    if(longestResForNums > longest_chain){
                        longest_a = numA;
                        longest_b = numB;
                        longest_chain = longestResForNums;
                    }
                }
			}
		}
		return longest_a * longest_b;
	}
    public int getLongestResult(int longestChain, int a, int b){
        boolean chainBreak=false;
        for( int n = 0; !chainBreak; n++){
            int eval = equation(n,a,b);
            if(eval < 2 || !Util.isPrime2(eval))
                break;
            if(n > longestChain) {
                longestChain++;
            }
        }
        return longestChain;
    }
    public int equation( int n, int a, int b){
        return n*n + subcalc(n, a, b);
    }
    public int subcalc(int n, int a, int b){
        return (n*a + b);
    }
    public ArrayList<int[]> getPrimeVariants(int n, int a, int b){
        int nSquared = n*n;
        int[] calcOne = new int[] {a,b, (nSquared + subcalc(n, a, b))};
        int[] calcTwo = new int[] {-a,b, (nSquared + subcalc(n, -a, b))};
        int[] calcThree = new int[] {a,-b, (nSquared + subcalc(n, a, -b))};
        int[] calcFour = new int[] {-a,-b, (nSquared + subcalc(n, -a, -b))};
        ArrayList<int[]> list = new ArrayList<int[]>();
        for(int[] c : new int[][]{calcOne, calcTwo, calcThree, calcFour}){
            int result = c[2];
            if(result<1)
                continue;
            if (Util.isPrime2(result)){
                list.add(c);
            }
        }
        return list;
    }
}