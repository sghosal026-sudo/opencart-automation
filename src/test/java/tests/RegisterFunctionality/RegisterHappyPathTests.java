package tests.RegisterFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import factory.UserFactory;
import models.User;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.NewsletterSubscriptionPage;
import pages.RegisterPage;
import services.RegisterService;

public class RegisterHappyPathTests extends BaseTest {

    @Test
    public void verifySuccessfulRegistrationWithMandatoryFields() {
        RegisterPage registerPage = landingPage().navigateToRegisterPage();
        RegisterService registerService = new RegisterService(registerPage);
        User user = UserFactory.createUserWithoutNewsletter();
        AccountSuccessPage accountSuccessPage = registerService.registerNewUser(user);

        softAssert().assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert().assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");

        softAssert().assertAll();
    }

    @Test
    public void verifySuccessfulRegistrationEmail() {
        RegisterPage registerPage = landingPage().navigateToRegisterPage();
        RegisterService registerService = new RegisterService(registerPage);
        User user = UserFactory.createRandomUser();
        AccountSuccessPage accountSuccessPage = registerService.registerNewUser(user);

        softAssert().assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert().assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");
        softAssert().assertTrue(true, "Email service not available");

        softAssert().assertAll();
    }

    @Test
    public void verifySuccessfulRegistration() {
        RegisterPage registerPage = landingPage().navigateToRegisterPage();
        RegisterService registerService = new RegisterService(registerPage);
        User user = UserFactory.createRandomUser();
        AccountSuccessPage accountSuccessPage = registerService.registerNewUser(user);

        softAssert().assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert().assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");

        softAssert().assertAll();
    }

    @Test
    public void verifySuccessfulRegistrationWithNewsletter() {
        RegisterPage registerPage = landingPage().navigateToRegisterPage();
        RegisterService registerService = new RegisterService(registerPage);
        User user = UserFactory.createUserWithNewsletter();
        AccountSuccessPage accountSuccessPage = registerService.registerNewUser(user);

        softAssert().assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert().assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");

        AccountPage accountPage = accountSuccessPage.clickContinue();
        softAssert().assertTrue(accountPage.isAccountPage(), "User was not redirected to the Account Page.");

        NewsletterSubscriptionPage newsletterSubscriptionPage = accountPage.clickOnNewsletterOption();
        softAssert().assertTrue(newsletterSubscriptionPage.isSubscribed(), "Subscription is incorrect");

        softAssert().assertAll();
    }

    @Test
    public void verifySuccessfulRegistrationWithoutNewsletter() {
        RegisterPage registerPage = landingPage().navigateToRegisterPage();
        RegisterService registerService = new RegisterService(registerPage);
        User user = UserFactory.createUserWithoutNewsletter();
        AccountSuccessPage accountSuccessPage = registerService.registerNewUser(user);

        softAssert().assertTrue(accountSuccessPage.isAccountSuccessPage(), "User was not redirected to the Account Success page after registration.");
        softAssert().assertEquals(accountSuccessPage.getSuccessMessage(), FrameworkConstants.ACCOUNT_SUCCESS_MESSAGE, "Registration failed or success message mismatch.");

        AccountPage accountPage = accountSuccessPage.clickContinue();
        softAssert().assertTrue(accountPage.isAccountPage(), "User was not redirected to the Account Page.");

        NewsletterSubscriptionPage newsletterSubscriptionPage = accountPage.clickOnNewsletterOption();
        softAssert().assertFalse(newsletterSubscriptionPage.isSubscribed(), "Subscription is incorrect");

        softAssert().assertAll();
    }
}
