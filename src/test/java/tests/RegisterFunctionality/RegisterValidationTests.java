package tests.RegisterFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import dataproviders.RegisterDataProvider;
import factory.UserFactory;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import services.RegisterService;
import utilities.TestCaseID;

import java.lang.reflect.Method;

public class RegisterValidationTests extends BaseTest {
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
    
    @Test(dataProvider = "existingAccountData", dataProviderClass = RegisterDataProvider.class)
    @TestCaseID("TC_RF_008")
    public void verifyRegistrationWithExistingAccount(String fName, String lName, String emailAddress, String pwd) {
        User user = new User.UserBuilder()
                .firstName(fName)
                .lastName(lName)
                .email(emailAddress)
                .phone("9876543532")
                .password(pwd)
                .newsletter(true)
                .build();
        registerService.registerNewUser(user);
        
        softAssert.assertEquals(registerPage.getWarningMessage(), FrameworkConstants.REGISTER_EXISTING_ACCOUNT_ERROR_MSG);
        
        softAssert.assertAll();
    }
}
