package pages;

import cucumber.api.java8.Pa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersMyJobs extends Page {

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement username;

    @FindBy(xpath = "//li//h4")
    private WebElement jobTitle;

    @FindBy(xpath = "//li")
    private List<WebElement> positions;

    public String getUser() {
        waitForClickable(username);
        return username.getText();
    }

    public WebElement getJobTitle() {
        waitForClickable(jobTitle);
        return jobTitle;
    }

    public boolean isPositionApplied() {
        return existsElement(getIdx());
    }




}
