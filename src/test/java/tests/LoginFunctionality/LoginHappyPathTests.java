package tests.LoginFunctionality;

import core.BaseTest;
import dataproviders.LoginDataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import services.LoginService;

public class LoginHappyPathTests extends BaseTest {

    @Test(dataProvider = "validCredentials", dataProviderClass = LoginDataProvider.class)
    public void verifySuccessfulLoginWithValidCredentials(String email, String password) {
        LoginPage loginPage = landingPage().navigateToLoginPage();
        LoginService loginService = new LoginService(loginPage);

        softAssert().assertTrue(loginPage.isLoginPage(), "User was not navigated to login page.");

        AccountPage accountPage = loginService.loginWithValidCredentials(email, password);
        softAssert().assertTrue(accountPage.isAccountPage(), "User was not navigated to Account Page or login failed.");

        softAssert().assertAll();
    }

    @Test
    public void verifyForgotPasswordLink() {
        LoginPage loginPage = landingPage().navigateToLoginPage();

        softAssert().assertTrue(loginPage.isLoginPage(), "User was not navigated to login page.");
        softAssert().assertTrue(loginPage.isForgotPasswordLinkPresent(), "ForgotPasswordLink not present");

        softAssert().assertAll();
    }
}
