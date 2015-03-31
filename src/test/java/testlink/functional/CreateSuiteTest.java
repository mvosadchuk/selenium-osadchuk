package testlink.functional;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.models.TestCase;
import test.models.TestStep;
import test.models.TestSuite;
import test.selenium.DriverFactory;
import testlink.steps.TestSteps;
import utils.PropertyLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class CreateSuiteTest extends TestSteps{

    public static final TestSuite suite = new TestSuite("Test Suite Name [mvo]_3", "Some Details");
    public static final TestCase testCase = new TestCase("Test Case for Test Suite", "Test Case Summary", "Test Case Precondition");
    public static final TestStep step1 = new TestStep("Open page http://demo.testlink.org/latest/login.php", "The page is opened successfully.");
    public static final TestStep step2 = new TestStep("Input valid login and password.", "Login and password were entered.");
    public static final TestStep step3 = new TestStep("Press 'Login' button.", "Login has passed successfully, home page was opened.");
    public static final List<TestStep> steps = Arrays.asList(step1, step2, step3);
    /*
    public static final List<TestStep> steps = new List<TestStep>(){
        add();
    }
    */
/*
    @DataProvider //(name = "TestSuite")
    public static Object [][] testSuiteData () {
        return new Object[][]
                {
                        new Object[]{
                                new TestSuite("Test Suite Name [mvo]_4", "Some Details"),
                                new TestCase("Test Case for Test Suite 4", "Test Case Summary", "Test Case Precondition"),
                                new List<TestStep> Arrays.asList(
                                    new TestStep("Step 1 action", "Step 1 expected result"),
                                    new TestStep("Step 2 action", "Step 2 expected result"),
                                    new TestStep("Step 3 action", "Step 3 expected result"))
                        },

                };
    }
    */

    @BeforeSuite
    public void initEnv()
    {
        //driver = new FirefoxDriver();
        try {
            driver = new DriverFactory().makeDriver(PropertyLoader.loadProperty("browser"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test //(dataProvider = "testSuiteData")
    //public void createSuite(TestSuite suite, TestCase testCase, List<TestStep> steps)
    public void createSuite()
    {
        Assert.assertTrue(login("admin", "admin"),"Login failed.");
        Assert.assertTrue(createTestSuite(suite), "Test Suite was not created.");
        Assert.assertTrue(createTestCase(suite, testCase), "Test case was not created.");
        Assert.assertTrue(createTestStep(suite, testCase, steps), "Test step was not created");
        //Assert.assertTrue(createTestStep(suite, testCase, step1), "Test step was not created");
        //Assert.assertTrue(createTestStep(suite, testCase, step2), "Test step '" + step2.actions + "' was not created");
        //Assert.assertTrue(createTestStep(suite, testCase, step3), "Test step '" + step3.actions + "' was not created");
    }

    @AfterSuite
    public void shutEnv()
    {
        if (driver != null) driver.quit();
    }

}
