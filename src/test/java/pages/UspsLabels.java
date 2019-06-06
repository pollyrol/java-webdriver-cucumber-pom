package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getWait;

public class UspsLabels extends Page {

    @FindBy(xpath = "//button[@id='btn-submit']")
    private WebElement signIn;

    @FindBy(xpath = "//span[@id='error-username']")
    private WebElement usernameError;

    @FindBy(xpath = "//a[@id='sign-up-button']")
    private WebElement signUp;

    public String getSignUpText() {
        return signUp.getText();
    }

    public void clickSignIn() {
        click(signIn);
    }

    public boolean usernameErrorVisible() {
        getWait().until(ExpectedConditions.visibilityOf(usernameError));
        return usernameError.isDisplayed();
    }


}
