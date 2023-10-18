package PageObjects;

import Utilitis.ApplicationSpecific;
import Utilitis.ExcelHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ConfirmationPage {

    private WebDriver driver;
    ApplicationSpecific applicationSpecific;
    ExcelHelper excelHelper = new ExcelHelper("./src/test/java/Data/ShoppingCart.xlsx");

    public ConfirmationPage(WebDriver driver) {
        this.driver=driver;
        applicationSpecific = new ApplicationSpecific(driver);

    }
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    private By greenTickIcon = By.xpath("//img[@class='pony_express']");

    private By confirmationLbl = By.xpath("//div[@class='complete-text']");
    private By backHomeBtn = By.xpath("//*[text()='Back Home']");
    public void ValidConfirmationChecks(WebDriver driver) throws IOException {
        Assert.assertTrue(driver.findElement(greenTickIcon).isDisplayed());
        String confirmationMsg = excelHelper.getCellData("Sheet1",1,5);
        String confirmationMsgOnWeb = driver.findElement(confirmationLbl).getText();
       Assert.assertEquals(confirmationMsgOnWeb,confirmationMsg);
        Assert.assertTrue(driver.findElement(backHomeBtn).isDisplayed());
        driver.findElement(backHomeBtn).click();


    }

}
