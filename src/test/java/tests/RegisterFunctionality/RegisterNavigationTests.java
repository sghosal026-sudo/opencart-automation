package tests.RegisterFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.TestCaseID;

import java.lang.reflect.Method;

public class RegisterNavigationTests extends BaseTest {
    @BeforeMethod
    public void init(Method method) {
        if (method.isAnnotationPresent(TestCaseID.class)) {
            TestCaseID tc = method.getAnnotation(TestCaseID.class);
            FrameworkConstants.TEST_CASE_ID.set(tc.value());
        }
    }
    
    @Test
    @TestCaseID("TC_RF_007")
    public void verifyDifferentRegisterPageNavigation() {
        RegisterPage registerPage1 = landingPage.navigateToRegisterPage();
        softAssert.assertTrue(registerPage1.isRegisterPage(), "User not navigated to register page from Landing Page.");
        
        LoginPage loginPage1 = landingPage.navigateToLoginPage();
        RegisterPage registerPage2 = loginPage1.clickNewCustomerContinueBtn();
        softAssert.assertTrue(registerPage2.isRegisterPage(), "User not navigated to register page from Login Page via New Customer Continue Button.");
        
        LoginPage loginPage2 = landingPage.navigateToLoginPage();
        RegisterPage registerPage3 = loginPage2.clickNewCustomerContinueBtn();
        softAssert.assertTrue(registerPage3.isRegisterPage(), "User not navigated to register page from Login Page via Register Option.");
        
        softAssert.assertAll();
    }
}
