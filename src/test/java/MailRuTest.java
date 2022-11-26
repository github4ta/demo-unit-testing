import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailRuTest {
    @Test
    public void TestMailRuSearch(){

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //TODO
        driver.get("https://mail.ru");
        //This won't work
       // driver.switchTo().frame("1670413506316");
        String xpathFrame="//iframe[@class='search-arrow__frame']";
        WebElement iframe = driver.findElement(By.xpath(xpathFrame));
        driver.switchTo().frame(iframe);


        String xpath = "//input[@name='text']";
        By bySearch = By.xpath(xpath);
        WebElement webElementSearch = driver.findElement(bySearch);

        //TODO
        webElementSearch.sendKeys("java");


        //TODO
        //Run search


    }
}
