package dataproviders;

import org.testng.annotations.DataProvider;

public class SearchDataProvider {
    @DataProvider(name = "existingProductData")
    public Object[][] existingProductData() {
        return new Object[][]{
                {"iMac"}
        };
    }

    @DataProvider(name = "nonExistingProductData")
    public Object[][] nonExistingProductData() {
        return new Object[][]{
                {"FitBit"}
        };
    }
}
