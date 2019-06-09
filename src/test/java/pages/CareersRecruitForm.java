package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
       return allPositions.getText();
    }





}
