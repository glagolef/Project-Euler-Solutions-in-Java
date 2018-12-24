package Project_Euler_Solutions_in_Java._01_31;

public class _004_Largest_Palindrome {
/*
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 */
	public static int reverseInt(int a){
		int b=0;
		while (a!=0){
			b= b*10 + a%10;
			a/=10;
		}
		return b;
	}
	public static void main(String[] args) {
		int a=999;
		boolean found = false;
		int answer=0;
		
		outerloop:
		for(int i=a; !found && i>100; i--){
			if(i*a< answer)
				break outerloop;
			innerloop:
			for(int j=a;!found && j>100; j--){
				if(i*j==reverseInt(i*j)){
					answer=i*j>answer?i*j:answer;
					System.out.println(i*j);
					break innerloop;
				}
			}
		}
		System.out.println("final answer: " + answer);		
	}
}
