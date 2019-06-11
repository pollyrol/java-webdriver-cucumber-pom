package pages;

import java.io.FileNotFoundException;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.TestContext;

import static support.TestContext.getData;

public class HerokuProfile extends Page
{
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

  public boolean isElementExist(String element) throws FileNotFoundException {
    switch (element.toLowerCase()) {
      case "logout":
        return logoutBtn.isDisplayed();
      case "name":
        return header.getText().contains(getData("heroku").get("firstName"));
    }
    return false;
  }
  
  public boolean isShown(String position) {
      switch (position.toLowerCase()) {
          case("candidate"):
              return allMyJobs.getText().contains(position);
          case("recruiter"):
              return recruitBtn.isDisplayed();
      }
      return false;
  }
  
  public void carreersClick() {
    carreersBtn.click();
  }
  
  public void myJobsClick() {
    myCareers.click();
  }

  public void recruitBtnClick() { click(recruitBtn); }

}