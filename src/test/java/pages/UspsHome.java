package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsHome extends Page {

    public UspsHome() {
        setUrl("https://www.usps.com/");
    }

    @FindBy(xpath = "//a[@id='stampButton']")
    private WebElement stamps;

    @FindBy(xpath = "//a[@id='orderButton']")
    private WebElement boxes;

    @FindBy(xpath = "//a[@id='quickMenuButtonShip']")
    private WebElement labels;

    public void clickLabels() {
        click(labels);
    }

    public void clickStamps() {
        stamps.click();
    }

    public void clickBoxes() {
        boxes.click();
    }
}
