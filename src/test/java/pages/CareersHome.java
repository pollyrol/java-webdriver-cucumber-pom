package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {

    public CareersHome() {
        setUrl("http://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement username;

    @FindBy(xpath = "//a[@href='/recruit']")
    private WebElement recruitButton;

    @FindBy(xpath = "//li[last()]")
    private WebElement lastElement;

    public CareersLogin clickLogin() {
        click(loginButton);
        return new CareersLogin();
    }

    public String getUser() {
        return username.getText();
    }

    public CareersRecruit clickRecruit() {
        click(recruitButton);
        return new CareersRecruit();
    }

    public WebElement getLastElement() {
        return lastElement;
    }
}
