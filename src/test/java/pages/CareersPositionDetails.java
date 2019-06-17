package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPositionDetails extends Page {

    @FindBy(xpath = "//div[contains(@class, 'card-body')]//button")
    private WebElement apply;

    public CareersApply clickApply() {
        waitForClickable(apply);
        click(apply);
        return new CareersApply();
    }



}
