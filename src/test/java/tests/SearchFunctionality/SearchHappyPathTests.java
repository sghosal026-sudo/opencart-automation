package tests.SearchFunctionality;

import constants.FrameworkConstants;
import core.BaseTest;
import dataproviders.SearchDataProvider;
import org.testng.annotations.Test;
import pages.SearchPage;
import services.SearchService;

public class SearchHappyPathTests extends BaseTest {

    @Test(
            dataProvider = "existingProductData",
            dataProviderClass = SearchDataProvider.class,
            description = "Validate searching with an existing Product Name"
    )
    public void validateSuccessfulSearchWithExistingProduct(String product) {
        SearchPage searchPage = landingPage().performSearch(product);
        SearchService searchService = new SearchService(searchPage);

        boolean isProductFound = searchService.searchExistingProduct(product);

        softAssert().assertTrue(isProductFound, "Either the product was not found or the product name has a typo.");

        softAssert().assertAll();
    }

    @Test(
            dataProvider = "nonExistingProductData",
            dataProviderClass = SearchDataProvider.class,
            description = "Validate searching with an non existing Product Name"
    )
    public void validateUnsuccessfulSearchWithNonExistingProduct(String product) {
        SearchPage searchPage = landingPage().performSearch(product);
        SearchService searchService = new SearchService(searchPage);

        boolean isProductFound = searchService.searchNonExistingProduct(product);

        softAssert().assertFalse(isProductFound);
        softAssert().assertEquals(searchPage.getProductNotPresentMessage(), FrameworkConstants.NO_PRODUCTS_MSG, "Product Exists");

        softAssert().assertAll();
    }
}
