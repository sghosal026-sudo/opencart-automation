package tests.LoginFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import dataproviders.LoginDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import services.LoginService;
import utilities.TestCaseID;

import java.lang.reflect.Method;

public class LoginHappyPathTests extends BaseTest {
    LoginPage loginPage;
    LoginService loginService;

    @BeforeMethod
    public void init(Method method) {
        if (method.isAnnotationPresent(TestCaseID.class)) {
            TestCaseID tc = method.getAnnotation(TestCaseID.class);
            FrameworkConstants.TEST_CASE_ID.set(tc.value());
        }

        loginPage = landingPage.navigateToLoginPage();
        loginService = new LoginService(loginPage);
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = LoginDataProvider.class)
    @TestCaseID("TC_LF_001")
    public void verifySuccessfulLoginWithValidCredentials(String email, String password) {
        landingPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.isLoginPage(), "User was not navigated to login page.");

        AccountPage accountPage = loginService.loginWithValidCredentials(email, password);
        softAssert.assertTrue(accountPage.isAccountPage(), "User was not navigated to Account Page or login failed.");

        softAssert.assertAll();
    }


    @Test
    @TestCaseID("TC_LF_006")
    public void verifyForgotPasswordLink() {
        landingPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.isLoginPage(), "User was not navigated to login page.");

        softAssert.assertTrue(loginPage.isForgotPasswordLinkPresent(), "ForgotPasswordLink not present");

        softAssert.assertAll();
    }
}
