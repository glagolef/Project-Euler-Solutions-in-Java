public class _034_Digit_Factorials {
	public static void main(String[] args) {
		System.out.println(new _034_Digit_Factorials().run());
	}
	public int run(){
		int result = 0;	
		int nine_fact = factorial(9);
		for(int i=10; true;i++){
			int df = digit_fact(i);
			if(df==i)
				result+=i;
			if(df+nine_fact<i)
				if((num_digits(i)+1)*nine_fact<i)
					break;	
			}
		return result;
	}
	//avaluates factorial of a number
	private int factorial(int a){
		if(a>1)
			return a*factorial(a-1);
		return 1;
	}
	//returns sum of digit factorials 
	private int digit_fact(int a){
		int result = 0;
		int temp=a;
		do{
			result+= factorial(temp%10);
			temp=temp/10;
		}while(temp>0);
		return result;
	}
	//returns number of digits in a number
	private int num_digits(int x){
		int count=1;
		while (x/10>0){
			x/=10;
			count++;
		}
		return count;
	}
}