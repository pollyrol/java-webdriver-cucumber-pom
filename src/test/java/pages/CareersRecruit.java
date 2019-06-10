package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CareersRecruit extends Page {

    @FindBy(xpath = "//a[@href='/new_position']/h4[contains(text(),'Position')]")
    private WebElement newPositionLink;

    @FindBy(xpath = "//a[contains(@href,'/positions/')]/h4")
    private List<WebElement> positions;

    public CareersNewPosition clickNewPosition(){
        click(newPositionLink);
        return new CareersNewPosition();
    }

    public CareersPosition clickPosition(String title){
        for(WebElement position : positions){
            if(position.getText().trim().equalsIgnoreCase(title)) {
                click(position);
                break;
            }
        }
        return new CareersPosition();
    }
}
