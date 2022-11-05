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
}
