package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maryna.Osadchuk on 3/17/2015.
 */
public class FindJobPositions {
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
    public void findJobPositions () {
        //WebDriver driver = new FirefoxDriver();
        driver.get("http://valvesoftware.com/jobs/job_postings.html");
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("job_position_container")));

        boolean developerFound = false;
        boolean psychoFound = false;

        try
        {
            driver.findElement(By.xpath("//div[contains(@id, 'software_engineer')]"));
            developerFound = true;
        } catch (NoSuchElementException e)
        {
            developerFound = false;
        }

        try
        {
            //driver.findElement(By.cssSelector(".job_position_container[id*='psychologist']"));
            //driver.findElement(By.cssSelector("div.job_position_container[id*='psychologist']"));
            driver.findElement(By.cssSelector("div[id*='psychologist']"));
            psychoFound = true;
        } catch (NoSuchElementException e)
        {
            psychoFound = false;
        }

        Assert.assertTrue(developerFound, "Developer not found");
        Assert.assertTrue(psychoFound, "Psychologist not found");

        if (developerFound)
        {
            System.out.println("Developer job opening was found.");
        } else
        {
            System.out.println("Developer job opening was NOT detected on the page.");
        }

        if (psychoFound)
        {
            System.out.println("Psychologist job opening was found.");
        } else
        {
            System.out.println("Psychologist job opening was NOT detected on the page.");
        }

    }
}
