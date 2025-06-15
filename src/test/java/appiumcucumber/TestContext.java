package appiumcucumber;

import io.appium.java_client.AppiumDriver;

public class TestContext {
    private AppiumDriver driver;

    public TestContext() {
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }
}
