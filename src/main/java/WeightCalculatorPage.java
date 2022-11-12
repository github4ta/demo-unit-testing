import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeightCalculatorPage {

    WebDriver driver;
    public final String URL = "https://svyatoslav.biz/testlab/wt/index.php";
    private String xpathInputName = "//input[@name='name']";
    private String xpathInputHeight = "//input[@name='height']";
    private String xpathInputWeight = "//input[@name='weight']";
    private String xpathInputGenderMan = "//input[@value='m']";
    private String xpathButtonSubmit = "//input[@type='submit']";
    private String xpathResultText = "//tbody/tr[2]/td[2]";
    public final String RESULT_TEXT_IDEAL = "Идеальная масса тела";
    public final String RESULT_TEXT_LESS = "Слишком малая масса тела";
    public final String RESULT_TEXT_MORE = "Незначительный избыток массы тела";
    public final String RESULT_TEXT_EXCEED ="Значительный избыток массы тела, тучность";

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

    public void fillFormAndClickSubmit(String name, String height, String weight){
        typeName(name);
        typeHeight(height);
        typeWeight(weight);
        selectGenderMan();
        selectButtonSubmit();
    }

}
