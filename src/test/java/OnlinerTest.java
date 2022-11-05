import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlinerTest {

    @Test
    public void testOpenOnlinerWebSite() {
        // TODO GIVEN
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://www.onliner.by";
        String xpath = "";

        // TODO WHEN
        driver.get(url);


    }
}
