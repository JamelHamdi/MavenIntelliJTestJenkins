package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.WebObjects;

public class AllProductsFilter extends Conf{

    //WebDriver driver;
    WebObjects obj = new WebObjects();

    @And("I open the gentlemensclub")
    public void i_open_the_gentlemensclub() {
        lunchBowser();
    }

    @When("I click to all products")
    public void i_click_to_all_products() {
        clickAllproducts();
    }

    @Then("All products page is displayed")
    public void all_products_page_is_displayed() {
        verifPageAllProducts();
    }

    @When("I choose to one filter option")
    public void i_choose_to_one_filter_option() throws InterruptedException {
        choosefilterOption();
    }

    @Then("Page products is filtered")
    public void page_products_is_filtered() {
        quitBrowser();
    }
}
