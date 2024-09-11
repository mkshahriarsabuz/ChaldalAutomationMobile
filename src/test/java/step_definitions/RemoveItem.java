package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.ShoppingBagPage;

public class RemoveItem {

    HomePage homepage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    ShoppingBagPage shoppingBagPage = new ShoppingBagPage();

    @Given("Search item {string}")
    public void searchItem(String arg0) {
        System.out.println("print 1");
       homepage.clickOnElement(homepage.searchButton);
        System.out.println("print 2");
       searchResultPage.writeOnAElement(searchResultPage.searchProductInputBox,arg0);
    }

    @And("Scroll down to an item and Open the Item screen")
    public void scrollDownToAnItemAndOpenTheItemScreen() {
        searchResultPage.clickOnElement(searchResultPage.product);
    }

    @And("Click the Plus + icon {int} times to add to the cart")
    public void clickThePlusIconTimesToAddToTheCart(int arg0) {

        for (int i=0; i<arg0;i++) {
            productDetailsPage.clickOnElement(productDetailsPage.addCartButton);
        }
        productDetailsPage.clickOnElement(productDetailsPage.closeButton);
    }

    @And("Go to the cart screen from the top")
    public void goToTheCartScreenFromTheTop() {
        searchResultPage.clickOnElement(searchResultPage.shoppingBagButton);
    }

    @When("Click the Minus - icon to empty the cart")
    public void clickTheMinusIconToEmptyTheCart() {
        boolean value = shoppingBagPage.isElementVisible(shoppingBagPage.productMinusButton);
        while (value){
            shoppingBagPage.clickOnElement(shoppingBagPage.productMinusButton);
            value = shoppingBagPage.isElementVisible(shoppingBagPage.productMinusButton);
        }
    }

    @Then("Verify Text {string} on cart screen after removing items")
    public void verifyTextOnCartScreenAfterRemovingItems(String arg0) {
        Assert.assertTrue(shoppingBagPage.isElementVisible(shoppingBagPage.bodyText));
        Assert.assertEquals(shoppingBagPage.getElementText(shoppingBagPage.bodyText),arg0);
    }
}
