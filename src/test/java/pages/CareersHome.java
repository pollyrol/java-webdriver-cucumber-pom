package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {

    public CareersHome() {
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[text()='Owen Kelley']")
    private WebElement nameRecruter;

    @FindBy(xpath = "//button[contains(text(),'Recruit')]")
    private WebElement recruit;

    @FindBy(xpath = "//a[contains(@href, 'new_candidate')]")
    private WebElement apply;


    public CareersLogin clickLogin() {
        click(loginButton);
        return new CareersLogin();
    }

    public String getUserName() {
        return nameRecruter.getText();
    }

    public CareersRecruit clickRecruit() {
        click(recruit);
        return new CareersRecruit();
    }


}
