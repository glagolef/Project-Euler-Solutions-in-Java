package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Template;
import Project_Euler_Solutions_in_Java.Utils.Util;

public class _004_Largest_Palindrome implements Template {
/*
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 */
	final int LARGEST_THREE_DIGITS = 999;
	final int SMALLEST_THREE_DIGITS = 100;


	public static void main(String[] args) {
		Util.println(new _004_Largest_Palindrome().run());
	}

	@Override
	public int run() {
		return getLargestPalindrome();
	}
	private int getLargestPalindrome(){
		int largestPalindrome = 0;
		for(int i = LARGEST_THREE_DIGITS; i >= SMALLEST_THREE_DIGITS; i--){
			for( int j = LARGEST_THREE_DIGITS; j >= SMALLEST_THREE_DIGITS; j--){
				int result = i * j;
				if(Util.isNumberPalindrome(result) && result > largestPalindrome)
					largestPalindrome = result;
			}
		}
		return largestPalindrome;
	}


}
