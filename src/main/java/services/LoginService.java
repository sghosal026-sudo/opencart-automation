package services;

import pages.AccountPage;
import pages.LoginPage;

public class LoginService {
    LoginPage loginPage;

    public LoginService(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public AccountPage loginWithValidCredentials(String email, String password) {
        return loginPage.performLogin(email, password);
    }

    public void loginWithInvalidCredentials(String email, String password) {
        loginPage.performLogin(email, password);
    }
}
