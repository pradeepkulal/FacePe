package IntuitiveApps.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppTest {
    private AndroidDriver driver;

    @BeforeTest
    public void setup() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("R58N345JQXY"); // Replace with your device name
        options.setApp("D:\\eclipse-workspace\\FacePe\\resources\\General-Store.apk"); // Path to your app

        try {
            driver = new AndroidDriver(new URL("http://192.168.31.103:4723/"), options); // Ensure correct URL format
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }

    @Test
    public void appiumTest() {
        // Your test code goes here
        System.out.println("Appium test started...");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
        //    driver.quit(); // Close the driver to free resources
        }
    }
}
