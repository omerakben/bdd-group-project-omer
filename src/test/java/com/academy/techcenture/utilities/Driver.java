package com.academy.techcenture.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver() {
    }//no instantiation allowed

    //private static WebDriver driver;// Taking this away for parallel testing
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();// creating driver pool object so that parallel testing is possible (multiple threads)

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            String browserType = ConfigReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());

                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());

                    break;
                default:
                    System.out.println("Unknown Browser Type " + browserType);
            }
            driverPool.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //trigger when the driver cant find an element. It  gives extra time to do it.if time passes, and it does not find it; it will return exception or empty list.
            return driverPool.get();
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();//This terminates the session
            driverPool.remove();// reset driver value to null so It can always use only one and the same instance of the object.
        }
    }
}
