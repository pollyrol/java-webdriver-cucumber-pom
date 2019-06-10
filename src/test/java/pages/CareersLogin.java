package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static support.TestContext.getRecruiter;

public class CareersLogin extends Page {

    @FindBy(xpath = "//label[@for='loginUsername']/../input")
    private WebElement loginUsername;

    @FindBy(xpath = "//label[@for='loginPassword']/../input")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submit;

    public CareersLogin() throws FileNotFoundException {
    }

    public CareersLogin fillUsername(String value) {
        loginUsername.sendKeys(value);
        return this;
    }

    HashMap<String, String> send = getRecruiter();

    public CareersLogin loginFromFile() {
        loginUsername.sendKeys(send.get("Username"));
        loginPassword.sendKeys(send.get("Password"));
        return this;
    }

    public CareersLogin fillPassword(String value) {
        loginPassword.sendKeys(value);
        return this;
    }

    public CareersHome submit() throws FileNotFoundException {
        click(submit);
        return new CareersHome();
    }





}