package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;

import static support.TestContext.getData;

public class HerokuRecruit extends Page {

    @FindBy(xpath="(//a[contains(@href, 'new_position')])[2]")
    private WebElement newPositionBtn;

    @FindBy(xpath="//div[@class='row']")
    private WebElement positionsList;

    public void newPositionClick() {
        click(newPositionBtn);
    }

    public boolean isDisplayed() throws FileNotFoundException {
        return positionsList.getText().contains(getData("herokuData").get("positionTitle"));
    }


}
