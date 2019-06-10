package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersNewPosition extends Page {

    @FindBy(xpath = "//label[@for='positionTitle']/../input")
    private WebElement title;

    @FindBy(xpath = "//label[@for='positionDescription']/../textarea")
    private WebElement description;

    @FindBy(xpath = "//label[@for='positionAddress']/../input")
    private WebElement address;

    @FindBy(xpath = "//label[@for='positionCity']/../input")
    private WebElement city;

    @FindBy(xpath = "//label[@for='positionState']/../select")
    private WebElement state;

    @FindBy(xpath = "//label[@for='positionZip']/../input")
    private WebElement zipcode;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement dateOpen;

    @FindBy(xpath = "//div[@class='react-datepicker__today-button']")
    private WebElement dateOpenToday;

    //TODO
    /*@FindBy(xpath = "");
    private WebElement dateOpenYear;

    @FindBy(xpath = "");
    private WebElement dateOpenMonth;

    @FindBy(xpath = "");
    private WebElement dateOpenDay;*/

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement submit;

    public CareersNewPosition fillTitle(String title){
        this.title.sendKeys(title);
        return this;
    }

    public CareersNewPosition fillDescription(String description){
        this.description.sendKeys(description);
        return this;
    }

    public CareersNewPosition fillAddress(String address){
        this.address.sendKeys(address);
        return this;
    }

    public CareersNewPosition fillCity(String city){
        this.city.sendKeys(city);
        return this;
    }

    public CareersNewPosition fillState(String state){
        this.state.sendKeys(state);
        return this;
    }

    public CareersNewPosition fillZipcode(String zipcode){
        this.zipcode.sendKeys(zipcode);
        return this;
    }

    public CareersNewPosition selectDateOpenAsToday(){
        click(dateOpen);
        click(dateOpenToday);
        return this;
    }

    public CareersRecruit clickSubmit(){
        click(submit);
        return new CareersRecruit();
    }

}
