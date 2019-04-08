import Project_Euler_Solutions_in_Java.Utils.Util;
import Project_Euler_Solutions_in_Java._32_63.*;
import Project_Euler_Solutions_in_Java._32_63._054.*;
import org.junit.Test;
import org.junit.Assert;

class _32_64_Tests {
    public static void main(String[] args) {
        Util.println("Running Euler Problems #32-64...");
        _32_64_Tests tests = new _32_64_Tests();
        tests._040_Test();
        tests._041_Test();
        tests._042_Test();
        tests._043_Test();
        tests._044_Test();
        tests._045_Test();
        tests._046_Test();
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
        tests._058_Test();
        tests._059_Test();
//        tests._060_Test();//365s which includes generating primes
        tests._062_Test();
//        tests._061_Test();//Needs work, 20 mins to get answer
        tests._063_Test();
        Util.println("22/22 tests passed.");
    }
    @Test
    void _063_Test() {
        int expectedAnswer = 49;
        int actualAnswer = new _063_PowerfulDigitalCounts().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _062_Test() {
        long expectedAnswer = 127035954683L;
        int expectedInput = 5;
        long actualAnswer = new _062_CubicPermutations().run(expectedInput);
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _061_Test() {
        int expectedAnswer = 28684;
        int actualAnswer = new _061_CyclicalFigurateNumbers().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _060_Test() {
        long expectedAnswer = 26033;
        long actualAnswer = new _060_PrimePairSets().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _059_Test() {
        int expectedAnswer = 129448;
        int actualAnswer = new _059_XORDecryption().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _058_Test() {
        int expectedAnswer = 26241;
        int actualAnswer = new _058_SpiralPrimes().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _057_Test() {
        int expectedAnswer = 153;
        int actualAnswer = new _057_SquareRootConvergents().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _056_Test() {
        int expectedAnswer = 972;
        int actualAnswer = new _056_PowerfulDigitSum().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _055_Test() {
        long expectedAnswer = 249;
        long actualAnswer = new _055_LychrelNumbers().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _054_Test() {
        int expectedAnswer = 376;
        int actualAnswer = new _054_PokerHands().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _053_Test() {
        int expectedAnswer = 4075;
        int actualAnswer = new _053_CombinatoricSelections().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _052_Test() {
        int expectedAnswer = 142857;
        int actualAnswer = new _052_PermutedMultiple().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _051_Test() {
        int expectedAnswer = 121313;
        int expectedInput = 8;
        int actualAnswer = new _051_PrimeDigitReplacements().run(expectedInput);
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _050_Test() {
        int expectedAnswer = 997651;
        int expectedInput = 1000000;
        int actualAnswer = new _050_Consecutive_Prime_Sum().run(expectedInput);
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _049_Test() {
        String expectedAnswer = "296962999629";
        String actualAnswer = new _049_Prime_Permutations().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _048_Test() {
        String expectedAnswer = "9110846700";
        String actualAnswer = new _048_Self_Powers().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void _047_Test() {
        int expectedAnswer = 134043;
        int actualAnswer = new _047_Distinct_Prime_Numbers().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _046_Test() {
        int expectedAnswer = 5777;
        int actualAnswer = new _046_Goldbachs_Other_Conjecture().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _045_Test() {
        long expectedAnswer = 1533776805;
        long actualAnswer = new _045_TPH_Numbers().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _044_Test() {
        int expectedAnswer = 5482660;
        int actualAnswer = new _044_Pentagon_Numbers().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _043_Test() {
        long expectedAnswer = 16695334890L;
        long actualAnswer = new _043_Substring_Divisibility().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _042_Test() {
        int expectedAnswer = 162;
        int actualAnswer = new _042_Coded_Triangle_Numbers().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _041_Test() {
        int expectedAnswer = 7652413;
        int actualAnswer = new _041_Pandigital_Prime().run();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
    @Test
    void _040_Test() {
        int expectedAnswer = 210;
        int[] expectedInput = {1,10, 100, 1000, 10000, 100000, 1000000};
        int actualAnswer = new _040_Champernownes_Constant().run(expectedInput);
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
}