import java.math.BigInteger;

public class Twenty_five_mille_dig_fibonacci {
	//What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
	public static void main(String[] args) {
		System.out.println(new Twenty_five_mille_dig_fibonacci().run());
	}
	private int run(){
		BigInteger previous = BigInteger.ZERO;
		BigInteger current = BigInteger.ONE;
		BigInteger temp = null;
		String mille = "1";
		for(int i=1;i<=999;i++)
			mille += "0";
		BigInteger MILLE_DIGS = new BigInteger(mille);
		int index = 1;
		while(current.compareTo(MILLE_DIGS)==-1){
			temp = current;
			current = current.add(previous);
			previous = temp;
			index ++;
			System.out.println(index + ": " + current);
		}
		return index;
	}
}
