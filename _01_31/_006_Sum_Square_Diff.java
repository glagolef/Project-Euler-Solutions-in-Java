package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Utils.Util;

public class _006_Sum_Square_Diff {
	  /*
	   * The sum of the squares of the first ten natural numbers is,
	   * 1^2 + 2^2 + ... + 102 = 385
	   * The square of the sum of the first ten natural numbers is,
	   * (1 + 2 + ... + 10)^2 = 552 = 3025
       * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
	   * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	   * 
	   */
	  private final int MAX_NUM = 100;
	  public static void main (String[] args) {
		  long start=System.currentTimeMillis();
		  Util.println("Result = " + new  _006_Sum_Square_Diff().run());
		  long end=System.currentTimeMillis();
		  Util.println("Total time: " + (end - start) * 0.001 + " s");
	  }
	  public int run(){
		  int sumsq=0;
		  int sqsum=0;

		  for (int i=0; i<=MAX_NUM; i++){
			  sumsq = sumSquare(sumsq, i);
			  sqsum = squareSum(sqsum, i);
		  }
		  return (sumsq - sqsum);
	  }
	  int sumSquare(int sumsq, int num){
		  sumsq+=num;
		  if (num==MAX_NUM)
			  sumsq*=sumsq;
		 return sumsq;
	  }
	  int squareSum(int sqsum, int num){
		  sqsum += num*num;
		  return sqsum;
	  }
	}








	  