package PageObjects;

import Utilitis.ApplicationSpecific;
import Utilitis.ExcelHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import java.io.IOException;
import java.util.Locale;

public class LoginPage {
    private WebDriver driver;
    ApplicationSpecific applicationSpecific;
    ExcelHelper excelHelper = new ExcelHelper("./src/test/java/Data/ShoppingCart.xlsx");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        applicationSpecific = new ApplicationSpecific(driver);

    }

    private By loginBtn = By.xpath("//input[@id='login-button']");

    private By pageTitleLbl = By.xpath("(//*[text()='Swag Labs'])[1]");

    private By usernameTextBox = By.xpath("//*[@placeholder='Username']");

    private By passwordTextBox = By.xpath("//*[@placeholder='Password']");

    private By errorMessage =By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']");

    private By closeIcon = By.xpath("//button[@class='error-button']");



    public void VerifyLoginBtnCSSValue(WebDriver driver) throws Exception {
        WaitForElement(loginBtn) ;
        String cssValue = driver.findElement(loginBtn).getCssValue("background-color");
        String buttonColor = Color.fromString(cssValue).asHex();
       String colour = excelHelper.getCellData("Sheet1",1,0);
        Assert.assertEquals(buttonColor, colour);

    }
    public void XIcon(WebDriver driver){
        driver.findElement(closeIcon).click();
    }

    public void VerifyUsernameandPasswordText(WebDriver driver) throws IOException {
        String usernameText = driver.findElement(usernameTextBox).getAttribute("placeholder");
        String password = driver.findElement(passwordTextBox).getAttribute("placeholder");
        String expectedUsername = excelHelper.getCellData("Sheet1",1,1);
        String expectedPassword = excelHelper.getCellData("Sheet1",1,2);
        Assert.assertEquals(usernameText,expectedUsername);
        Assert.assertEquals(password,expectedPassword);

    }

    public void LoginIn(WebDriver driver,String username, String password)
    {
        if( driver.findElement(usernameTextBox).isDisplayed())
        {
            driver.findElement(usernameTextBox).sendKeys(username);
            driver.findElement(passwordTextBox).sendKeys(password);
            driver.findElement(loginBtn).click();



        }

    }

    public void WaitForElement(By element) throws Exception {
        boolean stale = true;
        int retries = 0;
        while(stale && retries < 5) {
            try {
                driver.findElement(element).isDisplayed();
                stale = false;
            } catch (StaleElementReferenceException ex) {
                retries++;
            }
        }
        if (stale) {
            throw new Exception("Element is still stale after 5 attempts");
        }
    }

    public void ErrorMessage(WebDriver driver) throws IOException {
        String errorMsgFromSpreadsheet = excelHelper.getCellData("Sheet1",1,3);
        String errorMsg = driver.findElement(errorMessage).getText();
        Assert.assertEquals(errorMsg, errorMsgFromSpreadsheet);

    }


}

