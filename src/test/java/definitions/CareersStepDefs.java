package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebElement;
import pages.*;

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
        Thread.sleep(5000);
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

    }

    @And("^I apply to a new position$")
    public void iApplyToANewPosition() throws Throwable {

        new CareersHome()
                .clickLastVisible()
                .clickApply()
                .fillApplyForm(getData("candidate"))
                .clickSubmit();
//        Thread.sleep(5000);

    }

    @Then("^I verify profile is created$")
    public void iVerifyProfileIsCreated() throws Throwable {

        String actualUsername = new CareersMyJobs().getUser();
        assertThat(actualUsername).contains(getData("candidate").get("name"));
    }


    @And("^I see position in my jobs$")
    public void iSeePositionInMyJobs() throws Throwable {
        assertThat(
                new CareersMyJobs()
                    .getJobTitle()
                    .isDisplayed()
        ).isTrue();
    }

    @When("^I apply for a new job$")
    public void iApplyForANewJob() throws Throwable {
        new CareersHome()
                .getNewJob()
                .clickApply();
    }

    @Then("^I see position marked as applied$")
    public void iSeePositionMarkedAsApplied() throws Throwable {
        new CareersMyJobs().isPositionApplied();
    }
}
