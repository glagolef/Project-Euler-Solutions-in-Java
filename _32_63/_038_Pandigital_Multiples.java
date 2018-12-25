package Project_Euler_Solutions_in_Java._32_63;

import java.util.Arrays;

/**
 * Created by glagolef on 25/12/2018.
 * Take the number 192 and multiply it by each of 1, 2, and 3:

 192 × 1 = 192
 192 × 2 = 384
 192 × 3 = 576
 By concatenating each product we get the 1 to 9 pandigital, 192384576.
 We will call 192384576 the concatenated product of 192 and (1,2,3)

 The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,
 giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

 What is the largest 1 to 9 pandigital 9-digit number that can be formed
 as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
public class _038_Pandigital_Multiples {
    final int NINE = 9;
    final String SORTED_PANDIGITAL = "123456789";
    public static void main(String[] args) {

        System.out.println(new _038_Pandigital_Multiples().run());
    }
    public int run (){
        int result = 0;
        for ( int i = 9000, thisResult =1; i<9876; i++){
            thisResult = formPandigital(i);
            if (result<thisResult){
                result = thisResult;
            }
        }
        return result;
    }
    public int formPandigital (int num){
        StringBuilder result = new StringBuilder();
        for(int i = 1, toAdd = num * i; result.length() <NINE; i++, toAdd = num * i){
            result.append(toAdd);
        }
        if(!isPandigital(result.toString())){
            return 0;
        }
        return Integer.parseInt(result.toString());

    }
    public boolean isPandigital(String num){
        char[] stringToChar = num.toCharArray();
        Arrays.sort(stringToChar);
        StringBuilder sb = new StringBuilder();
        sb.append(stringToChar);
        return sb.toString().equals(SORTED_PANDIGITAL);
    }
}
