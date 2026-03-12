package constants;

public class FrameworkConstants {
    public static ThreadLocal<String> TEST_CASE_ID = new ThreadLocal<>();
    
    //Account Success Page
    public static final String ACCOUNT_SUCCESS_MESSAGE = "Your Account Has Been Created!";
    
    //Register Page
    public static final String FIRSTNAME_ERROR_MSG = "First Name must be between 1 and 32 characters!";
    public static final String LASTNAME_ERROR_MSG = "Last Name must be between 1 and 32 characters!";
    public static final String EMAIL_ERROR_MSG = "E-Mail Address does not appear to be valid!";
    public static final String TELEPHONE_ERROR_MSG = "Telephone must be between 3 and 32 characters!";
    public static final String PASSWORD_ERROR_MSG = "Password must be between 4 and 20 characters!";
    public static final String PRIVACY_POLICY_ERROR_MSG = "Warning: You must agree to the Privacy Policy!";
    public static final String REGISTER_EXISTING_ACCOUNT_ERROR_MSG = "Warning: E-Mail Address is already registered!";
}
