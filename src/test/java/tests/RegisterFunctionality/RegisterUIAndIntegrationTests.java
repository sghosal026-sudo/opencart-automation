package tests.RegisterFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import factory.UserFactory;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountSuccessPage;
import pages.RegisterPage;
import services.RegisterService;
import utilities.TestCaseID;

import java.lang.reflect.Method;

public class RegisterUIAndIntegrationTests extends BaseTest {
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
}
