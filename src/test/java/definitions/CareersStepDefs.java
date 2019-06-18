package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import java.util.Map;

import static com.sun.scenario.Settings.get;
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


    @And("^I apply to a new position$")
    public void iApplyToANewPosition() throws Throwable {
        new CareersHome().clickLastPosition();
        new CareersPositionDetails().clickApply();
        new CareersNewCandidate().fillApplyForm(getData("candidate")).clickSubmit();
        Thread.sleep(3000);
    }

    @Then("^I verify profile is created$")
    public void iVerifyProfileIsCreated() throws Throwable {
        String actualLastName = new CareersMyJobs().getProfile();
        String expectedName = getData("candidate").get("lastName");
        assertThat(actualLastName).contains(expectedName);
    }


    @And("^I see position in my jobs$")
    public void iSeePositionInMyJobs() throws Throwable {
        new CareersMyJobs().getPosition();
    }
}
