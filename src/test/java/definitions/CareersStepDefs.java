package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import pages.CareersHome;

public class CareersStepDefs {
    @And("^I login as \"([^\"]*)\"$")
    public void iLoginAs(String role) throws Throwable {
        new CareersHome().
                clickLogin().
                fillUsername("owen@example.com").
                fillPassword("welcome").
                submit();

    }
}
