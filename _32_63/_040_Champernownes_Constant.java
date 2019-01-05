package Project_Euler_Solutions_in_Java._32_63;

import java.util.stream.IntStream;

/**
 *  An irrational decimal fraction is created by concatenating the positive integers:
 *
 *  0.123456789101112131415161718192021...
 *
 *  It can be seen that the 12th digit of the fractional part is 1.
 *  If dn represents the nth digit of the fractional part,
 *  find the value of the following expression.
 *
 *  d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class _040_Champernownes_Constant {
    public static void main(String[] args) {
        if(args.length==0){
            args = new String[]{"1","10", "100", "1000", "10000", "100000", "1000000"};
        }
        int[] array = new int[args.length];
        for(int i = 0; i< args.length; i++){
            array[i] = Integer.parseInt(args[i]);
        }
        System.out.println(new _040_Champernownes_Constant().run(array));
    }
    public int run (int[] array){
        int[] results = getChampernownesValues(array);

        return multiplyResults(results);
    }
    public int[] getChampernownesValues(int[] nums){
        int largestNum = nums[nums.length-1];
        int [] results = new int[nums.length];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; sb.length()<largestNum; i ++){
            sb.append(i);
        }
        char[] dst= new char[1];
        for(int j = 0; j<nums.length; j++){
            int index = nums[j];
            sb.getChars(index-1, index, dst, 0);
            results[j] = Character.getNumericValue(dst[0]);
        }
        return results;
    }
    public int multiplyResults(int[] array){
        int product = IntStream.of(array).reduce(1,(p, n) -> p * n );
        return product;
    }
}
