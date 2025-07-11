package appiumcucumber.kabum.steps;

import appiumcucumber.TestContext;
import appiumcucumber.kabum.actions.AddProductToCartActions;

import io.cucumber.java.en.*;

public class AddProductToCartSteps {

    private final AddProductToCartActions addProductToCartActions;

    public AddProductToCartSteps(TestContext context) {
        this.addProductToCartActions = new AddProductToCartActions(context.getDriver());
    }

    @Given("I am on the Kabum homepage")
    public void i_am_on_the_kabum_homepage() {
        addProductToCartActions.closePromo();
    }
    @Given("I search for {string}")
    public void i_search_for(String product) {
        addProductToCartActions.searchProduct(product);
    }
    @When("I select the product {string} from the results")
    public void i_select_the_product_desired_from_the_results(String product) {
        addProductToCartActions.addProductToCart(product);
        addProductToCartActions.enterInCart();
    }
    @Then("the product should be added to the shopping cart")
    public void the_product_should_be_added_to_the_shopping_cart() {
        addProductToCartActions.verifyCart();
    }
}
