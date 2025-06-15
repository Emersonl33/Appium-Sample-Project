package appiumcucumber.kabum.actions;

import appiumcucumber.Utils;
import appiumcucumber.kabum.pages.CartPage;
import appiumcucumber.kabum.pages.HomePage;
import io.appium.java_client.AppiumDriver;

public class AddProductToCartActions {

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
        homePage.searchBarInput.sendKeys(product);
        utils.scrollDownUntilVisible(homePage.gpuProductLabel);
        utils.waitForElement(homePage.gpuProductLabel);
        productName = homePage.gpuProductLabel.getText();
    }

    public void addProductToCart(){
        utils.waitForElement(homePage.addGpuProductButton);
        homePage.addGpuProductButton.click();
    }

    public void verifyCart(){
        utils.scrollDownUntilVisible(homePage.cartMenuButton);
        utils.waitForElement(homePage.cartMenuButton);
        homePage.cartMenuButton.click();

        utils.waitForElement(cartPage.descriptionProductLabel);
        String productLabel = cartPage.descriptionProductLabel.getText();

        if (productName == null || !productLabel.contains(productName)) {
            throw new AssertionError("🛑 Products in the cart do not match the product added.\nExpected: " + productName + "\nFound: " + productLabel);
        }
    }
}
