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
import static support.TestContext.*;

public class CareersStepDefs {

    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String role) throws Throwable {

        new CareersHome().
                clickLogin().
                fillUsername(getData(role).get("email")).
                fillPassword(getData(role).get("password")).
                submit();
    }

    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String role) throws Throwable {

        String actualUsername = new CareersHome().getUser();
        assertThat(actualUsername).contains(getData(role).get("name"));
    }

    @When("^I create \"([^\"]*)\" requisition$")
    public void iCreateRequisition(String position) throws Throwable {

        new CareersHome()
                .clickRecruit()
                .clickNewPosition()
                .fillNewPosition(getData(position))
                .submit();
    }

    @And("^I verify position \"([^\"]*)\" created$")
    public void iVerifyPositionCreated(String position) throws Throwable {

//        --- Slava's code ---
        String actualTitle = new CareersRecruit().getLastPositionTitle();
        String expectedTitle = getData(position).get("title");
        assertThat(actualTitle).isEqualTo(expectedTitle);


//        --- mine ---
//        new CareersRecruit().clickCareers(); // Home page
//        String actualResult = new CareersHome().getLastElement().getText();
//        --- Assertions ---
//        assertThat(actualResult).contains(getData(position).get("title"));
//        assertThat(actualResult).contains(getData(position).get("description"));
//        assertThat(actualResult).contains(getData(position).get("street"));
//        assertThat(actualResult).contains(getData(position).get("state"));
//        assertThat(actualResult).contains(getData(position).get("zip"));

    }
}
