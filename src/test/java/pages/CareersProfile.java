package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CareersProfile extends Page {
    @FindBy(xpath = "//label[@for='candidateFirstName']/../input")
    private WebElement firstName;

    @FindBy(xpath = "//label[@for='candidateLastName']/../input")
    private WebElement lastName;

    @FindBy(xpath = "//label[@for='candidateEmail']/../input")
    private WebElement email;

    @FindBy(xpath = "//label[@for='candidatePassword']/../input")
    private WebElement password;

    @FindBy(xpath = "//label[@for='candidateConfirmPassword']/../input")
    private WebElement confPassword;

    @FindBy(xpath = "//label[@for='candidateSummary']/../textarea")
    private WebElement summary;

    @FindBy(xpath = "//label[@for='candidateAddress']/../input")
    private WebElement street;

    @FindBy(xpath = "//label[@for='candidateCity']/../input")
    private WebElement city;

    @FindBy(xpath = "//label[@for='candidateState']/../select")
    private WebElement state;

    @FindBy(xpath = "//label[@for='candidateZip']/../input")
    private WebElement zip;

    @FindBy(xpath = "//button[@id='candidateSubmit']")
    private WebElement submit;

    public CareersProfile fillProfile(Map<String, String> profileInfo) {
        firstName.sendKeys(profileInfo.get("FirstName"));
        lastName.sendKeys(profileInfo.get("LastName"));
        email.sendKeys(profileInfo.get("Email"));
        password.sendKeys(profileInfo.get("Password"));
        confPassword.sendKeys(profileInfo.get("Password"));
        summary.sendKeys(profileInfo.get("Summary"));
        street.sendKeys(profileInfo.get("Street"));
        city.sendKeys(profileInfo.get("City"));
        new Select(state).selectByValue(profileInfo.get("State"));
        zip.sendKeys(profileInfo.get("Zip"));
        return this;
    }

    public MyJobs submitProfile() {
        click(submit);
        return new MyJobs();
    }
}
