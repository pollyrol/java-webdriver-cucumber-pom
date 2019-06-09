package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CareersHome;
import pages.CareersOpenPosition;
import pages.CareersRecruitForm;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CareersStepDefs {
    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String role) throws Throwable {

        new CareersHome().
                clickLogin().
                fillUsername("owen@example.com").
                fillPassword("welcome").
                submit();
    }

    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String arg0) throws Throwable {

        assertThat(new CareersHome().getName()).isNotEmpty();
    }

    @When("^I create \"([^\"]*)\" requisition$")
    public void iCreateRequisition(String arg0) throws Throwable {
        new CareersHome().
                clickRecriut().
                clickNewPosition();
        new CareersOpenPosition().
                fillTitle("SDET").
                fillDescription("Automation engineer end test").
                fillAddress("123 El Camino").
                fillCity("Los Altos").
                fillZip("94020").
                fillDateOpen("08/08/2019").
                getFoundItem("California").
                clickSubmit();

    }

    @And("^I verify position created$")
    public void iVerifyPositionCreated() {
        CareersRecruitForm form = new CareersRecruitForm();
        assertThat(form.getAllPositionsList()).contains("SDET");
    }
}