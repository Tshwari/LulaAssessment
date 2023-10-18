package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;

    public Properties prop;
   public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static ThreadLocal<Properties> tlProp = new ThreadLocal<>();
    public WebDriver initializeBroswer(String browserNname)
    {
        if(browserNname.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());

        }
        else if(browserNname.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        }
        else if (browserNname.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else {
            System.out.println("Please pass the correct browser value: "+ browserNname);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
        return tlDriver.get();
    }

    public static synchronized Properties getProp()
    {
        return tlProp.get();
    }


    public Properties initializeProp()
    {
        prop = new Properties();
        try{
            FileInputStream ip = new FileInputStream("./src/test/config/config.properties");
            prop.load(ip);
            tlProp.set(new Properties());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop;
    }
}
