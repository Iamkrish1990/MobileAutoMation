package testBase;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBaseForMoileBrowser {
	
	public TestBaseForMoileBrowser() {
		
	}
	
public AndroidDriver<AndroidElement> initialization() throws MalformedURLException {
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Krishnendu PC\\\\Desktop\\\\SoftwareForAutomation\\\\chromedriver.exe");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "J8AAGF09B240VS8");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.VERSION, "9");
		cap.setCapability(MobileCapabilityType.BROWSER_VERSION, "78.0.3904");
		//Set ChromeDriver location
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub") , cap);
		return driver;
	}

}
