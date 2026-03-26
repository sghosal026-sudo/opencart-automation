package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "validCredentials")
    public Object[][] validLoginCredentials() {
        return new Object[][]{
                {"pivomi3942@sennic.com", "aijSVhnHa8X@sG"}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidLoginCredentials() {
        return new Object[][]{
                {"a@b.com", "21435433"},
                {"piv942@sec.com", "aijSVhnHa8X@sG"},
                {"pivomi3942@sennic.com", "aijSVhnHa8"},
                {"", ""}
        };
    }
}
