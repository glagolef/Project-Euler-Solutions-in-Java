/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
 * how many letters would be used?
 */
package Project_Euler_Solutions_in_Java._01_31;

public class _017_Number_letter_counts {
	private String words[][];
	public _017_Number_letter_counts(){
		words = new String[][] {{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"},
				{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"}, {"hundred","thousand"}};
	}
	public static void main(String[] args) {
		System.out.println(new _017_Number_letter_counts().run());
	}
	//[first 19][twenty-ninety][hundred, thousand]
	private int run(){
		int count = 0;
		for (int i=1; i<=1000; i++){
			int len = -count;
			String word="";
			int j=i;
			if (j/100!=0){
				if(j/100<10){
					count+=words[0][(j/100)].length();
					word += words[0][j/100];
					count+=words[2][0].length();
					word += words[2][0];
				}
				else {
					count+=words[0][(j/1000)].length();
					word += words[0][j/1000];
					count += words[2][1].length();
					word += words[2][1];
				}
				j = j%100;
				if(j!=0){
					count += "and".length();
					word += "and";
				}
			}
			if (j>19){
				count += words[1][j/10].length();
				word += words[1][j/10];
				if (j%10!=0){
					count += words[0][j%10].length();
					word += words[0][j%10];
				}
			}else {
				count += words[0][j].length();
				word += words[0][j];
			}
			len = count+len;
			System.out.println(i + " = " + word);
		}
		return count;
	}
}