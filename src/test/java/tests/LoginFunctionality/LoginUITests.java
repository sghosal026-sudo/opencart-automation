package tests.LoginFunctionality;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginUITests extends BaseTest {

    @Test
    public void verifyForgotPasswordLink() {
        LoginPage loginPage = landingPage().navigateToLoginPage();

        softAssert().assertTrue(loginPage.isLoginPage(), "User was not navigated to login page.");
        softAssert().assertTrue(loginPage.isForgotPasswordLinkPresent(), "ForgotPasswordLink not present");

        softAssert().assertAll();
    }
}
