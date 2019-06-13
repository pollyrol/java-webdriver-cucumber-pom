package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;



public class CareersLogin extends Page {

    @FindBy(xpath = "//label[@for='loginUsername']/../input")
    private WebElement loginUsername;

    @FindBy(xpath = "//label[@for='loginPassword']/../input")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submit;


    public CareersLogin fillUsername(String value) {
        loginUsername.sendKeys(value);
        return this;
    }

    public CareersLogin fillPassword(String value) {
        loginPassword.sendKeys(value);
        return this;
    }

    public CareersHome submit() {
        click(submit);
        return new CareersHome();
    }


}
