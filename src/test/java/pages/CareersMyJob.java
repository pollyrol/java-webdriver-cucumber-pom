package pages;

import cucumber.api.java8.Pa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersMyJob extends Page {

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement username;

    public String getUser() {
        return username.getText();
    }

}
