package testlink.steps;

import org.openqa.selenium.WebDriver;
import test.pages.HomePage;
import test.pages.LoginPage;

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

    public boolean openTestSpecification ()
    {
        HomePage homePage = new HomePage(driver);
        return homePage.pressTestSpecification().isOpened();
    }
}
