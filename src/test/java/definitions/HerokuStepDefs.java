package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import java.io.FileNotFoundException;
import java.util.HashMap;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import support.TestContext;

import static org.testng.Assert.assertTrue;

public class HerokuStepDefs extends Page {

    HerokuCareers herokuHome = new HerokuCareers();
    HerokuNewCandidate newCandidate = new HerokuNewCandidate();
    HerokuProfile profile = new HerokuProfile();
    HerokuPosition position = new HerokuPosition();
    HerokuNewPosition newPosition = new HerokuNewPosition();
    HerokuLogin login = new HerokuLogin();
  
  public HerokuStepDefs() {}
  
  @And("^I apply to a new position$")
  public void iApplyToANewPosition() throws FileNotFoundException, InterruptedException {
    HashMap<String, String> candidateData = TestContext.getData("herokuData");
    herokuHome.positionCLick();
    position.applyBtnClick("not logged in");
    newCandidate.fillRequiredFields(candidateData);
    newCandidate.submitClick();
  }
  
  @Then("^I verify profile is created$")
  public void iVerifyProfileIsCreated() throws FileNotFoundException {
    assertTrue(profile.isElementExist("logout"));
  }
  
  @And("^I login as \"([^\"]*)\"$")
  public void iLoginAs(String loginOption) throws FileNotFoundException {
    HashMap<String, String> inputData = TestContext.getData("herokuData");
    herokuHome.loginBtnClick();
    switch (loginOption) {
      case ("candidate"):
        login.fillRequiredFields(inputData);
        login.submitClick();
        break;
      case("recruiter"):
        login.fillRecruiterFields(inputData);
        login.submitClick();
        break;
    }

  }

  //TODO
  @And("^I see position in my jobs$")
  public void iSeePositionInMyJobs() throws FileNotFoundException {
    HashMap<String, String> candidateData = TestContext.getData("herokuData");
    profile.myJobsClick();
    profile.isShown((String)candidateData.get("position2"));
  }
  
  @Then("^I verify \"([^\"]*)\" login$")
  public void iVerifyLogin(String role) throws FileNotFoundException {
    switch (role) {
      case("candidate"):
        profile.isElementExist("name");
        break;
      case("recruiter"):
        profile.isShown("recruiter");
        break;
    }

  }
  
  @When("^I apply for a new job$")
  public void iApplyForANewJob() throws FileNotFoundException {
    HashMap<String, String> candidateData = TestContext.getData("herokuData");
    
    herokuHome.positionClick("logged in");
    position.applyBtnClick("logged in");
  }

    @When("^I create \"([^\"]*)\" position$")
    public void iCreatePosition(String position) throws FileNotFoundException {
      HashMap<String, String> data = TestContext.getData("herokuData");


      newPosition.fillNewPositionFields();
    }
}