package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Utils.Util;

public class _007_mille_prime_number {
	public static void main(String[] args) {
		System.out.println(new _007_mille_prime_number().run());
	}
	public int run(){
//		Seven_mille_prime_number a = new Seven_mille_prime_number();
		int primeNum=0;
		for(int i=1, j=0;j<=10001 ;i++)
			if(Util.isPrime(i)){
				j++;
				primeNum=i;
//				System.out.println(j + "th prime number = " + primeNum);
			}
		return primeNum;
	}

}
