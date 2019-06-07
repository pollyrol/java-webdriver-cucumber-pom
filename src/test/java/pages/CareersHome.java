package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {

    public CareersHome() {
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    public CareersLogin clickLogin() {
        click(loginButton);
        return new CareersLogin();
    }

}
