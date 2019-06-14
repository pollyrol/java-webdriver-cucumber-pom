package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static support.TestContext.*;

import static support.TestContext.getCandidate;

public class CareersApply extends Page {

        @FindBy(xpath = "//label[@for='candidateFirstName']/../input")
        private WebElement firstName;

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

        @FindBy(id = "candidateSubmit")
        private WebElement submit;

        public CareersApply fillApplyForm(Map<String, String> candidate) {

            firstName.sendKeys(candidate.get("firstName"));
            lastName.sendKeys(candidate.get("lastName"));
            email.sendKeys(candidate.get("email"));
            password.sendKeys(candidate.get("password"));
            confirmPassword.sendKeys(candidate.get("password"));
            summary.sendKeys(candidate.get("summary"));
            address.sendKeys(candidate.get("address"));
            city.sendKeys(candidate.get("city"));
            new Select(state).selectByValue(candidate.get("state"));
            zip.sendKeys(candidate.get("zip"));
            return this;
        }

        public CareersMyJob clickSubmit() {
            click(submit);
            return new CareersMyJob;
        }









}
