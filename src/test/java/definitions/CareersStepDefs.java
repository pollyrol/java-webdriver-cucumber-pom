package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CareersHome;
import pages.CareersOpenPosition;
import pages.CareersRecruit;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

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
    public void iVerifyLogin(String role) throws Throwable {
        WebElement actualUsername = new CareersHome().getUser("Owen");
        assertThat(actualUsername.getText()).containsIgnoringCase("owen");
    }

    @When("^I create \"([^\"]*)\" requisition$")
    public void iCreateRequisition(String arg0) throws Throwable {
        new CareersHome().clickRecruit();
        new CareersRecruit().clickNewPosition();
        new CareersOpenPosition().fillNewPosition();
//        Thread.sleep(6000);
    }

    @And("^I verify position created$")
    public void iVerifyPositionCreated() throws Throwable {
        new CareersRecruit().clickCareers();
        String actualResult = new CareersHome().getLastElement().getText();
        assertThat(actualResult).contains("Software Development Engineer in Test");
        assertThat(actualResult).contains("This position will work closely with QA");
        assertThat(actualResult).contains("4970 El Camino Real");
        assertThat(actualResult).contains("Los Altos");
        assertThat(actualResult).contains("94022");
    }
}