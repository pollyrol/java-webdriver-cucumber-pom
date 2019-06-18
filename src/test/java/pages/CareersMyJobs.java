package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CareersMyJobs extends Page {

    @FindBy(xpath = "//span[@class='logout-box']//a")
    private WebElement userName;

    @FindBy(xpath = "//li//h4[@class='position-name']")
    private WebElement position;

    public String getProfile() {
        return userName.getText();

    }

    public CareersMyJobs getPosition() {
        position.isDisplayed();
        return new CareersMyJobs();
    }


}
