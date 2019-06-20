package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

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

    @FindBy(xpath = "//a[@href='/positions/4']//h4")
    private WebElement positionApply;

    @FindBy(xpath = "//a[@href='/positions/4']/../..")
    private WebElement positionApplyBlock;
    //div[@id='shuffle']/li[4]

    @FindBy(xpath = "//a[@href='/positions/4']/../button")
    private WebElement positionApplyCheckmark;

    @FindBy(xpath = "//button[contains(text(),'My Jobs')]")
    private WebElement myJobs;

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

    public PositionDetails selectPosition() {
        click(positionApply);
        return new PositionDetails();
    }

    public CareersHome applyPosition() {
        new Actions(getDriver()).moveToElement(positionApplyBlock).perform();
        click(positionApplyCheckmark);
        return this;
    }

    public String verifyPositionApplied() {
        return positionApplyBlock.getAttribute("class");
    }

    public CareersMyJobs clickMyJobs() {
        click(myJobs);
        return new CareersMyJobs();
    }

}
