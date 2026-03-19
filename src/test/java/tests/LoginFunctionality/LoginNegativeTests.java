package tests.LoginFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import dataproviders.LoginDataProvider;
import org.testng.ITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import services.LoginService;
import utilities.TestCaseID;

import java.lang.reflect.Method;

public class LoginNegativeTests extends BaseTest implements ITest {
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

    @Test(dataProvider = "invalidCredentials", dataProviderClass = LoginDataProvider.class)
    public void verifyUnsuccessfulLoginWithInvalidCredentials(String testID, String email, String password) {
        FrameworkConstants.TEST_CASE_ID.set(testID);

        landingPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.isLoginPage(), "User was not navigated to login page.");

        loginService.loginWithValidCredentials(email, password);
        softAssert.assertEquals(loginPage.getUnsuccessfulLoginWarningMsg(), FrameworkConstants.LOGIN_WARNING_MSG, "User was logged in or warning message did not appear.");

        softAssert.assertAll();
    }

    @Override
    public String getTestName() {
        return "";
    }
}
