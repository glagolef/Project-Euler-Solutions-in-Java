package Project_Euler_Solutions_in_Java._01_31;
import Project_Euler_Solutions_in_Java.Utils.Util;

public class _005_smallest_multiple {
/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public static void main(String[] args) {
	long start=System.currentTimeMillis();
	Util.println("Result = " + new _005_smallest_multiple().run());
	long end=System.currentTimeMillis();
	Util.println("Total time: " + (end - start) * 0.001 + " s");
}
	public int run () {
		final int NINETEEN = 19;
		for (int i = 2520; true ; i+=20){
			for(int j = 10; j <= NINETEEN; j++){
				if(!Util.isIntMultiple(i, j)){
					break;
				} else if(j == NINETEEN){
					return i;
				}
			}
		}
	}

}
