package Project_Euler_Solutions_in_Java._01_31;

import Project_Euler_Solutions_in_Java.Utils.Util;

public class _001_Multiple_3_5 {
/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
	public static void main(String[] args) {
        Util.println(new _001_Multiple_3_5().run());
	}
    public int run(){
        int answer=0;
        int one_thousand = 1000;
        int three = 3;
        int five = 5;
        for(int i = 1; i <=one_thousand/three; i++){
            answer += i*three;
        }
        for(int j = 1; j <one_thousand/five; j++){
            answer += j*five;
        }
        //remove duplicates
        int multipleOfThreeFive = three*five;
        for(int k = 1; k <= one_thousand/multipleOfThreeFive; k++){
            answer -= k * multipleOfThreeFive;
        }
//        for (int i = 1; i < 1000; i++){
//            answer += Util.isIntMultiple(i, five) || Util.isIntMultiple(i, three) ? i : 0;
//        }
        return answer;
    }
}
