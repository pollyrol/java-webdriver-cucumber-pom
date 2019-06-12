package pages;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getData;

public class HerokuNewCandidate extends Page {

    @FindBy(xpath = "//label[@for='candidateFirstName']/../input")
    private WebElement firstNameField;
    @FindBy(xpath = "//label[@for='candidateLastName']/../input")
    private WebElement lastNameField;
    @FindBy(xpath = "//label[@for='candidateEmail']/../input")
    private WebElement emailField;
    @FindBy(xpath = "//label[@for='candidatePassword']/../input")
    private WebElement passwordField;
    @FindBy(xpath = "//label[@for='candidateConfirmPassword']/../input")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//label[@for='candidateSummary']/../textarea")
    private WebElement summaryField;
    @FindBy(xpath = "//label[@for='candidateAddress']/../input")
    private WebElement streetField;
    @FindBy(xpath = "//label[@for='candidateCity']/../input")
    private WebElement cityField;
    @FindBy(xpath = "//label[@for='candidateState']/../select")
    private WebElement stateDropdown;
    @FindBy(xpath = "//label[@for='candidateZip']/../input")
    private WebElement zipField;
    @FindBy(xpath = "//button[@id='candidateSubmit']")
    private WebElement submitBtn;

    public HerokuNewCandidate fillRequiredFields(HashMap hashMap) throws FileNotFoundException {

        firstNameField.sendKeys(getData("heroku").get("firstName"));
        lastNameField.sendKeys(getData("heroku").get("lastName"));
        emailField.sendKeys(getData("heroku").get("email"));
        passwordField.sendKeys(getData("heroku").get("password"));
        confirmPasswordField.sendKeys(getData("heroku").get("password"));
        summaryField.sendKeys(getData("heroku").get("summary"));
        streetField.sendKeys(getData("heroku").get("street"));
        cityField.sendKeys(getData("heroku").get("city"));
        new Select(stateDropdown).selectByValue(getData("heroku").get("state"));
        zipField.sendKeys(getData("heroku").get("zip"));
        return this;
    }

    public HerokuMyJobs submitClick() {
        click(submitBtn);
        return new HerokuMyJobs();
    }

}