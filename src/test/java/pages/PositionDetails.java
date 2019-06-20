package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PositionDetails extends Page {

    @FindBy(xpath = "(//button[text()='Apply'])[2]")
    private WebElement applyButton;

    public CareersProfile clickApply() {
        click(applyButton);
        return new CareersProfile();
    }

}
