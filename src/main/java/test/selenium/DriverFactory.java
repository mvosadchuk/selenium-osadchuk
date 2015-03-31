package test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Maryna.Osadchuk on 3/31/2015.
 */
public class DriverFactory {
    private static final String FIREFOX = "Firefox";
    private static final String CHROME = "Chrome";

    public static WebDriver makeDriver(String driverName) throws Exception {
        WebDriver driver = null;
        if (driverName == FIREFOX)
        {
            driver = new FirefoxDriver();
        } else {
            if (driverName == CHROME) {
                driver = new ChromeDriver();
            } else {
                throw new Exception();
            }
        } ;

        return driver;

    }
}
