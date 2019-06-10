package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getWait;

public class CareersRecruitForm extends Page {
    @FindBy(xpath = "//a[contains(@href,'new_position')]//h4[contains(text(),'New Position')]")
    private WebElement newPosition;

    @FindBy(xpath = "(//a[contains(@href,'/positions')]//h4)[last()]")
    private WebElement allPositions;

    public CareersRecruitForm clickNewPosition(){
        click(newPosition);
        return this;
    }

    public String getAllPositionsList(){
       getWait().until(ExpectedConditions.visibilityOf(allPositions));
       return allPositions.getText();
    }





}
