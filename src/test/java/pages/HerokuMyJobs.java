package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;

import static support.TestContext.getData;

public class HerokuMyJobs extends Page {

    @FindBy(xpath="//button[contains(text(),'Logout')]")
    private WebElement logoutBtn;

    @FindBy(xpath="//button[contains(text(),'Careers')]")
    private WebElement carreersBtn;

    @FindBy(xpath="//span[@class='logout-box']/..")
    private WebElement header;

    @FindBy(xpath="//*[@class='position-name']")
    private WebElement allMyJobs;


    public boolean isElementExist(String element) throws FileNotFoundException {
        switch (element.toLowerCase()) {
            case "name":
                return header.getText().contains(getData("heroku").get("firstName"));
            case("job"):
                return allMyJobs.getText().contains(getData("heroku").get("position1"));
        }
        return false;
    }



}
