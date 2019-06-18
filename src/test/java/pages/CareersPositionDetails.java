package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPositionDetails extends Page {

    @FindBy(xpath = "//div[@class='card-body text-left']")
    private WebElement results;

    @FindBy(xpath = "//label[@for='positionTitle']/../span")
    private WebElement title;

    @FindBy(xpath = "//label[@for='positionDescription']/../span")
    private WebElement description;

    @FindBy(xpath = "//label[@for='positionAddress']/../span")
    private WebElement address;

    @FindBy(xpath = "//label[@for='positionCity']/../span")
    private WebElement city;

    @FindBy(xpath = "//label[@for='positionState']/../span")
    private WebElement state;

    @FindBy(xpath = "//label[@for='positionZip']/../span")
    private WebElement zip;

    @FindBy(xpath = "//label[@for='positionDateOpen']/../div/span")
    private WebElement date;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement apply;

    public String getDetails() {
        return results.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getAddress() {
        return address.getText();
    }

    public String getCity() {
        return city.getText();
    }

    public String getState() {
        return state.getText();
    }

    public String getZip() {
        return zip.getText();
    }

    public String getDate() {
        return date.getText();
    }

    public CareersNewPosition clickApply() {
        click(apply);
        return new CareersNewPosition();
    }

}
