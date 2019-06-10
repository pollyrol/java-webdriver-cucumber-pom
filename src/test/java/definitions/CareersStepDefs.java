package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.yaml.snakeyaml.Yaml;
import pages.CareersHome;
import pages.CareersNewPosition;
import pages.CareersPosition;
import pages.CareersRecruit;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class CareersStepDefs {

    private String position;

    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String userType) throws FileNotFoundException{
        Yaml yaml = new Yaml();
        InputStream datafileReader;
        HashMap<String, String> userdata;

        switch (userType){
            case "recruiter":
                datafileReader = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/data/recruiter.yml"));
                userdata = yaml.load(datafileReader);
                new CareersHome().clickLogin().fillUsername(userdata.get("username")).fillPassword(userdata.get("password")).submit();
                break;
            default:
                throw new RuntimeException("Unrecognized user type: " + userType);
        }

    }

    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String userType) throws FileNotFoundException{
        CareersHome careersHome = new CareersHome();
        Yaml yaml = new Yaml();
        InputStream datafileReader;
        HashMap<String, String> userdata;

        switch (userType){
            case "recruiter":
                datafileReader = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/data/recruiter.yml"));
                userdata = yaml.load(datafileReader);
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
        Yaml yaml = new Yaml();
        InputStream datafileReader;
        HashMap<String, String> userdata;

        switch (position){
            case "automation":
                datafileReader = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/data/automation.yml"));
                userdata = yaml.load(datafileReader);
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
        Yaml yaml = new Yaml();
        InputStream datafileReader;
        HashMap<String, String> userdata;

        switch (position){
            case "automation":
                datafileReader = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/data/automation.yml"));
                userdata = yaml.load(datafileReader);
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
