package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class HomePage extends AbstractPage {

    private static final By version = By.xpath("//div[@class='menu_title']/span[contains(text(),'TestLink')]");

    public HomePage (WebDriver driver)
    {
        super(driver);
    }

    public boolean isOpened()
    {
        //return driver.findElements(version).size() > 0;
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.presenceOfElementLocated(headerFrame));
        switchToTitleBar();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(version));
        return !driver.findElements(version).isEmpty();
    }
}
