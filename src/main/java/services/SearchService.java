package services;

import pages.SearchPage;

public class SearchService {
    SearchPage searchPage;

    public SearchService(SearchPage searchPage) {
        this.searchPage = searchPage;
    }

    public boolean searchExistingProduct(String product) {
        return searchPage.isProductFound(product);
    }

    public boolean searchNonExistingProduct(String product) {
        return searchPage.isProductFound(product);
    }
}
