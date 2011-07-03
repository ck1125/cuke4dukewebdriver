package simple;


import cuke4duke.annotation.I18n;
import cuke4duke.annotation.I18n.EN.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static simple.WebDriverFactory.getWebDriver;

public class LinkNodeSteps {
    private static final String JS_FIND_FIRST_TEXT_NODE_VALUE = "return arguments[0].firstChild.nodeValue";

    @Then("^my link must have the following partial text (.*)$")
    public void linkMustHaveTextMatchingSuppliedLabel(String label) {
        assertNotNull(getWebDriver().findElement(By.partialLinkText(label)));
    }


    @Then("^my link must have the following text (.*)$")
    public void linkMustHaveTextNodeWithSuppliedLabel(String label) {

        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
        String linkXpath = "//a";
        WebElement element = getWebDriver().findElement(By.xpath(linkXpath));
        String text = (String) executor.executeScript(JS_FIND_FIRST_TEXT_NODE_VALUE, element);
        assertTrue(String.format("%s should be present in link", label), text.equals(label));

    }

    @I18n.EN.When("^I open abitrary page$")
    public void iOpenWebArbitraryPage() {
        getWebDriver().get("http://www.in3k8.com/sample-aspan.html");

    }


}