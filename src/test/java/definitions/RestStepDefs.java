package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import support.RestWrapper;

import java.util.HashMap;

import static support.TestContext.getData;

public class RestStepDefs {
    @Given("^I login via REST as \"([^\"]*)\"$")
    public void iLoginViaRESTAs(String role) throws Throwable {
        HashMap<String, String> user = getData(role);
        new RestWrapper().login(user);
    }
}
