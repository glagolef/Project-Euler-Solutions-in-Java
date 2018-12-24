package Project_Euler_Solutions_in_Java._01_31;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class _026_Reciprocal_Cycles {
	//Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
	public static void main(String[] args) {
		System.out.println(new _026_Reciprocal_Cycles().run());
	}
	private int run(){
		int max = 0;
		int maxN = 0;
//		 result = result.setScale(50, RoundingMode.DOWN);
		for(double i = 2; i<1000; i++){
			BigDecimal result = BigDecimal.ONE.divide(BigDecimal.valueOf(i), 10000, RoundingMode.DOWN);
			String str = result.toString();
			if (str.length()>10){
				int cycle = longestCycle(str);
				if(max<cycle){
					max = cycle;
					maxN = (int) i;
					System.out.println("1/" + maxN + " , " + cycle + " : "+ str);
				}
			}
		}
		return maxN;
	}
	// 0. 1231-confirmed-231-checking-231
	public int longestCycle(String num){
		int cycle = 1;
		char first = num.charAt(num.length()-2);
//		String temp ="" + first;
		boolean confirmed = true;
//		boolean confirmedOnce;
		for(int i = num.length()-3;i>=2; i--)
			if(num.charAt(i)!= first){
//				temp += num.charAt(i);
				cycle ++;
			}else {
				for (int j=0; j<=cycle*3 && confirmed; j++)
					if(num.charAt(i-j)!= num.charAt(num.length()-2-j))
						confirmed = false;
				if(confirmed)
					return cycle;
				else{
					confirmed=true;
					cycle ++;
//					temp += num.charAt(i);
				}
			}
		return 0;
	}
}
