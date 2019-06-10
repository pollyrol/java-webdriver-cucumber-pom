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
        switch (role){
            case ("recruiter"):
                new CareersHome().
                clickLogin().
                loginFromFile().
                submit();
            break;
            default:
                throw new RuntimeException("Unrecognized credentials " + role);
        }
    }



    @Then("^I verify \"([^\"]*)\" login$")
    public void iVerifyLogin(String value) throws Throwable {

        assertThat(value).containsIgnoringCase(new CareersHome().getButtonName());

    }

    @When("^I create \"([^\"]*)\" requisition$")
    public void iCreateRequisition(String role) throws Throwable {
        new CareersHome().
                clickRecriut().
                clickNewPosition();
        switch (role){
            case ("automation"):
                new CareersOpenPosition().
                        fillFormFromFile();
                break;
            default:
                throw new RuntimeException("Unrecognized credentials " + role);
        }
        new CareersOpenPosition().clickSubmit();
    }


    @And("^I verify position created$")
    public void iVerifyPositionCreated() throws InterruptedException {
        CareersRecruitForm form = new CareersRecruitForm();
        assertThat(form.getAllPositionsList()).contains("SDET");
    }
}