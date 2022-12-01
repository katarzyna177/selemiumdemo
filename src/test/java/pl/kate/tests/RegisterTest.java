package pl.kate.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.kate.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        int random = (int) (Math.random() * 1000);

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("test" + random + "@test.pl", "test@test.pl")
                .getDashboardLink();

        //Assert.assertTrue(dashboardLink.isDisplayed());
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("test1@test.pl", "test@test.pl")
                .getError();

        //Assert.assertTrue(dashboardLink.isDisplayed());
        Assert.assertTrue(error.getText().contains("An account is already registered with your email address"));
    }
}
