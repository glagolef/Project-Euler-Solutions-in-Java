import Project_Euler_Solutions_in_Java.Utils.Util;
import Project_Euler_Solutions_in_Java._32_63.*;
import Project_Euler_Solutions_in_Java._32_63._054.*;
import org.junit.Assert;
import org.junit.Test;

class _32_64_Tests {
    public static void main(String[] args){
        Util.println("Running Euler Problems #01-31...");
        _32_64_Tests tests = new _32_64_Tests();
        tests._047_Test();
        tests._048_Test();
        tests._049_Test();
        tests._050_Test();
        tests._051_Test();
        tests._052_Test();
        tests._053_Test();
        tests._054_Test();
        tests._055_Test();
        tests._056_Test();
        tests._057_Test();
        Util.println("11/11 tests passed.");
    }
    @Test
    void _057_Test() {
        int expectedAnswer = 153;
        int actualAnswer = new _057_SquareRootConvergents().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _056_Test() {
        int expectedAnswer = 972;
        int actualAnswer = new _056_PowerfulDigitSum().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _055_Test() {
        long expectedAnswer = 249;
        long actualAnswer = new _055_LychrelNumbers().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _054_Test() {
        int expectedAnswer = 376;
        int actualAnswer = new _054_PokerHands().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _053_Test() {
        int expectedAnswer = 4075;
        int actualAnswer = new _053_CombinatoricSelections().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }@Test
    void _052_Test() {
        int expectedAnswer = 142857;
        int actualAnswer = new _052_PermutedMultiple().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _051_Test() {
        int expectedAnswer = 121313;
        int actualAnswer = new _051_PrimeDigitReplacements().run(8);
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _050_Test() {
        int expectedAnswer = 997651;
        int actualAnswer = new _050_Consecutive_Prime_Sum().run(1000000);
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _049_Test() {
        String expectedAnswer = "296962999629";
        String actualAnswer = new _049_Prime_Permutations().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _048_Test() {
        String expectedAnswer = "9110846700";
        String actualAnswer = new _048_Self_Powers().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _047_Test() {
        int expectedAnswer = 134043;
        int actualAnswer = new _047_Distinct_Prime_Numbers().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }

}