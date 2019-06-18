package definitions;

import cucumber.api.java.en.Given;
import pages.CareersHome;
import pages.SampleForm;
import pages.UspsHome;

public class CommonStepDefs {
    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String page) throws InterruptedException {
        switch (page) {
            case "usps":
                new UspsHome().open();
                break;
            case "sample":
                new SampleForm().open();
                break;
            case "careers":
                new CareersHome().open();
                Thread.sleep(3000);
                break;
            default:
                throw new RuntimeException("Unrecognized page " + page);
        }
    }
}
