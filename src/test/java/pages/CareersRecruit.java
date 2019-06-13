package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareersRecruit extends Page {

    @FindBy(xpath="//a[@href='/new_position'][1]")
    private WebElement newPosition;

    @FindBy(xpath="//a[contains(@href, '/positions')]/h4")
    private List<WebElement> positions;

    public CareersPosition clickNewPosition() {
        click(newPosition);
        return new CareersPosition();
    }

    public String getLastPositionTitle() {
        int indexOfLastElement = positions.size() - 1;
        return positions.get(indexOfLastElement).getText();
    }



}
