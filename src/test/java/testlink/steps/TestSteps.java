package testlink.steps;

import org.openqa.selenium.WebDriver;
import test.models.TestCase;
import test.models.TestStep;
import test.models.TestSuite;
import test.pages.HomePage;
import test.pages.LoginPage;
import test.pages.SpecificationPage;

import java.util.List;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class TestSteps {
    protected WebDriver driver;

    public boolean login(String login, String password)
    {
        LoginPage loginPage = new LoginPage(driver); //loginPage will be removed by garbage collector
        loginPage.open();
        return loginPage.login(login, password).isOpened(); //returns true if page is opened
    }

    public boolean createTestSuite(TestSuite suite)
    {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        //specificationPage.createSuite(new TestSuite());
        specificationPage.createSuite(suite);
        return true;
    }

    public boolean createTestCase(TestSuite suite, TestCase testCase)
    {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.createTestCase(suite, testCase);
        return true;
    }

    /*
    public boolean createTestStep(TestSuite suite, TestCase testCase, TestStep step)
    {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.createTestStep(suite, testCase, step);
        return true;
    }
    */

    public boolean createTestStep(TestSuite suite, TestCase testCase, List<TestStep> steps)
    {
        SpecificationPage specificationPage = new SpecificationPage(driver);
        specificationPage.open();
        specificationPage.createTestStep(suite, testCase, steps);
        return true;
    }
}
