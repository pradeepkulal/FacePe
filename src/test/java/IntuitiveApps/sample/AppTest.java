package IntuitiveApps.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppTest {
	@Test
	public void appiumTest() {
		UiAutomator2Options options =  new UiAutomator2Options();
		options.setDeviceName("R58N345JQXY");
		options.setApp("D:\\eclipse-workspace\\FacePe\\resources\\General-Store.apk");
		AndroidDriver driver;
		try {
			driver =  new AndroidDriver(new URL("http://0.0.0.0:4723"),options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}