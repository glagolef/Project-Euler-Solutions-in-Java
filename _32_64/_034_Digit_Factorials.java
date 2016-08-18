package _32_64;

public class _034_Digit_Factorials {

	public static void main(String[] args) {
		System.out.println(new _034_Digit_Factorials().run());
	}
	public int run(){
		int result = 0;
		
		
		return result;
	}
	private int factorial(int a){
		if(a>1)
			return a*factorial(a-1);
		return a;
	}

}
