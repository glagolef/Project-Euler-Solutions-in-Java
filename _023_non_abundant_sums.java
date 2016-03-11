/*
 * A number n is called deficient if the sum of its proper divisors 
 * is less than n and it is called abundant if this sum exceeds n.
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
 * the smallest number that can be written as the sum of two abundant numbers is 24. 
 * By mathematical analysis, it can be shown that all integers greater than 28123 
 * can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced 
 * any further by analysis even though it is known that the greatest number 
 * that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class _023_non_abundant_sums {
	final int UPPER=28123;
	public static void main(String[] args) {
		System.out.println(new _023_non_abundant_sums().run());
	}
	private int run(){
		boolean a = false;
		int sum = 0;
		abundant(24);
		boolean abund [] = new boolean [UPPER+1];
		for (int i=0; i<=UPPER;i++){
			abund[i]=abundant(i);
			for (int j=12;j<=i-12 && a==false; j++)
				a = abund[j] && abund[i-j];
			if(a)
				a = false;
			else sum+=i;
		}
		return sum;
	}
	private boolean abundant(int number){
		int sum=0;
		for(int i=1; i<=number/2 && sum<=number; i++)
			if(number%i==0)
				sum+=i;
		return number<sum;
	}
}
