package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class FailWithException {
    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@Before Suite");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@After Suite");
        driver.quit();
    }

    @Test
    public void failWithException ()
    {
        driver.get("http://www.google.com/");
        driver.findElement(By.id("absentClassId"));
        System.out.println("If the test didn't fail, then the element was found.");

    }
}
