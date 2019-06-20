package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.RestWrapper;

import java.util.HashMap;

import static support.TestContext.getData;

public class RestStepDefs {

    int idx;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    @Given("^I login via REST as \"([^\"]*)\"$")
    public void iLoginViaRESTAs(String role) throws Throwable {
        HashMap<String, String> user = getData(role);
        new RestWrapper().login(user);
    }

    @When("^I create via REST new \"([^\"]*)\"$")
    public void iCreateViaRESTNew(String position) throws Throwable {
        HashMap<String, String> positionData = getData(position);
        new RestWrapper().postPosition(positionData);
    }


    @Then("^I verify via REST \"([^\"]*)\" is in the list$")
    public void iVerifyViaRESTIsInTheList(String position) throws Throwable {
        HashMap<String, String> positionData = getData(position);
        new RestWrapper().checkNewPosition(positionData);
    }

    @When("^I update via REST \"([^\"]*)\" with new fields$")
    public void iUpdateViaRESTWithNewFields(String position) throws Throwable {
        HashMap<String, String> positionData = getData(position);
        new RestWrapper().putPosition(positionData);
    }

    @And("^I delete via REST new \"([^\"]*)\"$")
    public void iDeleteViaRESTNew(int idx) throws Throwable {
        new RestWrapper().deletePosition(idx);
    }
}
