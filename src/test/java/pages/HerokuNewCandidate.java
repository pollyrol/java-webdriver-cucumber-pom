package pages;

import java.io.FileNotFoundException;
import java.util.HashMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import support.TestContext;

public class HerokuNewCandidate extends Page
{
  @FindBy(xpath="//label[@for='candidateFirstName']/../input")
  private WebElement firstNameField;
  @FindBy(xpath="//label[@for='candidateLastName']/../input")
  private WebElement lastNameField;
  @FindBy(xpath="//label[@for='candidateEmail']/../input")
  private WebElement emailField;
  @FindBy(xpath="//label[@for='candidatePassword']/../input")
  private WebElement passwordField;
  @FindBy(xpath="//label[@for='candidateConfirmPassword']/../input")
  private WebElement confirmPasswordField;
  @FindBy(xpath="//label[@for='candidateSummary']/../textarea")
  private WebElement summaryField;
  @FindBy(xpath="//label[@for='candidateAddress']/../input")
  private WebElement streetField;
  @FindBy(xpath="//label[@for='candidateCity']/../input")
  private WebElement cityField;
  @FindBy(xpath="//label[@for='candidateState']/../select")
  private WebElement stateDropdown;
  @FindBy(xpath="//label[@for='candidateZip']/../input")
  private WebElement zipField;
  @FindBy(xpath="//button[@id='candidateSubmit']")
  private WebElement submitBtn;
  
  public HerokuNewCandidate() {}
  
  public void fillRequiredFields(HashMap hashMap)
    throws FileNotFoundException
  {
    firstNameField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("firstName") });
    lastNameField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("lastName") });
    emailField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("email") });
    passwordField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("password") });
    confirmPasswordField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("password") });
    summaryField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("summary") });
    streetField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("street") });
    cityField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("city") });
    
    new Select(stateDropdown).selectByValue((String)TestContext.getData("herokuData").get("state"));
    
    zipField.sendKeys(new CharSequence[] { (CharSequence)TestContext.getData("herokuData").get("zip") });
  }
  
  public void submitClick()
  {
    submitBtn.click();
  }
}