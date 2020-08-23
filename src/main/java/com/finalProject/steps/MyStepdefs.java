package com.finalProject.steps;

import com.finalProject.browser.Browser;
import com.finalProject.pages.AbstractPage;
import com.finalProject.pages.ContactUs;
import com.finalProject.pages.HomePage;
import com.finalProject.utils.ReflectionUtils;
import com.finalProject.utils.ScenarioContext;
import com.finalProject.utils.ScreenshotUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.finalProject.utils.ScenarioDataKey.CURRENT_PAGE;
import static org.hamcrest.CoreMatchers.*;

public class MyStepdefs {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ContactUs contactPage= new ContactUs(Browser.getBrowser());


    @Given("user goes to the {string} page")
    public void userGoesToTheHomePage(String pageName) {
        if (pageName.equals("Home Page")) {
            Browser.getBrowser()
                    .get("http://automationpractice.com/index.php");

        } else if(pageName.equals("Contact Us")) {
            Browser.getBrowser()
                    .get("http://automationpractice.com/index.php?controller=contact"); }
        else {
            throw new RuntimeException("Unknown link for page name: " + pageName);
        }
        ScreenshotUtils.takeScreenshot(pageName);
        logger.info("User goes on the {} page",pageName);
    }

    @And("user is on the {string} page")
    public void userIsOnTheHomePage(String pageName)
            throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException,
            InterruptedException {

        Thread.sleep(3000);
        AbstractPage page = ReflectionUtils.getPageObject(pageName);
        MatcherAssert.assertThat(Browser.getBrowser().getCurrentUrl(), containsString(page.getPageUrl()));
        ScenarioContext.setContext(CURRENT_PAGE.name(), page);
        ScreenshotUtils.takeScreenshot(pageName);
        logger.info("User is on the {} page", pageName);
    }

    @When("user clicks to {string} button")
    public void userClicksToContactUsButton(String buttonName) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(buttonName);
        ScreenshotUtils.takeScreenshotOfElement(buttonName, button);
        button.click();
        logger.info("User clicks to {} button", buttonName);
    }

    @When("user choose {string}")
    public void userChooseSubjectHeading(String subj) {
        if (subj.equals("Subject Heading")) {
            new Select(contactPage.getSubject()).selectByValue("1");
        }else {
            throw new RuntimeException("Unknown select " + subj);
        }
        logger.info("User chose {} as Subject Heading", subj);

    }

    @Then("confirmation message is displayed")
    public void confirmationMessageIsDisplayed()  throws IllegalAccessException {
        WebElement messageDisplayed = ReflectionUtils.getWebElement("Message Displayed");
        MatcherAssert.assertThat(messageDisplayed.isDisplayed(), is(true));
        ScreenshotUtils.takeScreenshotOfElement("Message Displayed", messageDisplayed);
        logger.info("Confirmation message is displayed Message Displayed");
    }

    @And("user input {string}")
    public void userInputOrderReference(String elementName) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        element.sendKeys((String) ScenarioContext.getContext(elementName));
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
        logger.info("User input {} as {}",elementName,ScenarioContext.getContext(elementName));

    }
}
