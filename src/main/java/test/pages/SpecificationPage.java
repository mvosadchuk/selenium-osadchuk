package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.models.TestCase;
import test.models.TestStep;
import test.models.TestSuite;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class SpecificationPage extends AbstractPage {

    private static final By settingsBtn = By.xpath("//img[@title = 'Actions']");
    private static final By testSpecButton = By.xpath("//a[@accesskey='t']");

    private static final By createSuiteBtn = By.id("new_testsuite");
    private static final By suiteNameInput = By.id("name");
    private static final By detailsFrame = By.xpath("//iframe[@title='Rich text editor, details']");
    private static final By saveSuiteBtn = By.name("add_testsuite_button");

    private static final By editBoxBody = By.tagName("body");

    private static final By createTestCaseBtn = By.id("create_tc");
    private static final By testCaseInput = By.id("testcase_name");
    private static final By summaryFrame = By.xpath("//iframe[@title='Rich text editor, summary']");
    private static final By preconditionsFrame = By.xpath("//iframe[@title='Rich text editor, preconditions']");
    private static final By saveTestCaseBtn = By.id("do_create_button");

    private static final By createStepBtn = By.name("create_step");
    private static final By stepActionsFrame = By.xpath("//iframe[@title='Rich text editor, steps']");
    private static final By expectedResultFrame = By.xpath("//iframe[@title='Rich text editor, expected_results']");
    private static final By saveStepAndExitBtn = By.id("do_update_step_and_exit");



    public SpecificationPage(WebDriver driver)
    {
        super(driver);
    }

    public void open ()
    {
        switchToTitleBar();
        driver.findElement(testSpecButton).click();
    }

    public void openTestSuite (TestSuite suite)
    {
        //By suiteName = By.xpath("//div[@id='tree_div']//ul[@class='x-tree-node-ct']//a[@class='x-tree-node-anchor'][contains(text(),'"+ suite.name + "')]");
        //By suiteName = By.xpath("//li[@class='x-tree-node']/div[contains(@id,'extdd')]/a[@class='x-tree-node-anchor']/span[contains(@id,'extdd')]/span[contains(text(),'"+ suite.name + "')]");
        //
        By suiteName = By.xpath("//li[@class='x-tree-node']/div[contains(@id,'extdd')]/a[@class='x-tree-node-anchor']/span[contains(@id,'extdd')]/span[contains(text(),'"+ suite.name + "')]");

        //By suiteName = By.xpath("//div[@id='tree_div']//ul[@class='x-tree-node-ct']//a[contains(text(),'"+ suite.name + "')]");
        WebDriverWait wait = new WebDriverWait(driver, 15);

        switchToTreeFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(suiteName));
        driver.findElement(suiteName).click();

        //action.doubleClick(driver.findElement(suiteName));
    }

    public void openTestCase (TestSuite suite, TestCase testCase)
    {
        //openTestSuite(suite);
        //driver.findElement(By.xpath("//li[@class='x-tree-node']/div[contains(@id,'extdd')]/a[@class='x-tree-node-anchor']/span[contains(text(),'" + testCase.name + "')]")).click();

        By suiteName = By.xpath("//li[@class='x-tree-node']/div[contains(@id,'extdd')]/a[@class='x-tree-node-anchor']/span[contains(@id,'extdd')]/span[contains(text(),'"+ suite.name + "')]");
        By testCaseName = By.xpath("//li[@class='x-tree-node']/div/a[@class='x-tree-node-anchor']/span[contains(text(),'" + testCase.name + "')]");
        Actions action = new Actions(driver);
        switchToTreeFrame();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(suiteName));
        action.moveToElement(driver.findElement(suiteName)).doubleClick().build().perform();
        switchToTreeFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(testCaseName));
        driver.findElement(testCaseName).click();
    }

    public void createSuite (TestSuite suite)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(settingsBtn));
        driver.findElement(settingsBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createSuiteBtn));
        driver.findElement(createSuiteBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(suiteNameInput));
        driver.findElement(suiteNameInput).sendKeys(suite.name);
        driver.switchTo().frame(driver.findElement(detailsFrame));
        driver.findElement(editBoxBody).sendKeys(suite.details);
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(saveSuiteBtn));
        driver.findElement(saveSuiteBtn).click();
    }

    public void createTestCase (TestSuite suite, TestCase testCase)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        openTestSuite(suite);
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(settingsBtn));
        driver.findElement(settingsBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createTestCaseBtn));
        driver.findElement(createTestCaseBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(testCaseInput));
        driver.findElement(testCaseInput).sendKeys(testCase.name);
        driver.switchTo().frame(driver.findElement(summaryFrame));
        driver.findElement(editBoxBody).sendKeys(testCase.summary);
        switchToWorkFrame();
        driver.switchTo().frame(driver.findElement(preconditionsFrame));
        driver.findElement(editBoxBody).sendKeys(testCase.preconditions);
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(saveTestCaseBtn));
        driver.findElement(saveTestCaseBtn).click();
    }

    /*
    public void createTestStep (TestSuite suite, TestCase testCase, TestStep step)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        openTestCase(suite, testCase);
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(createStepBtn));
        driver.findElement(createStepBtn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(stepActionsFrame));
        driver.switchTo().frame(driver.findElement(stepActionsFrame));
        driver.findElement(editBoxBody).sendKeys(step.actions);
        switchToWorkFrame();
        driver.switchTo().frame(driver.findElement(expectedResultFrame));
        driver.findElement(editBoxBody).sendKeys(step.expectedResult);
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(saveStepBtn));
        driver.findElement(saveStepBtn).click();
    }
    */

    public void createTestStep (TestSuite suite, TestCase testCase, List<TestStep> steps)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        openTestCase(suite, testCase);
        switchToWorkFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(createStepBtn));
        for (TestStep step : steps) {
            driver.findElement(createStepBtn).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(stepActionsFrame));
            driver.switchTo().frame(driver.findElement(stepActionsFrame));
            driver.findElement(editBoxBody).sendKeys(step.actions);
            switchToWorkFrame();
            driver.switchTo().frame(driver.findElement(expectedResultFrame));
            driver.findElement(editBoxBody).sendKeys(step.expectedResult);
            switchToWorkFrame();
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(saveStepAndExitBtn));
            driver.findElement(saveStepAndExitBtn).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(createStepBtn));
        }
    }
}
