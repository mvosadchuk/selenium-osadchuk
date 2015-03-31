package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Maryna.Osadchuk on 3/24/2015.
 */
public class AbstractPage {
    protected WebDriver driver;

    private static final By headerFrame = By.name("titlebar");
    private static final By mainFrame = By.name("mainframe");
    private static final By treeFrame = By.name("treeframe");
    private static final By workFrame = By.name("workframe");

    public AbstractPage (WebDriver driver)
    {
        this.driver = driver;
    }

    protected void switchToTitleBar()
    {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(headerFrame));
    }

    protected void switchToMainFrame()
    {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
    }

    protected void switchToTreeFrame()
    {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(treeFrame));
    }

    protected void switchToWorkFrame()
    {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
    }
}
