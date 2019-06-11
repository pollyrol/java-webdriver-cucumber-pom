package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CareersHome;
import pages.CareersOpenPosition;
import pages.CareersRecruit;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getAutomation;
import static support.TestContext.getDriver;
import static support.TestContext.getRecruiter;

public class CareersStepDefs {
    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String role) throws Throwable {
        new CareersHome().
                clickLogin().
                fillUsername(getRecruiter().get("email")).
                fillPassword(getRecruiter().get("password")).
                submit();
    }

    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String role) throws Throwable {
        WebElement actualUsername = new CareersHome().getUser("Owen");
        assertThat(actualUsername.getText()).containsIgnoringCase("owen");
    }

    @When("^I create \"([^\"]*)\" requisition$")
    public void iCreateRequisition(String arg0) throws Throwable {
        HashMap<String, String> automation = getAutomation();
        String title = automation.get("title");
        String description = automation.get("description");
        String street = automation.get("street");
        String city = automation.get("city");
        String stateValue = automation.get("stateValue");
        String zip = automation.get("zip");

        new CareersHome().clickRecruit();
        new CareersRecruit().clickNewPosition();
        new CareersOpenPosition().fillNewPosition(title, description,  street, city, stateValue, zip);
    }

    @And("^I verify position created$")
    public void iVerifyPositionCreated() throws Throwable {
        new CareersRecruit().clickCareers();
        String actualResult = new CareersHome().getLastElement().getText();
        assertThat(actualResult).contains(getAutomation().get("title"));
        assertThat(actualResult).contains(getAutomation().get("description"));
        assertThat(actualResult).contains(getAutomation().get("street"));
        assertThat(actualResult).contains(getAutomation().get("state"));
        assertThat(actualResult).contains(getAutomation().get("zip"));
    }
}
