package services;

import models.User;
import pages.AccountSuccessPage;
import pages.RegisterPage;

public class RegisterService {
    RegisterPage registerPage;
    
    public RegisterService(RegisterPage registerPage) {
         this.registerPage = registerPage;
    }
    
    public AccountSuccessPage registerNewUser(User user) {
        return registerPage.performRegistration(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                user.isNewsletter(),
                true
        );
    }
    
    public AccountSuccessPage registerNewUserWithNewsletter(User user) {
         return registerPage.performRegistration(
                 user.getFirstName(),
                 user.getLastName(),
                 user.getEmail(),
                 user.getPhone(),
                 user.getPassword(),
                 true,
                 true
         );
    }
    
    public AccountSuccessPage registerNewUserWithoutNewsletter(User user) {
        return registerPage.performRegistration(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                false,
                true
        );
    }
    
    public void registerUserWithoutTerms(User user) {
        registerPage.performRegistration(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                user.isNewsletter(),
                false
        );
    }
    
}
