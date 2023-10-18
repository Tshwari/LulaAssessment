package PageObjects;

import Utilitis.ApplicationSpecific;
import Utilitis.ExcelHelper;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class CartPage {
    private WebDriver driver;
    ApplicationSpecific applicationSpecific;
    ExcelHelper excelHelper = new ExcelHelper("./src/test/java/Data/ShoppingCart.xlsx");


    public CartPage(WebDriver driver) {
        this.driver=driver;
        applicationSpecific = new ApplicationSpecific(driver);

    }

    private By checkoutCartBtn = By.xpath("//*[text()='Checkout']");

    private By checkOutFirstName = By.xpath("//*[@name='firstName']");

    private  By checkOutLastName = By.xpath("//*[@name='lastName']");

    private By checkOutZipCode = By.xpath("//*[@name='postalCode']");

    private By continueBtn = By.xpath("//*[@name='continue']");

    private By paymentInfoLbl = By.xpath("(//*[@class='summary_value_label'])[1]");

    private By finishBtn = By.xpath("//*[text()='Finish']");
    public void ClickCheckOut(WebDriver driver)
    {

            driver.findElement(checkoutCartBtn).click();

    }

    public void FillCheckOutInfo(WebDriver driver)
    {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String zipcode = faker.address().zipCode();

        driver.findElement(checkOutFirstName).sendKeys(firstName);
        driver.findElement(checkOutLastName).sendKeys(lastName);
        driver.findElement(checkOutZipCode).sendKeys(zipcode);
        driver.findElement(continueBtn).click();

    }

    public void VerifyPaymentInfo(WebDriver driver) throws IOException {
        String paymentInfo = excelHelper.getCellData("Sheet1",1,4);
        String paymentInfoValue = driver.findElement(paymentInfoLbl).getText();
        Assert.assertEquals(paymentInfo,paymentInfoValue);

    }

    public void ClickFinish(WebDriver driver)
    {
        driver.findElement(finishBtn).click();
    }
}
