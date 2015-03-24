package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Maryna.Osadchuk on 3/20/2015.
 */
public class LoginPage {

    protected WebDriver driver;

    private static final String URL = "http://demo.testlink.org/latest/login.php";
    private static final By loginField = By.id("login");
    private static final By passwordField = By.name("tl_password");
    private static final By loginButton = By.name("login_submit");

    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public void open ()
    {
        driver.get(URL);

    }

    public HomePage login (String login, String password)
    {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
