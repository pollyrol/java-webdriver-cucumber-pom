package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {

    public CareersHome(){
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']/button")
    private WebElement loginButton;

    // Post Login web elements items
    @FindBy(xpath = "//a[contains(@href,'/candidates/')]")
    private WebElement usernameLink;

    @FindBy(xpath = "//a[@href='/recruit']/button")
    private WebElement recruitButton;

    public CareersLogin clickLogin(){
        click(loginButton);
        return new CareersLogin();
    }

    public String getFullName(){
        return usernameLink.getText();
    }

    public boolean recruitButtonPresent(){
        return isVisible(recruitButton);
    }

    public CareersRecruit clickRecruit(){
        click(recruitButton);
        return new CareersRecruit();
    }
}
