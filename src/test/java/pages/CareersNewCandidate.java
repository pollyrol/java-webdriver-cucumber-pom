package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CareersNewCandidate extends Page {
    @FindBy(xpath = "//label[@for='candidateFirstName']/../input")
    private WebElement firstName;

    @FindBy(xpath = "//label[@for='candidateMiddleName']/../input")
    private WebElement middleName;

    @FindBy(xpath = "//label[@for='candidateLastName']/../input")
    private WebElement lastName;

    @FindBy(xpath = "//label[@for='candidateEmail']/../input")
    private WebElement email;

    @FindBy(xpath = "//label[@for='candidatePassword']/../input")
    private WebElement password;

    @FindBy(xpath = "//label[@for='candidateConfirmPassword']/../input")
    private WebElement confirmPassword;

    @FindBy(xpath = "//label[@for='candidateSummary']/../textarea")
    private WebElement summary;

    @FindBy(xpath = "//label[@for='candidateAddress']/../input")
    private WebElement address;

    @FindBy(xpath = "//label[@for='candidateCity']/../input")
    private WebElement city;

    @FindBy(xpath = "//label[@for='candidateState']/../select")
    private WebElement state;

    @FindBy(xpath = "//label[@for='candidateZip']/../input")
    private WebElement zip;

    @FindBy(xpath = "//button[@id='candidateSubmit']")
    private WebElement submit;

    public CareersNewCandidate fillApplyForm(Map<String, String> candidate) {
        firstName.sendKeys(candidate.get("firstName"));
        middleName.sendKeys(candidate.get("middleName"));
        lastName.sendKeys(candidate.get("lastName"));
        email.sendKeys(candidate.get("email"));
        password.sendKeys(candidate.get("password"));
        confirmPassword.sendKeys(candidate.get("confirmPassword"));
        summary.sendKeys(candidate.get("summary"));
        address.sendKeys(candidate.get("address"));
        city.sendKeys(candidate.get("city"));
        forSelectByValue(state, candidate.get("state"));
        zip.sendKeys(candidate.get("zip"));

        return this;
    }


    public CareersNewCandidate clickSubmit() {
        click(submit);
        return new CareersNewCandidate();
    }




}

