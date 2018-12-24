package Project_Euler_Solutions_in_Java._01_31;

public class _001_Multiple_3_5 {
/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
	public int belowMille(int a){
		
		return a;
	}
	public static void main(String[] args) {		
		int answer=0;
		for(int i = 0, countA=0, countB=0 ; i < 1000 ; i++, countA++, countB++){
			if (countA==3){
				answer+=i;
				countA=0;
				if (countB==5)
					countB=0;
			} 
			else if(countB==5){
				countB=0;
				answer+=i;
			}
//			if (i%3==0)
//				answer+=i;
//			else if (i%5==0)
//				answer+=i;
			
		}
		System.out.println(answer);
	}

}
