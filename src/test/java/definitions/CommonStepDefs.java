package definitions;

import cucumber.api.java.en.Given;
import pages.SampleForm;
import pages.UspsHome;

public class CommonStepDefs {
    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String page) {
        switch (page) {
            case "usps":
                new UspsHome().open();
                break;
            case "sample":
                new SampleForm().open();
                break;
            default:
                throw new RuntimeException("Unrecognized page " + page);
        }
    }
}
