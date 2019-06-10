package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPosition extends Page {

    @FindBy(xpath = "//label[@for='positionTitle']/../span")
    private WebElement title;

    @FindBy(xpath = "//label[@for='positionDescription']/../span")
    private WebElement description;

    @FindBy(xpath = "//label[@for='positionAddress']/../span")
    private WebElement address;

    @FindBy(xpath = "//label[@for='positionCity']/../span")
    private WebElement city;

    @FindBy(xpath = "//label[@for='positionState']/../span")
    private WebElement state;

    @FindBy(xpath = "//label[@for='positionZip']/../span")
    private WebElement zipcode;

    @FindBy(xpath = "//label[@for='positionDateOpen']/..//span")
    private WebElement dateOpen;

    public String readTitle(){
        return title.getText();
    }

    public String readDescription(){
        return description.getText();
    }

    public String readAddress(){
        return address.getText();
    }

    public String readCity(){
        return city.getText();
    }

    public String readState(){
        return state.getText();
    }

    public String readZipcode(){
        return zipcode.getText();
    }

    public String readDateOpen() {
        return dateOpen.getText();
    }

}
