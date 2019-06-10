package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;

import static support.TestContext.getDriver;
import static support.TestContext.getPosition;

public class CareersNewPosition extends Page {

    @FindBy(xpath = "//label[@for='positionTitle']/../input")
    private WebElement title;

    @FindBy(xpath = "//label[@for='positionDescription']/../textarea")
    private WebElement description;

    @FindBy(xpath = "//label[@for='positionAddress']/../input")
    private WebElement address;

    @FindBy(xpath = "//label[@for='positionCity']/../input")
    private WebElement city;

    @FindBy(xpath = "//label[@for='positionState']/../select")
    private WebElement state;

    @FindBy(xpath = "//label[@for='positionZip']/../input")
    private WebElement zip;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement dateOpen;

//    @FindBy(xpath = "//div[contains(@class,'month-dropdown')]")
//    private WebElement month;

    @FindBy(xpath = "//div[contains(@class,'today-button')]")
    private WebElement today;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement submit;

    public CareersNewPosition fillTitle() throws FileNotFoundException {
        title.sendKeys(getPosition().get("title"));
        return this;
    }

    public CareersNewPosition fillDescription() throws FileNotFoundException {
        description.sendKeys(getPosition().get("description"));
        return this;
    }

    public CareersNewPosition fillAddress() throws FileNotFoundException {
        address.sendKeys(getPosition().get("address"));
        return this;
    }

    public CareersNewPosition fillCity() throws FileNotFoundException {
        city.sendKeys(getPosition().get("city"));
        return this;
    }

    public CareersNewPosition selectState() throws FileNotFoundException {
        forSelectByValue(state, getPosition().get("state"));
        return this;
    }

    public CareersNewPosition fillZip() throws FileNotFoundException {
        zip.sendKeys(getPosition().get("zip"));
        return this;
    }

    public CareersNewPosition fillDate() {
        click(dateOpen);
        click(today);
        return this;
    }

    public CareersNewPosition submit() {
        click(submit);
        return new CareersNewPosition();
    }


}
