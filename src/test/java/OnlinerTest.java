import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OnlinerTest {
    WebDriver driver;

    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
    }

    @After
    public void afterTest() {
        driver.quit();
    }



    @Test
    public void testOpenOnlinerWebSite() {
        // TODO GIVEN
        String url = "http://www.onliner.by";
        String xpath = "//div[@class='footer-style__copy']";
        final String FOOTER_COPY = "© 2001—2022 Onlíner";

        // TODO WHEN
        driver.get(url);
        By byXpath = By.xpath(xpath);
        WebElement element = driver.findElement(byXpath);
        Util.waiter(1);
        String actual = element.getText();

        // TODO THEN
        Assert.assertEquals(FOOTER_COPY, actual);
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
        Util.waiter(3);
        WebElement elementBaraholkaTitle = driver.findElement(By.xpath(xpathBaraholkaTitle));
        String actual = elementBaraholkaTitle.getText();

        // выполнить проверку текстов
        Assert.assertEquals(expected, actual);
        driver.quit();
    }

    @Test
    public void testOpenOnlinerLoginPage() {
        // TODO GIVEN
        String url = "http://www.onliner.by";
        String xpathButtonGoToLoginPage = "//*[@id='userbar']/div[1]/div/div/div[1]";
        String xpathButtonLogin = "//*[@id='auth-container']/div/div[2]/div/form/div[3]/button";
        String expectedErrorMessageUserName="Укажите ник или e-mail";
        String expectedErrorMessagePassword="Укажите пароль";
        String xpathErrorMessageUserName = "//*[@id='auth-container']/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div";
        String xpathErrorMessagePassword = "//*[@id='auth-container']/div/div[2]/div/form/div[2]/div/div/div[2]/div";

        driver.get(url);

        By byXpathButtonGoToLoginPage = By.xpath(xpathButtonGoToLoginPage);
        WebElement elementButtonGoToLoginPage = driver.findElement(byXpathButtonGoToLoginPage);
        elementButtonGoToLoginPage.click();

        // TODO WHEN
        By byXpathButtonLogin = By.xpath(xpathButtonLogin);
        WebElement elementButtonLogin = driver.findElement(byXpathButtonLogin);
        elementButtonLogin.click();

        // TODO NoSuchElementException
        By byXpathErrorMessageUserName = By.xpath(xpathErrorMessageUserName);
        Duration duration = Duration.ofSeconds(1);
        WebElement elementErrorMessageUserName = (new WebDriverWait(driver, duration))
                .until(ExpectedConditions.elementToBeClickable(byXpathErrorMessageUserName));

        By byXpathErrorMessagePassword = By.xpath(xpathErrorMessagePassword);
        WebElement elementErrorMessagePassword = driver.findElement(byXpathErrorMessagePassword);

        String actualErrorMessageUserName=elementErrorMessageUserName.getText();
        String actualErrorMessagePassword=elementErrorMessagePassword.getText();

        // TODO THEN
        Assert.assertEquals(expectedErrorMessageUserName, actualErrorMessageUserName);
        Assert.assertEquals(expectedErrorMessagePassword, actualErrorMessagePassword);
    }
}
