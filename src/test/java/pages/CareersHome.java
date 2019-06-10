package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static support.TestContext.getRecruiter;

public class CareersHome extends Page {

    public CareersHome() throws FileNotFoundException {
        setUrl("https://skryabin-careers.herokuapp.com/");
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(@href,'candidates')]")
    private WebElement name;

    @FindBy(xpath = "//a[contains(@href,'recruit')]/button")
    private WebElement recruit;

    @FindBy(xpath = "//a[contains(@href,'recruit')]/button")
    private WebElement buttonRecruit;


    public String getButtonName(){
        return buttonRecruit.getText();
    }

    public CareersLogin clickLogin() throws FileNotFoundException {
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