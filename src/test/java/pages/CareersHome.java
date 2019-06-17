package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.ListIterator;

import static support.TestContext.getDriver;

public class CareersHome extends Page {

    public CareersHome() {
        setUrl("http://skryabin-careers.herokuapp.com/");
    }

    private String idx;
    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement username;

    @FindBy(xpath = "//a[@href='/recruit']")
    private WebElement recruitButton;

    @FindBy(xpath = "//li[last()]")
    private WebElement lastElement;

    @FindBy(xpath = "//li[contains(@style, 'z-index: 0;')]//h4")
    private WebElement lastVisible;

    @FindBy(xpath = "//li")
    private List<WebElement> positions;

    public CareersPositionDetails getNewJob() {

//      --- ListIterator to iterate arr in reverse order ---
        ListIterator<WebElement> itr = positions.listIterator(positions.size());

//      --- hasPrevious() returns true if the List has previous element ---
        while (itr.hasPrevious()) {
            WebElement item = itr.previous();
            String itemClass = item.getAttribute("class");
            setIdx(item.getAttribute("id"));
//            String itemId = item.getAttribute("id");

            if (item.isDisplayed() && !itemClass.contains("selected")) {
                click(item.findElement(By.xpath("//a[@href='/positions/" +  getIdx() + "']")));
                System.out.println("0: " + getIdx());
                break;
            }
        }

        return new CareersPositionDetails();
    }

    public CareersLogin clickLogin() {
        click(loginButton);
        return new CareersLogin();
    }

    public String getUser() {
        return username.getText();
    }

    public CareersRecruit clickRecruit() {
        click(recruitButton);
        return new CareersRecruit();
    }

    public WebElement getLastElement() {
        return lastElement;
    }

    public CareersPositionDetails clickLastVisible() {
        click(lastVisible);
        return new CareersPositionDetails();
    }

}
