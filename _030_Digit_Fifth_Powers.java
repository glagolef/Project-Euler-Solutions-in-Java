
public class _030_Digit_Fifth_Powers {
		public static void main(String[] args) {
			System.out.println(new _030_Digit_Fifth_Powers().run());
		}
		private int run(){
			int result = 0;
			// If a number has at least n >= 7 digits, then even if every digit is 9,
			// n * 9^5 is still less than the number (which is at least 10^n).			
			for (int i = 2; i<1000000; i++){
				int calc=sumOfN(i);
				result+=(i==calc)?calc:0;
				System.out.println(i + " : " + calc);
			}

			return result;
		}
		private int sumOfN(int n){
			int calc=0;
			while(n>0){
				calc+=(int)Math.pow(n%10, 5);
				n/=10;
			}
			return calc;
		}

	}