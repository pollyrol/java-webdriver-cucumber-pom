package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CareersHome;
import pages.CareersRecruit;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class CareersStepDefs {
    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String role) throws Throwable {
        Map<String, String> recruiter = getData(role);
        new CareersHome().
                clickLogin().
                fillUsername(recruiter.get("email")).
                fillPassword(recruiter.get("password")).
                submit();

    }

    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String role) throws Throwable {
        String actualName = new CareersHome().getUserName();
        String expectedName = getData(role).get("name");
        assertThat(actualName).isEqualTo(expectedName);
    }

    @When("^I create \"([^\"]*)\" requisition$")
    public void iCreateRequisition(String title) throws Throwable {
        new CareersHome().
                clickRecruit().
                clickNewPosition().
                fillPosition(getData(title)).
                submit();
    }


    @And("^I verify \"([^\"]*)\" position created$")
    public void iVerifyPositionCreated(String title) throws Throwable {
        String actualTitle = new CareersRecruit().getLastPositionTitle();
        String expectedTitle = getData(title).get("title");
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}