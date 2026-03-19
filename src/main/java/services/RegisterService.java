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
