package pages;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getData;

public class HerokuLogin extends Page {

    @FindBy(xpath = "//label[@for='loginUsername']/../input")
    private WebElement usernameField;
    @FindBy(xpath = "//label[@for='loginPassword']/../input")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submitBtn;

    public HerokuLogin fillRequiredFields(HashMap hashMap) throws FileNotFoundException {
        usernameField.sendKeys(getData("heroku").get("email"));
        passwordField.sendKeys(getData("heroku").get("password"));
        return this;
    }

    public HerokuCareers submitClick() {
        click(submitBtn);
        return new HerokuCareers();
    }

    public HerokuLogin fillRecruiterFields(HashMap hashMap) throws FileNotFoundException {
        usernameField.sendKeys(getData("heroku").get("recruiterLogin"));
        passwordField.sendKeys(getData("heroku").get("recruiterPassword"));
        return this;
    }


}