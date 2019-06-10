package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;

import static support.TestContext.getData;

public class HerokuNewPosition extends Page {

    @FindBy(xpath = "//input[contains(@placeholder, 'position Title')]")
    private WebElement titleField;

    @FindBy(xpath = "//textarea[contains(@placeholder, 'Description')]")
    private WebElement descriptionField;

    @FindBy(xpath = "//label[@for='positionAddress']/../input")
    private WebElement streetField;

    @FindBy(xpath = "//label[@for='positionCity']/../input")
    private WebElement cityField;

    @FindBy(xpath = "//label[contains(@for, 'positionZip')]/../input")
    private WebElement zipField;

    @FindBy(xpath="//input[@id='positionDateOpen']")
    private WebElement dateOpenField;

    @FindBy(xpath = "//div[contains(@class, 'today-button')]")
    private WebElement todayBtn;

    @FindBy(xpath = "//label[contains(@for,'State')]/../select")
    private WebElement selectStateDropdown;

    @FindBy(xpath="//button[@id='positionSubmit']")
    private WebElement submitBtn;

    public void fillNewPositionFields() throws FileNotFoundException {
        titleField.sendKeys(getData("heroku").get("positionTitle"));
        descriptionField.sendKeys(getData("heroku").get("positionDescription"));
        streetField.sendKeys(getData("heroku").get("positionAddress"));
        cityField.sendKeys(getData("heroku").get("positionCity"));
        click(selectStateDropdown);
        new Select(selectStateDropdown).selectByValue(getData("heroku").get("positionState"));
        zipField.sendKeys(getData("heroku").get("positionZip"));
        click(dateOpenField);
        click(todayBtn);
        click(submitBtn);
    }





}
