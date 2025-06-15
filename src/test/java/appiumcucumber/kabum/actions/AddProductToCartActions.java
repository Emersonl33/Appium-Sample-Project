package appiumcucumber.kabum.actions;

import appiumcucumber.Utils;
import appiumcucumber.kabum.pages.CartPage;
import appiumcucumber.kabum.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

public class AddProductToCartActions{

    HomePage homePage;
    CartPage cartPage;
    Utils utils;
    String productName;

    public AddProductToCartActions(AppiumDriver driver) {
        this.homePage = new HomePage(driver);
        this.cartPage = new CartPage(driver);
        this.utils = new Utils(driver);
    }

    public void closePromo(){
        utils.waitForElement(homePage.buildPcCloseButton);
        homePage.buildPcCloseButton.click();
    }

    public void searchProduct(String product){
        utils.waitForElement(homePage.searchBarInput);
        homePage.searchBarInput.click();
        utils.retrySendKeys(homePage.searchBarTextInput, product, homePage);
    }

    public void addProductToCart(String product){
        Supplier<WebElement> productLabelSupplier = () -> homePage.getProductLabel(product);
        utils.scrollDownUntilVisible(productLabelSupplier);
        utils.waitForElement(productLabelSupplier.get());
        productName = homePage.getProductLabel(product).getText();
        homePage.getProductLabel(product).click();
        homePage.addGpuProductButton.click();
    }

    public void enterInCart(){
        utils.refreshByPullDown();
        homePage.cartMenuButton.click();
    }

    public void verifyCart() {
        String productLabel = null;
        int maxAttempts = 3;
        int attempt = 0;

        while (attempt < maxAttempts) {
            try {
                WebElement label = cartPage.getDescriptionProductLabel();
                utils.waitForElement(label);
                productLabel = label.getText();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("🔄 Attempt " + (attempt + 1) + ": stale element, retrying...");
                attempt++;
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        }
        if (productLabel == null) {
            throw new RuntimeException("❌ Failed to retrieve the product description from the cart after all attempts.");
        }

        if (productName == null || !productLabel.contains(productName)) {
            throw new AssertionError("🛑 Products in the cart do not match the product added.\nExpected: " + productName + "\nFound: " + productLabel);
        }
    }
}
