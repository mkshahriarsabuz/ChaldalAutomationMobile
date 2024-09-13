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

import static utilities.DriverSetup.getDriver;

public class RemoveItem {

    HomePage homepage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    ShoppingBagPage shoppingBagPage = new ShoppingBagPage();

    @Given("Search item {string}")
    public void searchItem(String arg0) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homepage.handleLocationAllow();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homepage.getElement(homepage.searchButton).click();

        searchResultPage.writeOnAElement(searchResultPage.searchProductInputBox,arg0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getDriver().hideKeyboard();
    }

    @And("Scroll down to an item and Open the Item screen")
    public void scrollDownToAnItemAndOpenTheItemScreen() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        searchResultPage.clickOnElement(searchResultPage.product);
    }
    @And("Click the Plus + icon three times to add to the cart")
    public void clickThePlusIconThreeTimesToAddToTheCart() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productDetailsPage.clickOnElement(productDetailsPage.addCartButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productDetailsPage.clickOnElement(productDetailsPage.addCartButton1);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productDetailsPage.clickOnElement(productDetailsPage.addCartButton1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productDetailsPage.clickOnElement(productDetailsPage.closeButton);
    }

    @And("Go to the cart screen from the top")
    public void goToTheCartScreenFromTheTop() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        searchResultPage.clickOnElement(searchResultPage.shoppingBagButton);
    }

    @When("Click the Minus - icon to empty the cart")
    public void clickTheMinusIconToEmptyTheCart() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
           }
        shoppingBagPage.clickOnElement(shoppingBagPage.productMinusButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shoppingBagPage.clickOnElement(shoppingBagPage.productMinusButton);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shoppingBagPage.clickOnElement(shoppingBagPage.productMinusButton);

    }

    @Then("Verify Text {string} on cart screen after removing items")
    public void verifyTextOnCartScreenAfterRemovingItems(String arg0) {
        Assert.assertTrue(shoppingBagPage.isElementVisible(shoppingBagPage.bodyText));
        Assert.assertEquals(shoppingBagPage.getElementText(shoppingBagPage.bodyText),arg0);
    }


}
