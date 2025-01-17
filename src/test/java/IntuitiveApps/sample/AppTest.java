package IntuitiveApps.sample;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppTest {
    private AndroidDriver driver;
    private AppiumDriverLocalService service;

    @BeforeTest
    public void setup() {
        final String MAIN_JS_PATH = System.getProperty("user.home")+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        final String APPIUM_HOME = "C:\\Users\\USER\\AppData\\Roaming\\npm\\node_modules\\appium"; // Custom Appium home directory
        final String IP_Address = "192.168.31.103";
        final int PORT = 4723;

        Map<String, String> env = new HashMap<String, String>();
        env.put("APPIUM_HOME", APPIUM_HOME);
        // Start the Appium server
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(MAIN_JS_PATH))
                .withIPAddress(IP_Address)
                .usingPort(PORT)
                .withArgument(() -> "--base-path", "status") // Optional: Define base path
                .withEnvironment(env) // Set custom Appium home
                .build();
 //       service.start(); // Ensure the service starts

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("ANDROID");
        options.setAutomationName("UIAutomator2");
      //  options.setDeviceName("R58N345JQXY");
        options.setDeviceName("emulator-5554");// Replace with actual device name from `adb devices`
        options.setApp("D:\\eclipse-workspace\\FacePe\\resources\\ApiDemos-debug.apk"); // Path to your app

        try {
            // Ensure the driver is created after the service starts
            driver = new AndroidDriver(new URL("http://" + IP_Address + ":" + PORT), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
        
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    }

    @Test
    public void appiumTest() {
        // Your test code goes here
        System.out.println("Appium test started...");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
    //        driver.quit(); // Close the driver to free resources
        }
        if (service != null && service.isRunning()) {
            service.stop(); // Stop the service
        }
    }
    
    
}
