package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;

import static support.TestContext.getUser;

public class CareersLogin extends Page {

    @FindBy(xpath = "//label[@for='loginUsername']/../input")
    private WebElement loginUsername;

    @FindBy(xpath = "//label[@for='loginPassword']/../input")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement submit;


    public CareersLogin fillUsername() throws FileNotFoundException {
        loginUsername.sendKeys(getUser().get("username"));
        return this;
    }

    public CareersLogin fillPassword() throws FileNotFoundException {
        loginPassword.sendKeys(getUser().get("password"));
        return this;
    }

    public CareersHome submit() {
        click(submit);
        return new CareersHome();
    }


}
