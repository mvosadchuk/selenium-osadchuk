package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maryna.Osadchuk on 3/13/2015.
 */
public class FirstClass {

    private static final By searchField = By.id("lst-ib");
    private static final By nextButton = By.id("pnnext");
    private static final By resultStatistics = By.id("resultStats");

    public WebDriver driver;

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

    @DataProvider
    public Object[][] keyWords() {
        return new Object[][] {
                //new Object[] {"word", "fhgfghj"},
                new Object[] {"word", "www.shockwave.com"},
                new Object[] {"осциллограф", "www.tehencom.com"},
        };
    }

    @Test (dataProvider = "keyWords")
    public void firstClass (String keyWord, String url) throws FileNotFoundException {
        System.out.println("=== Test for the following inputs:===");
        System.out.println("keyWord = " + keyWord + "; url = " + url);
        driver.get("http://www.google.com/");
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(keyWord);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(resultStatistics));

        boolean found = false;
        int pageNumber = 1;

        while ((pageNumber <= 3) && (!found))
        {
            if (pageNumber != 1)
            {
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(nextButton));
                driver.findElement(nextButton).click();
                driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
                //new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(resultStatistics));
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("cite")));
            }
            System.out.println("Iteration # " + pageNumber);
            try
            {
                driver.findElement(By.xpath("//cite[contains(., '" + url + "')]"));
                found = true;
                System.out.println("Site was found in search results, page # " + pageNumber);
            }
            catch (NoSuchElementException e)
            {
                found = false;
                System.out.println("Site was not found in search results on page # " + pageNumber);
            }
            pageNumber = pageNumber + 1;
        }

        if (found == false)
        {
            System.out.println("Site was not found in first 3 pages of search results!");
        }

        //driver.quit();
    }
}
