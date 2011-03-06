package simple;

import cuke4duke.annotation.Before;
import cuke4duke.annotation.I18n.EN.Then;
import cuke4duke.annotation.I18n.EN.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static simple.WebDriverFactory.getWebDriver;
import static simple.WebDriverFactory.initializeBrowser;

public class BrandHubSteps {


    @Before
    public void startBrowser() {
        initializeBrowser();
    }

    @When("^I open '(.*)'$")
    public void iOpenWebPage(String url) {
        getWebDriver().get("http://www.channel4.com" + url);

    }

    @Then("^the title should be '(.*)'$")
    public void checkTitleOfPage(String title) {
        String actualPageTitle = getWebDriver().getTitle();
        assertEquals("Expected page title note returned ", title, actualPageTitle);

    }


    @Then("^I click an item with xpath '(.*)'$")
    public void iClickAnItemWithXPath(String xpath) {
        getWebDriver().findElement(By.xpath(xpath)).click();

    }


    @Then("^element with id '(.*)' should be present$")
    public void elementWithIdShouldBePresent(String id) {
        assertTrue(String.format("Element with %s should be present", id), getWebDriver().findElement(By.id(id)) != null);
    }


    @Then("^browser location should be '(.*)'$")
    public void locationShouldMatchSuppliedLocation(String locationString) {
        String currentLocation = getWebDriver().getCurrentUrl();
        assertEquals(String.format("Location should be %s", locationString), locationString, currentLocation);
    }

    @Then("^I fill form field with xpath '(.*)' using value '(.*)'$")
    public void iFillFormField(String fieldXPath, String value) {
        getWebDriver().findElement(By.xpath(fieldXPath)).sendKeys(value);
    }

    @Then("^I submit form with name '(.*)'$")
    public void iSubmitForm(String formName) {
        getWebDriver().findElement(By.name(formName)).submit();

    }


}

