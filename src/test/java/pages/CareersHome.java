package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {

    public CareersHome() {
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement name;

    @FindBy(xpath = "//a[@href='/recruit']")
    private WebElement recruitButton;

    public CareersRecruit clickRecruit() {
        click(recruitButton);
        return new CareersRecruit();
    }

    public CareersLogin clickLogin() {
        click(loginButton);
        return new CareersLogin();
    }

    public String getUserName() {
        return name.getText();
    }

}
