package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersRecruit extends Page {

    @FindBy(xpath = "//a[@href='/new_position']")
    private WebElement newPositionButton;

    @FindBy(xpath = "//a[@href='/']")
    private WebElement careersButton;

    public CareersOpenPosition clickNewPosition() {
        click(newPositionButton);
        return new CareersOpenPosition();
    }

    public CareersHome clickCareers() {
        click(careersButton);
        return new CareersHome();
    }

}
