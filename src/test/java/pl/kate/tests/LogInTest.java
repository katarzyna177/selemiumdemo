package pl.kate.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.kate.pages.HomePage;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData("test1@test.pl", "test@test.pl")
                .getDashboardLink();

        //Assert.assertTrue(dashboardLink.isDisplayed());
        //Assert.assertEquals(dashboardLink.getText(), "Dashboard");
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInWithInvalidPasswordTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("test1@test.pl", "tet@test.pl")
                .getError();

        //Assert.assertTrue(dashboardLink.isDisplayed());
        Assert.assertTrue(error.getText().contains("Incorrect username or password."), "Expected error text doesn't match");
    }
}
