package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareersOpenPosition extends Page {

    @FindBy(xpath = "//label[@for='positionTitle']/../input")
    private WebElement positionTitle;

    @FindBy(xpath = "//label[@for='positionDescription']/../textarea")
    private WebElement positionDescr;

    @FindBy(xpath = "//label[@for='positionAddress']/../input")
    private WebElement positionAddress;

    @FindBy(xpath = "//label[@for='positionCity']/../input")
    private WebElement positionCity;

//    @FindBy(xpath = "//label[@for='positionState']/..//option[@value='CA']")
    @FindBy(xpath = "//label[@for='positionState']/../select")
    private WebElement positionState;

    @FindBy(xpath = "//label[@for='positionZip']/../input")
    private WebElement positionZip;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement positionDateOpen;

    @FindBy(xpath = "//div[@class='react-datepicker__today-button']")
    private WebElement todayButton;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement positionSubmit;

    public CareersOpenPosition fillNewPosition(String title, String description, String street, String city, String state, String zip) {
        positionTitle.sendKeys("Software Development Engineer in Test");
        positionDescr.sendKeys("This position will work closely with QA and developer teams to build a variety of test automation tools. Your tools will help to find, debug, isolate and resolve defects. You will be working in a collaborative environment with a focus on quality to ensure the delivery of high-quality distributed applications to our customers.");
        positionAddress.sendKeys("4970 El Camino Real");
        positionCity.sendKeys("Los Altos");
        new Select(positionState).selectByValue("CA");
        positionZip.sendKeys("94022");
        click(positionDateOpen);
        click(todayButton);
        click(positionSubmit);
        return this;
    }

}
