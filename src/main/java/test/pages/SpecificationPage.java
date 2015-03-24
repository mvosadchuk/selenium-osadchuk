package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class SpecificationPage {
    protected WebDriver driver;

    private static final By treeNodeID = By.id("extdd-4");
    private static final By settingsPanel = By.id("settings_panel");
    private static final By mainFrame = By.name("mainframe");
    private static final By workFrame = By.name("workframe");
    private static final By settingsBtn = By.cssSelector("img.clickable[title* = 'Action']");

    public SpecificationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean isOpened()
    {
        driver.switchTo().frame(driver.findElement(mainFrame));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(settingsPanel));
        return !driver.findElements(settingsPanel).isEmpty();
    }

    public void createTestSuite ()
    {
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.findElement(treeNodeID).click();
        driver.switchTo().frame(driver.findElement(workFrame));
        driver.findElement(settingsBtn).click();
    }
}
