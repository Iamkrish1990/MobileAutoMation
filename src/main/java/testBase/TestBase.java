package testBase;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	
	
	public TestBase() 
	{
		
	}
	
	public void initialization() throws MalformedURLException {
		
		File f = new File("F:\\\\FinalProjectFolder\\\\MobileAutomation\\\\src\\\\test\\\\resources\\\\original.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_29_x86");
		cap.setCapability(MobileCapabilityType.APP, f.getPath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub") , cap);
		
	}

}
