import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeightCalculatorPage {

    WebDriver driver;
    String url = "https://svyatoslav.biz/testlab/wt/index.php";
    String xpathInputName = "//input[@name='name']";
    String xpathInputHeight = "//input[@name='height']";
    String xpathInputWeight = "//input[@name='weight']";
    String xpathInputGenderMan = "//input[@value='m']";
    String xpathButtonSubmit = "//input[@type='submit']";
    String xpathResultText = "//tbody/tr[2]/td[2]";
    String expected = "Идеальная масса тела";

    public WeightCalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    public void typeName(String name){
        By byInputName = By.xpath(xpathInputName);
        WebElement elementInputName = driver.findElement(byInputName);
        elementInputName.sendKeys(name);
    }

    public void typeHeight(String height){
        By byInputHeight = By.xpath(xpathInputHeight);
        WebElement elementInputHeight = driver.findElement(byInputHeight);
        elementInputHeight.sendKeys(height);
    }

    public void typeWeight(String weight){
        By byInputWeight = By.xpath(xpathInputWeight);
        WebElement elementInputWeight = driver.findElement(byInputWeight);
        elementInputWeight.sendKeys(weight);
    }

    public void selectGenderMan(){
        By byInputGenderMan = By.xpath(xpathInputGenderMan);
        WebElement elementInputGenderMan = driver.findElement(byInputGenderMan);
        elementInputGenderMan.click();
    }
    public void selectButtonSubmit(){
        By byButtonSubmit = By.xpath(xpathButtonSubmit);
        WebElement elementButtonSubmit = driver.findElement(byButtonSubmit);
        elementButtonSubmit.click();
    }

    public String getResultText(){
        By byResultText = By.xpath(xpathResultText);
        WebElement elementResultText = driver.findElement(byResultText);
        return elementResultText.getText();
    }

    public void myMethod(String name, String height, String weight){
        typeName(name);
        typeHeight(height);
        typeWeight(weight);
        selectGenderMan();
        selectButtonSubmit();
    }

}
