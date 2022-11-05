import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testSum() {
        // TODO GIVEN - ASSEMBLY
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 2;
        int expected = 4;

        // TODO WHEN - ACT
        int actual = calculator.sum(a, b);

        // TODO THEN - ASSERT
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testMultiply() {
        // TODO GIVEN - ASSEMBLY
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 7;
        int expected = 35;

        // TODO WHEN - ACT
        int actual = calculator.multiply(a, b);

        // TODO THEN - ASSERT
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        // TODO GIVEN - ASSEMBLY
        Calculator calculator = new Calculator();
        int a = 13;
        int b = 11;
        int expected = 2;

        // TODO WHEN - ACT
        int actual = calculator.subtract(a, b);

        // TODO THEN - ASSERT
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        // TODO GIVEN - ASSEMBLY
        Calculator calculator = new Calculator();
        int a = 40;
        int b = 5;
        int expected = 8;

        // TODO WHEN - ACT
        int actual = calculator.divide(a, b);

        // TODO THEN - ASSERT
        Assert.assertEquals(expected, actual);
    }
}


