package tests.LoginFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.LoginService;
import utilities.TestCaseID;

import java.lang.reflect.Method;

public class LoginUITests extends BaseTest {
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

    @Test
    @TestCaseID("TC_LF_006")
    public void verifyForgotPasswordLink() {
        landingPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.isLoginPage(), "User was not navigated to login page.");

        softAssert.assertTrue(loginPage.isForgotPasswordLinkPresent(), "ForgotPasswordLink not present");

        softAssert.assertAll();
    }
}
