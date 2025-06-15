package appiumcucumber.kabum.actions;

import appiumcucumber.Utils;
import appiumcucumber.kabum.pages.CartPage;
import appiumcucumber.kabum.pages.HomePage;

public class AddProductToCartActions {

    HomePage homePage;
    CartPage cartPage;
    Utils utils;

    String productName;

    public void closePromo(){
        utils.waitForElement(homePage.buildPcCloseButton);
        homePage.buildPcCloseButton.click();
    }
    public void searchProduct(String product){
        utils.waitForElement(homePage.searchBarInput);
        homePage.searchBarInput.sendKeys(product);
        utils.scrollDownUntilVisible(homePage.gpuProductLabel);
        productName = homePage.gpuProductLabel.getText();
    }

    public void addProductToCart(){
        homePage.addGpuProductButton.click();
    }

    public void verifyCart(){
        utils.scrollDownUntilVisible(homePage.cartMenuButton);
        homePage.cartMenuButton.click();
        utils.waitForElement(cartPage.descriptionProductLabel);
        String productLabel = cartPage.descriptionProductLabel.getText();
        if(!productLabel.contains(productName)) {
            throw new AssertionError("Products in the cart are not the same as the products added.");
        }
    }
}
