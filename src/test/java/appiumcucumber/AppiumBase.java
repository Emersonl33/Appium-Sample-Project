package appiumcucumber;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;

public class AppiumBase {

    public AppiumDriver setUpAppium() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "br.com.kabum.webviewapp");
        caps.setCapability("appium:appActivity", "br.com.kabum.webviewapp.MainActivity");
        caps.setCapability("appium:autoGrantPermissions", "true");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
