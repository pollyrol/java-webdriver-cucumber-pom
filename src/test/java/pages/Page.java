package pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;
import static support.TestContext.getWait;

public class Page {

    private String url;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void open() {
        getDriver().get(url);
    }

    protected void clickWithJS(WebElement element) {
        getExecutor().executeScript("arguments[0].click();", element);
    }

    protected void click(WebElement element) {
        waitForClickable(element);
        try {
            element.click();
        } catch (WebDriverException e) {
            clickWithJS(element);
        }
    }

    protected boolean isVisible(WebElement pElement){
        return pElement.isDisplayed();
    }

    public static HashMap<String, String> loadYamlData(String filename) throws FileNotFoundException{
        Yaml yaml = new Yaml();
        InputStream datafileReader = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/data/" + filename));
        return yaml.load(datafileReader);
    }

    private void waitForClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }


}
