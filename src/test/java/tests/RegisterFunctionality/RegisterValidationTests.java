package tests.RegisterFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import dataproviders.RegisterDataProvider;
import factory.UserFactory;
import models.User;
import org.testng.annotations.Test;
import pages.RegisterPage;
import services.RegisterService;

public class RegisterValidationTests extends BaseTest {

    @Test
    public void verifyRegisterFormErrorMessagesWithEmptyFields() {
        RegisterPage registerPage = landingPage().navigateToRegisterPage();
        RegisterService registerService = new RegisterService(registerPage);
        User user = UserFactory.createEmptyUser();

        registerService.registerUserWithoutTerms(user);

        softAssert().assertEquals(registerPage.getFirstNameErrorMessage(), FrameworkConstants.FIRSTNAME_ERROR_MSG);
        softAssert().assertEquals(registerPage.getLastNameErrorMessage(), FrameworkConstants.LASTNAME_ERROR_MSG);
        softAssert().assertEquals(registerPage.getEmailErrorMessage(), FrameworkConstants.EMAIL_ERROR_MSG);
        softAssert().assertEquals(registerPage.getTelephoneErrorMessage(), FrameworkConstants.TELEPHONE_ERROR_MSG);
        softAssert().assertEquals(registerPage.getPasswordErrorMessage(), FrameworkConstants.PASSWORD_ERROR_MSG);
        softAssert().assertEquals(registerPage.getWarningMessage(), FrameworkConstants.PRIVACY_POLICY_ERROR_MSG);

        softAssert().assertAll();
    }

    @Test(dataProvider = "existingAccountData", dataProviderClass = RegisterDataProvider.class)
    public void verifyRegistrationWithExistingAccount(String fName, String lName, String emailAddress, String pwd) {
        RegisterPage registerPage = landingPage().navigateToRegisterPage();
        RegisterService registerService = new RegisterService(registerPage);
        User user = new User.UserBuilder()
                .firstName(fName)
                .lastName(lName)
                .email(emailAddress)
                .phone("9876543532")
                .password(pwd)
                .newsletter(true)
                .build();

        registerService.registerNewUser(user);

        softAssert().assertEquals(registerPage.getWarningMessage(), FrameworkConstants.REGISTER_EXISTING_ACCOUNT_ERROR_MSG);

        softAssert().assertAll();
    }
}
