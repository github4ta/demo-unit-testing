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
        By byXpath = By.xpath(xpath);
        WebElement element = driver.findElement(byXpath);
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

    @Test
    public void testOpenOnlinerLoginPage() {
        // TODO GIVEN
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://www.onliner.by";
        String xpathButtonGoToLoginPage = "//*[@id='userbar']/div[1]/div/div/div[1]";
        String xpathButtonLogin = "//*[@id='auth-container']/div/div[2]/div/form/div[3]/button";
        driver.get(url);
        Util.waiter();
        By byXpathButtonGoToLoginPage = By.xpath(xpathButtonGoToLoginPage);
        WebElement elementButtonGoToLoginPage = driver.findElement(byXpathButtonGoToLoginPage);
        elementButtonGoToLoginPage.click();
        Util.waiter();

        String expectedErrorMessageUserName="Укажите ник или e-mail";
        String expectedErrorMessagePassword="Укажите пароль";

        // TODO WHEN
        By byXpathButtonLogin = By.xpath(xpathButtonLogin);
        WebElement elementButtonLogin = driver.findElement(byXpathButtonLogin);
        elementButtonLogin.click();
        Util.waiter();

        String xpathErrorMessageUserName = "//*[@id='auth-container']/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div";
        By byXpathErrorMessageUserName = By.xpath(xpathErrorMessageUserName);
        WebElement elementErrorMessageUserName = driver.findElement(byXpathErrorMessageUserName);


        String xpathErrorMessagePassword = "//*[@id='auth-container']/div/div[2]/div/form/div[2]/div/div/div[2]/div";
        By byXpathErrorMessagePassword = By.xpath(xpathErrorMessagePassword);
        WebElement elementErrorMessagePassword = driver.findElement(byXpathErrorMessagePassword);

        String actualErrorMessageUserName=elementErrorMessageUserName.getText();
        String actualErrorMessagePassword=elementErrorMessagePassword.getText();



        // TODO THEN
        Assert.assertEquals(expectedErrorMessageUserName, actualErrorMessageUserName);
        Assert.assertEquals(expectedErrorMessagePassword, actualErrorMessagePassword);
        Util.waiter();
        driver.quit();
    }
}
