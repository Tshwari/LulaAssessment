package PageObjects;

import Utilitis.ApplicationSpecific;
import Utilitis.ExcelHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    ApplicationSpecific applicationSpecific;
    ExcelHelper excelHelper = new ExcelHelper("./src/test/java/Data/ShoppingCart.xlsx");


    public HomePage(WebDriver driver) {
        this.driver=driver;
        applicationSpecific = new ApplicationSpecific(driver);

    }

    LoginPage loginPage = new LoginPage(driver);
    private By itemRemovalButton(String item)
    {
        return By.xpath("//div[text()='"+ item +"']/following::button[text()='Remove'][1]");
    }

    private By shoppingCartBadge = By.xpath("//*[@class='shopping_cart_badge']");

    private By shoppingCartBadgeIcon = By.xpath("//span[@class='shopping_cart_badge']");

    private By shoppingItemAddToCart(String item)
    {
       return By.xpath("//div[text()='"+ item +"']/following::button[text()='Add to cart'][1]");
    }


    private By cartIcon = By.xpath("//a[@class='shopping_cart_link']");

    private By logoutBtn = By.xpath("//*[text()='Logout']");

    private By hamburgerMenuIcon = By.xpath("//*[@class='bm-icon']");

    private By filter = By.xpath("//*[@class='product_sort_container']");

    private By priceLowToHighFilter = By.xpath("//*[text()='Price (low to high)']");

    private By closeIcon = By.xpath("//button[@class='error-button']");

    public void ClickItemRemovalButton(WebDriver driver, String item)
    {

        driver.findElement(itemRemovalButton(item)).click();
    }

    public void ShoppingCartBadge(WebDriver driver){
        driver.findElement(shoppingCartBadge).isDisplayed();
    }

    public void VerifyHomePageURL(String url)
    {
        Assert.assertEquals(url,driver.getCurrentUrl());
    }

    public void VerifyShoppingCartBadgeIsRemoved()
    {
        Assert.assertTrue(!driver.findElement(shoppingCartBadgeIcon).isDisplayed());
    }

    public void ClickLogoutBtn(WebDriver driver){
        driver.findElement(logoutBtn).click();
    }

    public void ClickNewItemAddedToCart(WebDriver driver,String item)
    {
        driver.findElement(shoppingItemAddToCart((item))).click();
    }

    public void VerifyItemRemovalButtonIsDisplayed(WebDriver driver,String item)
    {
            Assert.assertTrue(driver.findElement(itemRemovalButton(item)).isDisplayed());

    }
    public void ClickOnCart(WebDriver driver)
    {
        driver.findElement(cartIcon).click();
    }

    public void ClickHamburgerMenu(WebDriver driver) throws Exception {
        driver.findElement(hamburgerMenuIcon).isDisplayed();
        loginPage.WaitForElement(hamburgerMenuIcon);
        driver.findElement(hamburgerMenuIcon).click();
    }
    public void XIco(WebDriver driver){
        driver.findElement(closeIcon).click();
    }

    public void FilterBox(WebDriver driver){
        driver.findElement(filter).click();
        driver.findElement(priceLowToHighFilter).click();

    }

}
