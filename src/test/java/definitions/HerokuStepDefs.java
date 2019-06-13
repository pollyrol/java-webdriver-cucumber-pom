package definitions;

import cucumber.api.java.en.And;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pages.*;
import static org.testng.Assert.assertTrue;
import static support.TestContext.getData;

public class HerokuStepDefs extends Page {

    @And("^I apply to a new position$")
    public void iApplyToANewPosition() throws FileNotFoundException {
        HashMap<String, String> candidateData = getData("heroku");
        new HerokuCareers().positionCLick().
                applyBtnClick("not logged in");
        new HerokuNewCandidate().fillRequiredFields(candidateData).
                submitClick();
    }

    @Then("^I verify profile is created$")
    public void iVerifyProfileIsCreated() throws FileNotFoundException {
        assertTrue(new HerokuMyJobs().isElementExist("name"));
    }

    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String loginOption) throws FileNotFoundException {
        HashMap<String, String> inputData = getData("heroku");
        new HerokuCareers().loginBtnClick();
        switch (loginOption.toLowerCase()) {
            case ("candidate"):
                new HerokuLogin().fillRequiredFields(inputData);
                break;
            case ("recruiter"):
                new HerokuLogin().fillRecruiterFields(inputData);
                break;
        }
        new HerokuLogin().submitClick();
    }

    //TODO
    @And("^I see position in my jobs$")
    public void iSeePositionInMyJobs() throws FileNotFoundException {
        assertTrue(new HerokuMyJobs().isElementExist("job"));
    }

    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String role) {
        switch (role) {
            case ("candidate"):
                new HerokuCareers().isShown("candidate");
                break;
            case ("recruiter"):
                new HerokuCareers().isShown("recruiter");
                break;
        }
    }

    @When("^I apply for a new job$")
    public void iApplyForANewJob() {
        new HerokuCareers().positionClick("logged in").
                applyBtnClick("logged in");
    }

    @When("^I create \"([^\"]*)\" position$")
    public void iCreatePosition(String position) throws FileNotFoundException {
        new HerokuCareers().recruitBtnClick();
        new HerokuRecruit().newPositionClick();
        new HerokuNewPosition().fillNewPositionFields();
    }

    @And("^I verify position created$")
    public void iVerifyPositionCreated() throws FileNotFoundException {
        System.out.println("Expected: " + getData("heroku").get("positionTitle"));
        assertTrue(new HerokuRecruit().lastAddedPosition().contains(getData("heroku").get("positionTitle")));
    }
}