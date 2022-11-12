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
        Util.waiter();

        By byInputName = By.xpath(xpathInputName);
        WebElement elementInputName = driver.findElement(byInputName);
        By byInputHeight = By.xpath(xpathInputHeight);
        WebElement elementInputHeight = driver.findElement(byInputHeight);
        By byInputWeight = By.xpath(xpathInputWeight);
        WebElement elementInputWeight = driver.findElement(byInputWeight);
        By byInputGenderMan = By.xpath(xpathInputGenderMan);
        WebElement elementInputGenderMan = driver.findElement(byInputGenderMan);
        By byButtonSubmit = By.xpath(xpathButtonSubmit);
        WebElement elementButtonSubmit = driver.findElement(byButtonSubmit);


        elementInputName.sendKeys("Vasia");
        elementInputHeight.sendKeys("180");
        elementInputWeight.sendKeys("80");
        elementInputGenderMan.click();

        Util.waiter();
        elementButtonSubmit.click();

        // TODO THEN
        // Assert.assertEquals(expected, actual);
        driver.quit();
    }
}
