package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getWait;

public class ProfilePage {
    @FindBy(xpath = "//label[@for='candidateLastName']/../span")
    private WebElement lastName;

    @FindBy(xpath = "//label[@for='candidateEmail']/../span")
    private WebElement email;

    public String getProfileLastName() {
        getWait().until(ExpectedConditions.visibilityOf(lastName));
        System.out.println(lastName.getText());
        return lastName.getText();
    }

    public String getProfileEmail() {
        getWait().until(ExpectedConditions.visibilityOf(email));
        System.out.println(email.getText());
        return email.getText();
    }
}
