package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class CareersRecruit extends Page {

    @FindBy(xpath = "//a[contains(@href, 'new_position')]//h4")
    private WebElement newPosition;

    @FindAll({
            @FindBy(xpath = "//div[contains(@class,'bg-white')]//h4")
    })
    private List<WebElement> listOfPositions;

    private int latest = listOfPositions.size() - 1;


    public CareersPositionDetails textPosition() {
        click(listOfPositions.get(latest));
        return new CareersPositionDetails();
    }


    public CareersNewPosition clickNewPosition() {
        click(newPosition);
        return new CareersNewPosition();
    }


}
