package tests.RegisterFunctionality;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterNavigationTests extends BaseTest {

    @Test
    public void verifyDifferentRegisterPageNavigation() {
        RegisterPage registerPage1 = landingPage().navigateToRegisterPage();
        softAssert().assertTrue(registerPage1.isRegisterPage(), "User not navigated to register page from Landing Page.");

        LoginPage loginPage1 = landingPage().navigateToLoginPage();
        RegisterPage registerPage2 = loginPage1.clickNewCustomerContinueBtn();
        softAssert().assertTrue(registerPage2.isRegisterPage(), "User not navigated to register page from Login Page via New Customer Continue Button.");

        LoginPage loginPage2 = landingPage().navigateToLoginPage();
        RegisterPage registerPage3 = loginPage2.clickNewCustomerContinueBtn();
        softAssert().assertTrue(registerPage3.isRegisterPage(), "User not navigated to register page from Login Page via Register Option.");

        softAssert().assertAll();
    }
}
