package tests.SearchFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.SearchPage;
import services.SearchService;

public class SearchNegativeTests extends BaseTest {

    @Test(description = "Validate searching without providing any Product Name")
    public void validateUnsuccessfulSearchWithEmptyProduct() {
        SearchPage searchPage = landingPage().performSearch("");
        SearchService searchService = new SearchService(searchPage);

        boolean isProductFound = searchService.searchNonExistingProduct("");

        softAssert().assertFalse(isProductFound);
        softAssert().assertEquals(searchPage.getProductNotPresentMessage(), FrameworkConstants.NO_PRODUCTS_MSG, "Product Exists");

        softAssert().assertAll();
    }
}
