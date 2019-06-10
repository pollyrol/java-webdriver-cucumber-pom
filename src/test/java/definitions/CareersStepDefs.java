package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CareersHome;
import pages.CareersPositionDetails;
import pages.CareersRecruit;

import static org.assertj.core.api.Assertions.assertThat;

public class CareersStepDefs {
    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String role) throws Throwable {
        new CareersHome().
                clickLogin().
                fillUsername().
                fillPassword().
                submit();
    }

    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String name) throws Throwable {
        CareersHome result = new CareersHome();
        String actualResult = result.getNameRecruter();

        assertThat(actualResult).contains("Owen Kelley");
    }

    @When("^I create \"([^\"]*)\" requisition$")
    public void iCreateRequisition(String arg0) throws Throwable {
        new CareersHome().
                clickRecruit().
                clickNewPosition().
                fillTitle().
                fillDescription().
                fillAddress().
                fillCity().
                selectState().
                fillZip().
                fillDate().
                submit();


    }

    @And("^I verify position created$")
    public void iVerifyPositionCreated() throws Throwable {

        new CareersRecruit().textPosition().getTitle();
        CareersPositionDetails result =  new CareersPositionDetails();

        String actualResultTitle = result.getTitle();
        String actualResultDescription = result.getDescription();
        String actualResultAddress = result.getAddress();
        String actualResultCity = result.getCity();
        String actualResultState = result.getState();
        String actualResultZip = result.getZip();
        String actualResultDate = result.getDate();
        Thread.sleep(3000);

        assertThat(actualResultTitle).contains("SQA Engineer");
        assertThat(actualResultDescription).contains("Java");
        assertThat(actualResultAddress).contains("4970 El Camino Real");
        assertThat(actualResultCity).contains("Los Altos");
        assertThat(actualResultState).contains("California");
        assertThat(actualResultZip).contains("94022");


    }
}
