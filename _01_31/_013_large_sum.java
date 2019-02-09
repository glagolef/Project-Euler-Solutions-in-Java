package Project_Euler_Solutions_in_Java._01_31;
import Project_Euler_Solutions_in_Java.Utils.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;


public class _013_large_sum {
	/*
	 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
	 */
	public static void main(String[] args) {

		System.out.println(new _013_large_sum().run());
	}
	private String path = Util.PATH + "\\src\\";
	private String filename = "p013.txt";
	public String run() {
		BigDecimal bd = BigDecimal.ZERO;
		try {
			String tmp;
			BufferedReader br = new BufferedReader(new FileReader(path + filename));
			while ((tmp = br.readLine()) != null) {
				bd = bd.add(new BigDecimal(tmp));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bd.toString().substring(0, 10);
	}
}
