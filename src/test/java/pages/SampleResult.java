package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleResult extends Page {

    @FindBy(xpath = "//div[@id='samplePageResult']//section")
    private WebElement result;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement privacy;

    public String getResult() {
        return result.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getPrivacy() {
        return privacy.getText();
    }


}
