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
        String expected = "© 2001—2022 Onlíner";

        // TODO WHEN
        driver.get(url);
        WebElement element = driver.findElement(By.xpath(xpath));
        Util.waiter();
        String actual = element.getText();

        // TODO THEN
        Assert.assertEquals(expected, actual);
        driver.quit();
    }
    @Test
    public void testOpenBaraholkaPage() {

        // TODO GIVEN
        // open onliner.by
        // найти и click on Барахол
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://www.onliner.by";
        String xpathBaraholkaLink = "//a[@href='https://baraholka.onliner.by/']";
        String xpathBaraholkaTitle = "//h1[@class='m-title-i']";
        String expected = "Барахолка";
        driver.get(url);

        // TODO WHEN
        // отыскать веб элемент заголовок страницы Барахолка
        // получить текст из веб элемента
        WebElement elementBaraholkaLink = driver.findElement(By.xpath(xpathBaraholkaLink));
        elementBaraholkaLink.click();
        Util.waiter();
        WebElement elementBaraholkaTitle = driver.findElement(By.xpath(xpathBaraholkaTitle));
        String actual = elementBaraholkaTitle.getText();

        // выполнить проверку текстов
        Assert.assertEquals(expected, actual);
        driver.quit();
    }
}
