package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getWait;

public class CareersHome extends Page {
    public CareersHome() {
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    public CareersHome clickLogin() {
        click(loginButton);
        return this;  // return this returns the object
    }
}
