package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyJobs extends Page {
    @FindBy(xpath = "//a[@href='/positions/4']//h4")
    private WebElement positionApplied;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement candidate;

    public String getPositionTitle() {
        return positionApplied.getText();
    }

    public ProfilePage clickUserName() {
        click(candidate);
        return new ProfilePage();
    }


}
