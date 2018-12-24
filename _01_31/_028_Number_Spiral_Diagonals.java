package Project_Euler_Solutions_in_Java._01_31;
public class _028_Number_Spiral_Diagonals {
//n*n+a*n+b
	public static void main(String[] args) {
		System.out.println(new _028_Number_Spiral_Diagonals().run());
	}
	final int ONE_K_ONE = 1001;
	final int TWO = 2;
	private int run(){

		int result=1;
		int nextInt=1;
		//test
		for(int i=2; i<ONE_K_ONE; i+=TWO)
			for(int j=0; j<4; j++){
				nextInt+=i;
				result += nextInt;
			}
		return result;
	}
}