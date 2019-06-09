package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersHome extends Page {

    public CareersHome() {
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(@href,'candidates')]")
    private WebElement name;

    @FindBy(xpath = "//a[contains(@href,'recruit')]/button")
    private WebElement recruit;

    public CareersLogin clickLogin() {
        click(loginButton);
        return new CareersLogin();
    }

    public String getName(){
        return name.getText();
    }

    public CareersRecruitForm clickRecriut(){
        click(recruit);
        return new CareersRecruitForm();
    }

}