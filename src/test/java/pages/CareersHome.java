package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersHome extends Page {

    public CareersHome() {
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement nameUser;

    @FindBy(xpath = "//button[contains(text(),'Recruit')]")
    private WebElement recruit;

    @FindBy(xpath = "//li[contains(@style,'z-index: 0')]//h4")
    private WebElement lastPosition;


    public CareersLogin clickLogin() {
        click(loginButton);
        return new CareersLogin();
    }

    public String getUserName() {
        return nameUser.getText();
    }

    public CareersRecruit clickRecruit() {
        click(recruit);
        return new CareersRecruit();
    }

    public CareersPositionDetails clickLastPosition() {
        click(lastPosition);
        return new CareersPositionDetails();
    }


}
