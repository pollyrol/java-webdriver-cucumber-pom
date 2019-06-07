package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SampleForm extends Page {

    public SampleForm() {
        setUrl("https://skryabin.com/webdriver/html/sample.html");
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacy;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement submitButton;

    // name dialog

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
    }

    public void fillConfirmPassword(String value) {
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        click(saveButton);
    }

    public void clickPrivacyPolicy() {
        click(privacy);
    }

    public void submitForm() {
        click(submitButton);
    }




}
