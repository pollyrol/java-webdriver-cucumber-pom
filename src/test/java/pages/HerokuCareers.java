package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HerokuCareers extends Page {

    //TODO: rewrite using cascade approach

    public HerokuCareers() {
        setUrl("https://skryabin-careers.herokuapp.com");
    }

    @FindBy(xpath="//*[@class='position-name'][text()='Senior Automation Engineer']")
    private WebElement position1;

    @FindBy(xpath="//*[@class='position-name'][text()='VP, Development']")
    private WebElement position2;
  
    @FindBy(xpath="//*[contains(@class, 'sign-in')]/..")
    private WebElement loginBtn;
  
    public void positionCLick()
  {
    click(position1);
  }

    public void loginBtnClick()
    {
        loginBtn.click();
    }

    public void positionClick(String scenario) {
        switch (scenario) {
            case "logged in":
                click(position2);
                break;
            case "not logged in":
                click(position1);
                break;
    }
  }
  


}