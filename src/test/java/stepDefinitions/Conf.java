package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
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

    WebDriver driver;
    WebElement element = null;
    ExtentHtmlReporter report = new ExtentHtmlReporter("./src/test/JenkinsExtentReport.html");;//("./src/test/"+System.currentTimeMillis()+"ExtentReport.html");
    ExtentReports extent = new ExtentReports();


    public void lunchBowser(){
        driver = new ChromeDriver();
        extent.attachReporter(report);
        ExtentTest test = extent.createTest("Browser chrome", " The browser is luanched");
        driver.get("https://gentlemensclubparis.com/");
        driver.manage().window().maximize();
    }
    public void quitBrowser(){
        driver.quit();
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
            test.log(Status.INFO, accessibility+ " is displayed");
            test.log(Status.PASS, accessibility+ " element success");
            test.getStatus();
        }
        catch (WebDriverException ex){
            ExtentTest test = extent.createTest(step, "Failed Find Element");
            test.log(Status.FAIL,  accessibility+ " Element is not displayed");

        }
        extent.flush();
        return element;
    }
}