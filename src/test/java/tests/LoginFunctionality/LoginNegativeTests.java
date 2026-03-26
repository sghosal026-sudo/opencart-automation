package tests.LoginFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import dataproviders.LoginDataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.LoginService;

public class LoginNegativeTests extends BaseTest {

    @Test(dataProvider = "invalidCredentials", dataProviderClass = LoginDataProvider.class)
    public void verifyUnsuccessfulLoginWithInvalidCredentials(String email, String password) {
        LoginPage loginPage = landingPage().navigateToLoginPage();
        LoginService loginService = new LoginService(loginPage);

        softAssert().assertTrue(loginPage.isLoginPage(), "User was not navigated to login page.");

        loginService.loginWithValidCredentials(email, password);
        softAssert().assertEquals(loginPage.getUnsuccessfulLoginWarningMsg(), FrameworkConstants.LOGIN_WARNING_MSG, "User was logged in or warning message did not appear.");

        softAssert().assertAll();
    }
}
