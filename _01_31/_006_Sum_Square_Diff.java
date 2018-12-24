package Project_Euler_Solutions_in_Java._01_31;

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
	  public static final int MAX_NUM = 100;
	  public static void main (String[] args) { 
		  _006_Sum_Square_Diff a =  new _006_Sum_Square_Diff();
		  int sumsq=0;
		  int sqsum=0;
		  
		  for (int i=0; i<=MAX_NUM; i++){
			  sumsq = a.sumSquare(sumsq, i);
			  sqsum = a.squareSum(sqsum, i);
		  }
		  System.out.println("sumsq = " + (sumsq));
		  System.out.println("sqsum = " + (sqsum));
		  System.out.println("answer = " + (sumsq-sqsum));
	  }   
	  public int sumSquare(int sumsq, int num){
		  sumsq+=num;
		  if (num==MAX_NUM)
			  sumsq*=sumsq;
		 return sumsq;
	  }
	  public int squareSum(int sqsum, int num){
		  sqsum += num*num;
		  return sqsum;
	  }
	}








	  