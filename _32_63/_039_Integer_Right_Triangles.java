package Project_Euler_Solutions_in_Java._32_63;

import java.util.HashMap;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
 * there are exactly three solutions for p = 120.
 * {20,48,52}, {24,45,51}, {30,40,50}
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class _039_Integer_Right_Triangles {
    public static void main(String[] args) {
        System.out.println(new _039_Integer_Right_Triangles().run());
    }
    public int run (){
        int result = getMaxNumberOfSolutions();
        return result;
    }
    private int getMaxNumberOfSolutions(){
        int maxSolutions = 2;
        int maxResult = 120;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int a = 1; a <500; a++ ){
            for( int b = a; b >= 1; b--){
                int c = getCFromAnB(a,b);
                if(c < a){
                    continue;
                }
                int sum = getP(a,b,c);
                if (sum > 1000){
                    continue;
                }
                if(hm.containsKey(sum)){
                    int newVal = hm.get(sum) + 1;
                    hm.replace(sum, newVal);
                    if(newVal>= maxSolutions) {
                        maxResult = sum;
                        maxSolutions = newVal;
                    }
                } else {
                    hm.put((int) sum, 1);
                }
            }
        }
        return maxResult;
    }
    private int getCFromAnB(int a, int b){
        double result = Math.sqrt(a * a + b * b);
        return result % 1 == 0 ? (int) result : 0;
    }
    private int getP(int a, int b, int c) {
        return a + b + c;
    }
}
