package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CareersOpenPosition extends Page {

    @FindBy(xpath = "//label[@for='positionTitle']/../input")
    private WebElement positionTitle;

    @FindBy(xpath = "//label[@for='positionDescription']/../textarea")
    private WebElement positionDescr;

    @FindBy(xpath = "//label[@for='positionAddress']/../input")
    private WebElement positionAddress;

    @FindBy(xpath = "//label[@for='positionCity']/../input")
    private WebElement positionCity;

//    @FindBy(xpath = "//label[@for='positionState']/..//option[@value='CA']")
    @FindBy(xpath = "//label[@for='positionState']/../select")
    private WebElement positionState;

    @FindBy(xpath = "//label[@for='positionZip']/../input")
    private WebElement positionZip;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement positionDateOpen;

    @FindBy(xpath = "//div[@class='react-datepicker__today-button']")
    private WebElement todayButton;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement submit;

    public CareersOpenPosition fillNewPosition(Map<String, String> position) {
        positionTitle.sendKeys(position.get("title"));
        positionDescr.sendKeys(position.get("description"));
        positionAddress.sendKeys(position.get("street"));
        positionCity.sendKeys(position.get("city"));
        new Select(positionState).selectByValue(position.get("stateValue"));
        positionZip.sendKeys(position.get("zip"));

//        --- set any date ---
        positionDateOpen.sendKeys(position.get("dateOpen"));

//        --- set today date ---
//        click(positionDateOpen);
//        click(todayButton);

        return this;
    }

    public CareersRecruit submit() {
        click(submit);
        return new CareersRecruit();
    }

}
