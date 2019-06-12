package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HerokuCareers extends Page {

    //TODO: rewrite using cascade approach

    public HerokuCareers() {
        setUrl("https://skryabin-careers.herokuapp.com");
    }

    @FindBy(xpath = "//*[@class='position-name'][text()='Senior Automation Engineer']")
    private WebElement position1;

    @FindBy(xpath = "//*[@class='position-name'][text()='VP, Development']")
    private WebElement position2;

    @FindBy(xpath = "//*[contains(@class, 'sign-in')]/..")
    private WebElement loginBtn;

    @FindBy(xpath="//button[contains(text(),'Logout')]")
    private WebElement logoutBtn;

    @FindBy(xpath="//*[@class='position-name']")
    private WebElement allMyJobs;

    @FindBy(xpath="//span[@class='logout-box']/..")
    private WebElement header;

    @FindBy(xpath="//button[contains(text(),'Careers')]")
    private WebElement carreersBtn;

    @FindBy(xpath="//button[contains(text(),'My Jobs')]")
    private WebElement myCareers;

    @FindBy(xpath="//a[contains(@href, 'recruit')]/button")
    private WebElement recruitBtn;

    public void carreersClick() {
        click(carreersBtn);
    }

    public void myJobsClick() {
        click(myCareers);
    }

    public void recruitBtnClick() { click(recruitBtn); }

    public HerokuPosition positionCLick() {
        click(position1);
        return new HerokuPosition();
    }

    public HerokuLogin loginBtnClick() {
        click(loginBtn);
        return new HerokuLogin();
    }

    public HerokuPosition positionClick(String scenario) {
        switch (scenario) {
            case "logged in":
                click(position2);
                break;
            case "not logged in":
                click(position1);
                break;
        }
        return new HerokuPosition();
    }

    public boolean isShown(String position) {
        switch (position.toLowerCase()) {
            case("candidate"):
                return allMyJobs.getText().contains(position);
            case("recruiter"):
                return recruitBtn.isDisplayed();
            case("logout"):
                return logoutBtn.isDisplayed();
        }
        return false;
    }

}