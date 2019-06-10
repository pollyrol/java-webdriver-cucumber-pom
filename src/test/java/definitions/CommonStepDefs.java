package definitions;

import cucumber.api.java.en.Given;
import pages.CareersHome;
import pages.SampleForm;
import pages.UspsHome;

import java.io.FileNotFoundException;

public class CommonStepDefs {
    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String page) throws FileNotFoundException {
        switch (page) {
            case "usps":
                new UspsHome().open();
                break;
            case "sample":
                new SampleForm().open();
                break;
            case "careers":
                new CareersHome().open();
                break;
            default:
                throw new RuntimeException("Unrecognized page " + page);
        }
    }
}
