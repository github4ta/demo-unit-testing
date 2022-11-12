import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WeightCalculatorTest {

    WebDriver driver;
    WeightCalculatorPage page;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new WeightCalculatorPage(driver);
        driver.get(page.URL);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void testWithValidDataIdealResult() {

        // TODO WHEN
        page.fillFormAndClickSubmit("Vasya", "180", "80");
        String actual = page.getResultText();

        // TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_IDEAL, actual);
    }
    @Test
    public void testWithValidDataLessResult() {

        // TODO WHEN
        page.fillFormAndClickSubmit("Vasya", "180", "30");
        String actual = page.getResultText();

        // TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_LESS, actual);
    }
    @Test
    public void testWithValidDataMoreResult() {

        // TODO WHEN
        page.fillFormAndClickSubmit("Vasya", "180", "90");
        String actual = page.getResultText();

        // TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_MORE, actual);
    }
    @Test
    public void testWithValidDataExceedResult() {

        // TODO WHEN
        page.fillFormAndClickSubmit("Vasya", "180", "110");
        String actual = page.getResultText();

        // TODO THEN
        Assert.assertEquals(page.RESULT_TEXT_EXCEED, actual);
    }
}
