package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class CareersOpenPosition extends Page {
    @FindBy(xpath = "//label[contains(text(),'Title')]/following-sibling::input")
    private WebElement title;

    @FindBy(xpath = "//label[contains(text(),'Description')]/following-sibling::textarea")
    private WebElement description;

    @FindBy(xpath = "//label[contains(text(),'Address')]/following-sibling::input")
    private WebElement address;

    @FindBy(xpath = "//label[contains(text(),'City')]/following-sibling::input")
    private WebElement city;

    @FindBy(xpath = "//label[contains(text(),'State')]/following-sibling::select//option[@value='CA']")
    private WebElement state;

    @FindBy(xpath = "//label[contains(text(),'Zip')]/following-sibling::input")
    private WebElement zip;

    @FindBy(xpath = "//input[@id='positionDateOpen']")
    private WebElement dateOpen;

    @FindBy(xpath = "//button[@id='positionSubmit']")
    private WebElement submit;

    public CareersOpenPosition fillTitle(String value){
        title.sendKeys(value);
        return this;
    }

    public CareersOpenPosition fillDescription(String value) {
        description.sendKeys(value);
        return this;
    }

    public CareersOpenPosition fillAddress(String value) {
        address.sendKeys(value);
        return this;
    }

    public CareersOpenPosition fillCity(String value) {
        city.sendKeys(value);
        return this;
    }

//    public CareersOpenPosition fillState() {
//        click(state);
//        return this;
//    }

    public  CareersOpenPosition getFoundItem(String value) {
        click(getDriver().findElement(By.xpath("//label[contains(text(),'State')]/following-sibling::select//option[(text()='" + value +"')]")));
        return this;
    }

    public CareersOpenPosition fillZip(String value) {
        zip.sendKeys(value);
        return this;
    }

    public CareersOpenPosition fillDateOpen(String value) {
        dateOpen.sendKeys(value);
        return this;
    }

    public CareersRecruitForm clickSubmit() {
        click(submit);
        return new CareersRecruitForm();
    }













}
