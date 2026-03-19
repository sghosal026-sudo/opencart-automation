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
                {"TC_LF_002", "a@b.com", "21435433"},
                {"TC_LF_003", "piv942@sec.com", "aijSVhnHa8X@sG"},
                {"TC_LF_004", "pivomi3942@sennic.com", "aijSVhnHa8"},
                {"TC_LF_005", "", ""}
        };
    }
}

