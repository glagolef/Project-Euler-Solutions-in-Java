package Project_Euler_Solutions_in_Java.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScratchPad {
    public static void main(String[] args) {
            ScratchPad sp = new ScratchPad();
        sp.testListToArrayConversion();
    }
    {
        Util.println("Hello from a block");//second
    }
    static {
        Util.println("Hello from static block");//first
    }
    public Object run() {
        Util.println("Hello from run method");//third
        long x = 10;
        int y = 2;
        long z = 7;
        y*=x;
//        y = y * x; //kdoes not compile
        y = (int)(y * x);// you have to cast it explicitly
        y*=x; // but don't here
        x = (z = 3); //also is fine
        x *=y;

        return 0;
    }
    private void numericPromotion(){
        int x = 1;
        long y = 2;
        long z = x*y;

        double aDouble = 2.22;
        float aFloat = 3.4F;
//        float aResult = aDouble + aFloat;    // does not compile
        double aResult = aDouble + aFloat;    // aFloat is promoted to a double, result is double

        short aShort = 4;
        aResult = aShort * aFloat / aDouble; // this is fine. aShort is promoted to int to float,
        //then result of multiplication to a double, and result is a double
        {
            //this is a block of code, and is allowed
            Util.println("this is a block of code");
            {
                Util.println("this is a block of code inside another block");
            }
        }
    }
    private void ternaryOperator(){
        boolean t = true;
        Util.println(t ? "Horse" : 210);// this is fine
//        int e = t ? "horse" : 210;  //this is not
        float e = t ? 21.0f : 210;
        double e2 = t ? 22 : 33.33;
    }
    private void testLong(Long l){
        l= 19L;
    }
    private void testForLoop(){
        int x = 0;
        for(long y = 0, z = 4; x < 5 && y < 10; x++, y++){
            Util.print(y + " " );
        }
        Util.print(x);
    }
    private void testWrapperClasses(){
        int a = Integer.parseInt("1");//for primitives
        int b = Integer.valueOf("2");// for wrappers, but this is ok due to autoboxing
        Integer c = Integer.parseInt("3");//for primitives, but this is ok due to autoboxing
        Integer f = Integer.valueOf("4");//for wrappers
    }
    private void testListToArrayConversion(){
        List <Integer> aList = new ArrayList();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        Integer[]array = aList.toArray(new Integer[0]);
        Util.print( Arrays.toString(array));
    }
}
