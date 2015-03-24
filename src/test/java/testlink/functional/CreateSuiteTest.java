package testlink.functional;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import testlink.steps.TestSteps;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class CreateSuiteTest extends TestSteps{
    @BeforeSuite
    public void initEnv()
    {
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
    }

    @Test
    public void createSuite()
    {
        Assert.assertTrue(login("admin", "admin"),"Login failed.");
        //Assert.assertTrue(openTestSpecification(), "Specification page could not be opened.");
    }

    @AfterSuite
    public void shutEnv()
    {
        if (driver != null) driver.quit();
    }

}
