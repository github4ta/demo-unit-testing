import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {

    @Test
    public void testOpenOnlinerWebSite() {
        // TODO GIVEN
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://www.onliner.by";
        String xpath = "//div[@class='footer-style__copy']";

        // TODO WHEN
        driver.get(url);
        WebElement element = driver.findElement(By.xpath(xpath));
        Util.waiter();
        String actual = element.getText();

        // TODO THEN
        System.out.println(actual);
        driver.quit();
        Assert.fail();
    }
}
