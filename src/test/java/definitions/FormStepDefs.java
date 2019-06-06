package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.SampleForm;
import pages.SampleResult;

import static org.assertj.core.api.Assertions.assertThat;

public class FormStepDefs {
    @Given("^I open sample form$")
    public void iOpenSampleForm() throws Throwable {
        new SampleForm().open();
    }

    @And("^I fill out sample fields$")
    public void iFillOutSampleFields() throws Throwable {
        SampleForm form = new SampleForm();
        form.fillUsername("skryabin");
        form.fillEmail("slava@skryabin.com");
        form.fillPassword("welcome");
        form.fillConfirmPassword("welcome");
        form.fillName("Slava", "Vlad", "Skryabin");
        form.clickPrivacyPolicy();
        form.submitForm();
    }

    @Then("^I verify sample result$")
    public void iVerifySampleResult() throws Throwable {
        SampleResult result = new SampleResult();

        System.out.println(result.getResult());
        assertThat(result.getResult()).contains("Slava Vlad Skryabin");
        assertThat(result.getResult()).contains("slava@skryabin.com");
        assertThat(result.getResult()).contains("skryabin");
        assertThat(result.getPassword()).doesNotContain("welcome");
        assertThat(result.getPrivacy()).isEqualTo("true");

    }
}
