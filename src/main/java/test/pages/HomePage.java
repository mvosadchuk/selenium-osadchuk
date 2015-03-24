package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class HomePage {
    protected WebDriver driver;

    private static final By headerFrame = By.name("titlebar");
    private static final By mainFrame = By.name("mainframe");
    private static final By treeFrame = By.name("treeframe");
    private static final By testSpecButton = By.cssSelector("a[href* = 'editTc']");

    private static final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");

    public HomePage (WebDriver driver)
    {
        this.driver = driver;
    }

    public boolean isOpened()
    {
        //return driver.findElements(version).size() > 0;
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(headerFrame));
        driver.switchTo().frame(driver.findElement(headerFrame));
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
        return !driver.findElements(version).isEmpty();
    }

    public SpecificationPage pressTestSpecification ()
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        //wait.until(ExpectedConditions.presenceOfElementLocated(headerFrame));
        driver.switchTo().frame(driver.findElement(headerFrame));
        driver.findElement(testSpecButton).click();
        return new SpecificationPage(driver);
    }
}
