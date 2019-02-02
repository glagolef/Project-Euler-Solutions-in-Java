import Project_Euler_Solutions_in_Java.Utils.Util;
import Project_Euler_Solutions_in_Java._01_31.*;
import org.junit.*;
class _01_31_Tests {
    public static void main(String[] args){
        _01_31_Tests tests = new _01_31_Tests();
        tests._001_Test();
        tests._002_Test();
        tests._003_Test();
        Util.println("4/4 tests passed.");
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
        int expectedAnswer = 4613732;
        int actualAnswer = new _004_Largest_Palindrome().run();
        Assert.assertEquals(actualAnswer,expectedAnswer);
    }
}