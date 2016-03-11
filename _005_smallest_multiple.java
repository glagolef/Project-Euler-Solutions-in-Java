
public class _005_smallest_multiple {
/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
	public static void main(String[] args) {
		int twenty = 20;
		int start = 2520;
		int answer=0;
		boolean temp=false;
		for (int i=start; temp==false ; i+=twenty){
			temp=true;
			for (int j=3;j<=twenty && temp==true;j++){
				temp= (i%j==0)?true:false;
				if(temp && j==twenty)
					answer=i;
			}
		}
		System.out.println(answer);
	}
}
