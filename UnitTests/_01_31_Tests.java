import Project_Euler_Solutions_in_Java.Utils.Util;
import Project_Euler_Solutions_in_Java._01_31.*;
import org.junit.*;
class _01_31_Tests {
    public static void main(String[] args){
        Util.println("Running Euler Problems #01-31...");
        _01_31_Tests tests = new _01_31_Tests();
        tests._001_Test();
        tests._002_Test();
        tests._003_Test();
        tests._004_Test();
        tests._005_Test();
        tests._006_Test();
        tests._007_Test();
        tests._008_Test();
        tests._009_Test();
        tests._010_Test();
        Util.println("10/10 tests passed.");
    }
    @Test
    void _001_Test() {
        int expectedAnswer = 233168;
        int actualAnswer = new _001_Multiple_3_5().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _002_Test() {
        int expectedAnswer = 4613732;
        int actualAnswer = new _002_even_fibonacci().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _003_Test() {
        long expectedAnswer = 6857;
        long actualAnswer = new _003_prime_number().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _004_Test() {
        int expectedAnswer = 906609;
        int actualAnswer = new _004_Largest_Palindrome().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _005_Test() {
        int expectedAnswer = 232792560;
        int actualAnswer = new _005_smallest_multiple().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }@Test
    void _006_Test() {
        int expectedAnswer = 25164150;
        int actualAnswer = new _006_Sum_Square_Diff().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _007_Test() {
        int expectedAnswer = 104743;
        int actualAnswer = new _007_mille_prime_number().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _008_Test() {
        long expectedAnswer = 23514624000L;
        long actualAnswer = new _008_adjacent_numbers().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _009_Test() {
        long expectedAnswer = 31875000;
        long actualAnswer = new _009_pythagrean_triplet().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
    @Test
    void _010_Test() {
        long expectedAnswer = 142913828922L;
        long actualAnswer = new _010_summation_of_primes().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }


}