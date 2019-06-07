package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SampleForm;
import pages.UspsHome;
import pages.UspsLabels;
import pages.UspsPostalStore;

import static org.assertj.core.api.Assertions.assertThat;

public class UspsObjStepDefs {

    @When("^I go to \"([^\"]*)\"$")
    public void iGoTo(String link) throws Throwable {
        switch (link) {
            case "labels":
                new UspsHome().clickLabels();
                break;
            case "stamps":
                new UspsHome().clickStamps();
                break;
            case "boxes":
                new UspsHome().clickBoxes();
                break;
            default:
                throw new RuntimeException("Unrecognized link: " + link);
        }
    }

    @Then("^I verify \"([^\"]*)\" section exists$")
    public void iVerifySectionExists(String filterText) throws Throwable {
        String priceFilters = new UspsPostalStore().getPriceFilters();
        assertThat(priceFilters).contains(filterText);
    }

    @When("^I sort by \"([^\"]*)\"$")
    public void iSortBy(String how) throws Throwable {
        new UspsPostalStore().sortBy(how);
    }

    @Then("^I verify that \"([^\"]*)\" is cheapest$")
    public void iVerifyThatIsCheapest(String item) throws Throwable {
        String firstFound = new UspsPostalStore().getFirstFoundItem();
        assertThat(firstFound).contains(item);
    }

    @Then("^I verify that \"([^\"]*)\" is required$")
    public void iVerifyThatIsRequired(String arg0) throws Throwable {
        UspsLabels labelsPage = new UspsLabels();
        labelsPage.clickSignIn();
        assertThat(labelsPage.usernameErrorVisible()).isTrue();
    }

    @Then("^I verify that \"([^\"]*)\" is possible$")
    public void iVerifyThatIsPossible(String expectedText) throws Throwable {
        UspsLabels labelsPage = new UspsLabels();
        String actualText = labelsPage.getSignUpText();
        assertThat(actualText).containsIgnoringCase(expectedText);
    }
}
