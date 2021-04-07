package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.WebObjects;

import java.io.Console;

public class Conf {
    WebObjects obj = new WebObjects();
    SendAttachmentInEmail sendEmail = new SendAttachmentInEmail();
    WebDriver driver;
    WebElement element = null;
    ExtentHtmlReporter report = new ExtentHtmlReporter("./src/test/JenkinsExtentReport.html");;//("./src/test/"+System.currentTimeMillis()+"ExtentReport.html");
    ExtentReports extent = new ExtentReports();

    @Before
    public void lunchBowser(){
        driver = new ChromeDriver();
        extent.attachReporter(report);
        ExtentTest test = extent.createTest("Browser chrome", " The browser is luanched");
        driver.get("https://gentlemensclubparis.com/");
        driver.manage().window().maximize();
    }
    @After
    public void quitBrowser(){
        driver.quit();
        sendEmail.sendEmail();
    }
    public void verifLogo(){
        String logo = "_desktop_logo";
        FindBy(By.xpath(logo), By.xpath(logo).getClass().getName());
        boolean status = driver.findElement(By.id(logo)).isDisplayed();
        Assert.assertEquals(true,status);
    }
    //Method Findby return element
    public WebElement FindBy(By accessibility, String step){
        try {
            element = driver.findElement(accessibility);
            extent.attachReporter(report);
            ExtentTest test = extent.createTest(step, element.getText());
            test.log(Status.INFO, accessibility+ " : is displayed");
            test.log(Status.PASS, accessibility+ " : Element success");
            test.getStatus();
        }
        catch (WebDriverException ex){
            ExtentTest test = extent.createTest(step, "Failed Find Element");
            test.log(Status.FAIL,  accessibility+ " : Element is not displayed");

        }
        extent.flush();
        return element;
    }

    //methode click al products
    public void clickAllproducts(){
        FindBy(obj._allProducts , "Click All products button").click();
    }
    //verif page all products
    public void verifPageAllProducts(){
        boolean status = FindBy(obj._pageAllproducts," Page All products").isDisplayed();
        Assert.assertEquals(true,status);
    }
    //method choose Option
    public void choosefilterOption() throws InterruptedException {
        FindBy(obj._filterIcon,"Click to filter icon").click();
        FindBy(obj._filterOption,"Click filter option");
        Thread.sleep(3000);
    }
}
