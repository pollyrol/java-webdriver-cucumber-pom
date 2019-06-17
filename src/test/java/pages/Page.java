package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;
import static support.TestContext.getWait;

public class Page {

    private String url;
    private String idx;

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

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
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

    public void waitForClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForText(WebElement element, String text) {
        getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    boolean existsElement(String id) {
        try {
            getDriver().findElement(By.id(id));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }



}
