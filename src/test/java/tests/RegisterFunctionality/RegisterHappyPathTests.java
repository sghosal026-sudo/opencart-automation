package tests.RegisterFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import factory.UserFactory;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.NewsletterSubscriptionPage;
import pages.RegisterPage;
import services.RegisterService;
import utilities.TestCaseID;

import java.lang.reflect.Method;

public class RegisterHappyPathTests extends BaseTest {
    RegisterPage registerPage;
    RegisterService registerService;
    
    @BeforeMethod
    public void init(Method method) {
        if (method.isAnnotationPresent(TestCaseID.class)) {
            TestCaseID tc = method.getAnnotation(TestCaseID.class);
            FrameworkConstants.TEST_CASE_ID.set(tc.value());
        }
        
        registerPage = landingPage.navigateToRegisterPage();
        registerService = new RegisterService(registerPage);
    }
    
    @Test
    @TestCaseID("TC_RF_001")
    public void verifySuccessfulRegistrationWithMandatoryFields() {
        User user = UserFactory.createRandomUser();
        AccountSuccessPage accountSuccessPage = registerService.registerNewUserWithoutNewsletter(user);
        
        softAssert.assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert.assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");
        
        softAssert.assertAll();
    }
    
    @Test
    @TestCaseID("TC_RF_002")
    public void verifySuccessfulRegistrationEmail() {
        User user = UserFactory.createRandomUser();
        AccountSuccessPage accountSuccessPage = registerService.registerNewUserWithNewsletter(user);
        
        softAssert.assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert.assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");
        
        softAssert.assertTrue(false, "Email service not available");
        
        softAssert.assertAll();
    }
    
    @Test
    @TestCaseID("TC_RF_003")
    public void verifySuccessfulRegistration() {
        User user = UserFactory.createRandomUser();
        AccountSuccessPage accountSuccessPage = registerService.registerNewUserWithNewsletter(user);
        
        softAssert.assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert.assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");
        
        softAssert.assertAll();
    }
    
    @Test
    @TestCaseID("TC_RF_004")
    public void verifyRegisterFormErrorMessagesWithEmptyFields() {
        User user = UserFactory.createEmptyUser();
        registerService.registerUserWithoutTerms(user);
        
        softAssert.assertEquals(registerPage.getFirstNameErrorMessage(), FrameworkConstants.FIRSTNAME_ERROR_MSG);
        softAssert.assertEquals(registerPage.getLastNameErrorMessage(), FrameworkConstants.LASTNAME_ERROR_MSG);
        softAssert.assertEquals(registerPage.getEmailErrorMessage(), FrameworkConstants.EMAIL_ERROR_MSG);
        softAssert.assertEquals(registerPage.getTelephoneErrorMessage(), FrameworkConstants.TELEPHONE_ERROR_MSG);
        softAssert.assertEquals(registerPage.getPasswordErrorMessage(), FrameworkConstants.PASSWORD_ERROR_MSG);
        softAssert.assertEquals(registerPage.getWarningMessage(), FrameworkConstants.PRIVACY_POLICY_ERROR_MSG);
        
        softAssert.assertAll();
    }
    
    @Test
    @TestCaseID("TC_RF_005")
    public void verifySuccessfulRegistrationWithNewsletter() {
        User user = UserFactory.createRandomUser();
        
        AccountSuccessPage accountSuccessPage = registerService.registerNewUserWithNewsletter(user);
        softAssert.assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert.assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");
        
        AccountPage accountPage = accountSuccessPage.clickContinue();
        softAssert.assertTrue(accountPage.isAccountPage(), "User was not redirected to the Account Page.");
        
        NewsletterSubscriptionPage newsletterSubscriptionPage = accountPage.clickOnNewsletterOption();
        softAssert.assertTrue(newsletterSubscriptionPage.isSubscribed(), "Subscription is incorrect");
        
        softAssert.assertAll();
    }
    
    @Test
    @TestCaseID("TC_RF_006")
    public void verifySuccessfulRegistrationWithoutNewsletter() {
        User user = UserFactory.createRandomUser();
        
        AccountSuccessPage accountSuccessPage = registerService.registerNewUserWithoutNewsletter(user);
        softAssert.assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert.assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");
        
        AccountPage accountPage = accountSuccessPage.clickContinue();
        softAssert.assertTrue(accountPage.isAccountPage(), "User was not redirected to the Account Page.");
        
        NewsletterSubscriptionPage newsletterSubscriptionPage = accountPage.clickOnNewsletterOption();
        softAssert.assertFalse(newsletterSubscriptionPage.isSubscribed(), "Subscription is incorrect");
        
        softAssert.assertAll();
    }
}
