package dataproviders;

import org.testng.annotations.DataProvider;

public class RegisterDataProvider {
    
    @DataProvider(name = "existingAccountData")
    public Object[][] existingAccountData() {
        return new Object[][] {
                {"Ganga", "Pandey", "ganga@gmail.com", "Pass1234"}
        };
    }
}
