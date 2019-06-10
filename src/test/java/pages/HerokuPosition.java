package pages;

import org.openqa.selenium.WebElement;

public class HerokuPosition extends Page
{
  @org.openqa.selenium.support.FindBy(xpath="//*[contains(@href, 'new_candidate')]")
  private WebElement applyBtnHeader;
  @org.openqa.selenium.support.FindBy(xpath="(//button[contains(text(),'Apply')])[2]")
  private WebElement applyBtnFooter;
  @org.openqa.selenium.support.FindBy(xpath="//button[@class='btn btn-primary']")
  private WebElement applyBtnLoggedIn;
  
  public HerokuPosition() {}
  
  public void applyBtnClick()
  {
    clickWithJS(applyBtnFooter);
  }
  
  public void applyBtnClick(String scenario) {
    switch (scenario.toLowerCase()) {
    case "logged in": 
      applyBtnLoggedIn.click();
      break;
    case "not logged in": 
      applyBtnFooter.click();
    }
  }
}