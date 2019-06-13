package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static support.TestContext.getData;
import static support.TestContext.getDriver;

public class HerokuRecruit extends Page {

    @FindBy(xpath="(//a[contains(@href, 'new_position')])[2]")
    private WebElement newPositionBtn;

    @FindBy(xpath="//div[@class='row']")
    private WebElement positionsList;

    @FindBy(xpath="//a[contains(@href, 'positions')]/h4[@class='card-title']")
            //div[@id='shuffle']//h4[@class='position-name']")
    private WebElement allPostedPositions;

    public void newPositionClick() {
        click(newPositionBtn);
    }

    public boolean isDisplayed() throws FileNotFoundException {
        return allPostedPositions.getText().contains(getData("heroku").get("positionTitle"));
    }

    public String lastAddedPosition () {
        List<WebElement> allPostedPositionsList = getDriver().findElements(By.xpath("//a[contains(@href, 'positions')]/h4[@class='card-title']"));
        System.out.println("last position: " + allPostedPositionsList.size());
        int lastPositionIndex = allPostedPositionsList.size() - 1;
        System.out.println("Actual: " + allPostedPositionsList.get(lastPositionIndex).getText());
        return (allPostedPositionsList.get(lastPositionIndex).getText());
    }
}
