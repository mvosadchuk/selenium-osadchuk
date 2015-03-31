package testlink.functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Maryna.Osadchuk on 3/31/2015.
 */
public class AbstractTest {
    protected WebDriver driver;

    @BeforeSuite
    public void initEnv()
    {
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void shutEnv()
    {
        if (driver != null) driver.quit();
    }
}
