package Project_Euler_Solutions_in_Java._01_31;

public class _031_Coin_Sums {

	public static void main(String[] args) {
		final int POUND = 100;
		final int FIFTY = 50;
		final int TWENTY = 20;
		final int TEN = 10;
		final int FIVE = 5;
		final int TWO = 2;	
		int result = 0;
		for (int h = 0; h < 200; h++){
			int tempOne=h;
		for (int i=0; i<100; i++){
			int tempTwo=tempOne + i*TWO;
			for (int j=0; tempTwo<=200 && j<40; j++){
				int tempThree = tempTwo + j*FIVE;
				for(int k = 0;  tempThree<=200 && k<20; k++){
					int tempFour= tempThree + k*TEN;
					for (int l = 0;  tempFour<=200 && l<10; l++){
						int tempFive = tempFour + l*TWENTY;
						for(int m = 0; tempFive<=200 && m < 4; m ++){
							int tempSix = tempFive + m*FIFTY;
							for (int n = 0; tempSix<=200 && n<2; n++){
								int tempSeven = tempSix + n*POUND;
								result+=(tempSeven==200)?1:0;
//								System.out.println(tempSeven + ": " + h+ "x1p + " + i + "x2p + " + j + "x5p + "  + k + "x10p + " 
//										+ l + "x20p + " + m + "x50p + " + n + "x£1");
							}
						}
					}
				}
			}
		}
		}
		System.out.print(result + 8);

		
		
	}
	

}
