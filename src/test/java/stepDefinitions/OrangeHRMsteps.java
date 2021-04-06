package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.IMethodSelector;
import pageObjects.WebObjects;

public class OrangeHRMsteps extends Conf{

    //WebDriver driver;
    WebObjects obj = new WebObjects();

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
    }

    @When("I open orange hrm page")
    public void i_open_orange_hrm_page() {
        lunchBowser();
    }

    @Then("I verify that the logo presence on page")
    public void i_verify_that_the_logo_presence_on_page() {
        verifLogo();
    }

    @And("close browser")
    public void close_browser() {

        quitBrowser();
    }

    @Given("I open orange chrome hrm page")
    public void i_open_orange_chrome_hrm_page() {
        lunchBowser();
    }
    @When("I insert the login mdp")
    public void i_insert_the_login_mdp() {
        FindBy(obj._iConcnx , "Click in icone connexion").click();
        FindBy(obj._cnxBtn , "Click in connexion").click();
        FindBy(obj._eMail , "Insert the email adress").sendKeys("intelodjo@gmail.com");
        FindBy(obj._mdp , "Insert the passwword").sendKeys("97460480");

    }
    @When("I click to login button")
    public void i_click_to_login_button() {
        FindBy(obj._btnCnx , "Click in button connexion").click();
    }
    @Then("message Ok is displayed")
    public void message_ok_is_displayed() {
        quitBrowser();
    }
}
