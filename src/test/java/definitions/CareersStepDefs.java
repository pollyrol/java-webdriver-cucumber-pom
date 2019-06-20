package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CareersHome;
import pages.CareersMyJobs;
import pages.CareersRecruit;
import pages.MyJobs;

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

    @And("^I apply to a new position$")
    public void iApplyToANewPosition() throws Throwable{
        new CareersHome().
                selectPosition().
                clickApply().
                fillProfile(getData("RDesai")).
                submitProfile();
    }

    @Then("^I verify profile is created$")
    public void iVerifyProfileIsCreated() throws Throwable {
        String actualUserName = new CareersMyJobs().getUserName();
        String expectedUserName = getData("RDesai").get("FirstName") + " " + getData("RDesai").get("LastName");
        System.out.println("Actual user name is: " + actualUserName);
        System.out.println("Expected user name is: " + expectedUserName);
        System.out.println();
        assertThat(actualUserName).isEqualTo(expectedUserName);
    }

    @And("^I see position in my jobs$")
    public void iSeePositionInMyJobs() {
        String expectedPositionApplied = "Senior Automation Engineer";
        String actualPositionApplied = new CareersMyJobs().getPositionTitle();
        System.out.println("Position applied for is: " + actualPositionApplied);
        System.out.println();
        assertThat(actualPositionApplied).isEqualTo(expectedPositionApplied);
    }

    @When("^I apply for a new job$")
    public void iApplyForANewJob() throws Throwable {
        new CareersHome().applyPosition();
        Thread.sleep(500);
    }

    @And("^I go to My Jobs$")
    public void iGoToMyJobs() {
        new CareersHome().clickMyJobs();
    }

    @Then("^I see position marked as applied$")
    public void iSeePositionMarkedAsApplied() {
        String positionProp = new CareersHome().verifyPositionApplied();
        System.out.println("Class attribute of job-position web element is: " + positionProp);
        System.out.println();
        assertThat(positionProp).contains("li-selected");
    }
}
