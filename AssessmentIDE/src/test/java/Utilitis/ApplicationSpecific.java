package Utilitis;

import io.cucumber.java.Scenario;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.testng.Reporter;
import testBase.Base;

import java.util.Properties;

public class ApplicationSpecific {

    public Base testBase;
    private WebDriver driver;
    Properties prop;

    public ApplicationSpecific(WebDriver driver){
        this.driver=driver;
    }
    public void getProperty()
    {
        testBase = new Base();
        prop = testBase.initializeProp();
    }

    public String getValue(String value)
    {
        getProperty();
        return prop.getProperty(value);
    }
    @Before
    public void launchBrowser()
    {
        getProperty();
        String broswerName  = prop.getProperty("browser");
        driver = testBase.initializeBroswer(broswerName);
        driver.navigate().to(prop.getProperty("url"));
    }

    @After
    public void quitBrowser()
    {
        driver.quit();
      /*  if (scenario.isFailed())
        {
            String screenshotName = scenario.getName().replace("","_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png", screenshotName);
        }*/
    }

    //Check if an alert is displayed.
    public static boolean isAlertPresent(WebDriver driver) {
        try {

            driver.switchTo().alert();
            return true;

        } catch (NoAlertPresentException ex) {
            return false;
        }

    }

    public void getAcceptAlert(WebDriver driver, String strAlertText) {
        try {

            if (isAlertPresent(driver)) {

                Alert alert = driver.switchTo().alert();
                String GetAlertText = alert.getText();

                if (GetAlertText.contains(strAlertText)) {

                    alert.accept();
                } else {
                    Reporter.log("Alert message don't match the expetected");
                }
            }

        } catch (Exception e) {
            //exception handling
        }
    }

    public String generateRandomValue(int length) {
        //int length = 10;

    boolean useLetters = false;

    boolean useNumbers = true;

    String generatedValue = RandomStringUtils.random(length, useLetters, useNumbers);

    System.out.println(generatedValue);

    return generatedValue;

 }

}
