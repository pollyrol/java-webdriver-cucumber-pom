package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;
import support.TestContext;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CareersStepDefs {

    private String position;

    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String userType) throws FileNotFoundException{
        HashMap<String, String> userdata;

        switch (userType){
            case "recruiter":
                userdata = TestContext.getData("recruiter.yml");
                new CareersHome().clickLogin().fillUsername(userdata.get("username")).fillPassword(userdata.get("password")).submit();
                break;
            default:
                throw new RuntimeException("Unrecognized user type: " + userType);
        }

    }

    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String userType) throws FileNotFoundException{
        CareersHome careersHome = new CareersHome();
        HashMap<String, String> userdata;

        switch (userType){
            case "recruiter":
                userdata = TestContext.getData("recruiter.yml");
                assertThat(userdata.get("name")).isEqualToIgnoringCase(careersHome.getFullName().trim());
                assertThat(careersHome.recruitButtonPresent());
                break;
            default:
                throw new RuntimeException("Unrecognized user type: " + userType);
        }

    }

    @When("^I create \"([^\"]*)\" requisition$")
    public void iCreateRequisition(String positionName) throws FileNotFoundException{
        position = positionName;
        CareersNewPosition newPosition = new CareersHome().clickRecruit().clickNewPosition();
        HashMap<String, String> userdata;

        switch (position){
            case "automation":
                userdata = TestContext.getData("automation.yml");
                newPosition.fillTitle(userdata.get("title")).fillDescription(userdata.get("description")).fillAddress(userdata.get("address"))
                        .fillCity(userdata.get("city")).fillState(userdata.get("state")).fillZipcode(userdata.get("zipcode"))
                        .selectDateOpenAsToday().clickSubmit();
                break;
            default:
                throw new RuntimeException("Unrecognized position: " + position);
        }

    }

    @Then("^I verify position created$")
    public void iVerifyPositionCreated() throws FileNotFoundException{
        CareersPosition positionPage;
        HashMap<String, String> userdata;

        switch (position){
            case "automation":
                userdata = TestContext.getData("automation.yml");
                positionPage = new CareersRecruit().clickPosition(userdata.get("title"));
                assertThat(positionPage.readTitle()).isEqualToIgnoringCase(userdata.get("title"));
                assertThat(positionPage.readDescription()).isEqualToIgnoringCase(userdata.get("description"));
                assertThat(positionPage.readAddress()).isEqualToIgnoringCase(userdata.get("address"));
                assertThat(positionPage.readCity()).isEqualToIgnoringCase(userdata.get("city"));
                assertThat(positionPage.readState()).isEqualToIgnoringCase(userdata.get("state"));
                assertThat(positionPage.readZipcode()).isEqualToIgnoringCase(userdata.get("zipcode"));
                Date curDate = Calendar.getInstance().getTime();
                DateFormat dateToStr = new SimpleDateFormat("M/d/yyyy");
                assertThat(dateToStr.format(curDate)).contains(positionPage.readDateOpen());
                break;
            default:
                throw new RuntimeException("Unrecognized position: " + position);
        }
    }
}
