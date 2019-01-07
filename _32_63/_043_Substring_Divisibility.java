package Project_Euler_Solutions_in_Java._32_63;

import Project_Euler_Solutions_in_Java.Utils.Util;
import java.util.ArrayList;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number
 * because it is made up of each of the digits 0 to 9 in some order,
 * but it also has a rather interesting sub-string divisibility property.
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class _043_Substring_Divisibility {
    public static void main(String[] args) {
        util.Util.print(new _043_Substring_Divisibility().run());
    }
    public long run () {
        ArrayList<String> al = new ArrayList<>();
        Util.getPermutations("9876543210", al);
        long result = 0;
        for(String str : al){
            if(rule1(str)
                    && rule2(str)
                    && rule3(str)
                    && rule4(str)
                    && rule5(str)
                    && rule6(str)
                    && rule7(str)
                    ){
                result += Long.parseLong(str);
            }
        }
        return result;
    }
    public boolean divisibleBy(int dividend, int divisor){
        return dividend % divisor == 0;
    }
    //d2d3d4=406 is divisible by 2
    public boolean rule1(String str){
        return divisibleBy(Character.getNumericValue(str.charAt(3)), 2);
    }
    // d3d4d5=063 is divisible by 3
    public boolean rule2(String str){
        String substr = str.substring(2,5);
        int num = Integer.parseInt(substr);
        return divisibleBy(num, 3);
    }

//     d4d5d6=635 is divisible by 5
    public boolean rule3(String str){
        return divisibleBy(Character.getNumericValue(str.charAt(5)), 5);
    }
//     d5d6d7=357 is divisible by 7
public boolean rule4(String str){
    String substr = str.substring(4,7);
    int num = Integer.parseInt(substr);
    return divisibleBy(num, 7);
}
//     d6d7d8=572 is divisible by 11
public boolean rule5(String str){
    String substr = str.substring(5,8);
    int num = Integer.parseInt(substr);
    return divisibleBy(num, 11);
}
//     d7d8d9=728 is divisible by 13
public boolean rule6(String str){
    String substr = str.substring(6,9);
    int num = Integer.parseInt(substr);
    return divisibleBy(num, 13);
}
////     d8d9d10=289 is divisible by 17
public boolean rule7(String str){
    String substr = str.substring(7,10);
    int num = Integer.parseInt(substr);
    return divisibleBy(num, 17);
}
}
