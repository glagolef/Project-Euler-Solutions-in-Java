package Project_Euler_Solutions_in_Java._01_31;
import java.util.Arrays;
/*
 * A permutation is an ordered arrangement of objects. 
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. 
 * The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class _024_lexicographic_permutations {
	public static void main(String[] args) {
		System.out.println(new _024_lexicographic_permutations().run());
	}
	private int run(){
		String number ="0123456789";
		for(int i=1; i<1000000;i++)
			number = nextPerm(number);
		return Integer.parseInt(number);
	}
	public String nextPerm(String prevPerm){
		String next ="";
		int i=prevPerm.length()-1;
		//finds the next biggest element to be changed
		while((int)prevPerm.charAt(i)-'0'<(int)prevPerm.charAt(i-1)-'0')
			i--;
		String temp1 = prevPerm.substring(0, i-1);
		String temp2 = swapAndSort(prevPerm.substring(i-1));
		next =  temp1+ temp2;
		System.out.println(next);
		return next;
	}
	public String swapAndSort( String string){
		int swapWith = string.length()-1;
		while ((int)string.charAt(swapWith)-'0'<(int) string.charAt(0)-'0')
			swapWith --;
		String temp = "";
		temp += string.charAt(swapWith); 
		string = string.replace(temp,"");
		char[] chars = string.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
		return temp+sorted;
	}
}
