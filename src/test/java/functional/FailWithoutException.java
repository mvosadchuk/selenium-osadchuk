package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class FailWithoutException {
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
    public void failWithoutException ()
    {
        driver.get("http://www.google.com/");
        boolean elementFound;
        try
        {
            driver.findElement(By.id("absentClassId"));
            elementFound = true;
        } catch (NoSuchElementException e)
        {
            elementFound = false;
        }

        //Assert.assertTrue(elementFound, "Element was not found!");

        if (elementFound)
        {
            System.out.println("Success: the element was found.");
        }
        else
        {
            System.out.println("Failed: element wasn't detected.");
        }

    }
}
