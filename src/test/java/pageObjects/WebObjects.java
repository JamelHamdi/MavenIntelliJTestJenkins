package pageObjects;

import org.openqa.selenium.By;

public class WebObjects {

    public By _login = By.id("_desktop_logo");
    public By _iConcnx = By.xpath("//SPAN[@class='ax-user-icon']");
    public By _cnxBtn = By.xpath("//SPAN[@class='ax-user-title']");
    public By _eMail = By.xpath("//input[@class='form-control']");
    public By _mdp = By.xpath("//input[@name='password']");
    public By _btnCnx = By.id("submit-login");

    public By _allProducts = By.xpath("//a[@class='all-product-link float-xs-left pull-md-right h4']");
    public By _pageAllproducts = By.xpath("//div[@class='col-md-5 hidden-sm-down total-products']");
    public By _filterIcon = By.xpath("//i[@class='material-icons float-xs-right']");
    public By _filterOption = By.xpath("//i[@class='material-icons float-xs-right']");

}
