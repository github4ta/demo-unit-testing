import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WeightCalculatorTest {
    @Test
    public void testOpenOnlinerWebSite() {
        // TODO GIVEN
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://svyatoslav.biz/testlab/wt/index.php";
        String xpathInputName = "//input[@name='name']";
        String xpathInputHeight = "//input[@name='height']";
        String xpathInputWeight = "//input[@name='weight']";
        String xpathInputGenderMan = "//input[@value='m']";
        String xpathButtonSubmit = "//input[@type='submit']";
        String xpathResultText = "//tbody/tr[2]/td[2]";
        String expected = "Идеальная масса тела";

        // TODO WHEN
        driver.get(url);
        By byXpath = By.xpath(xpath);
        WebElement element = driver.findElement(byXpath);
        Util.waiter();
        String actual = element.getText();

        // TODO THEN
        Assert.assertEquals(expected, actual);
        driver.quit();
    }
}
