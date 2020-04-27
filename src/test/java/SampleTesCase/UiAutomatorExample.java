package SampleTesCase;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import testBase.TestBase;

public class UiAutomatorExample extends TestBase{
	
	AndroidDriver<AndroidElement> driver;
	

	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		driver = initialization();
		
	}
	
	@Test
	public void executeTest()
	{
		//driver.findElementByXPath("(//android.widget.Button)[1]").click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//System.out.println(driver.findElementsByAndroidUiAutomator(“new UI).size());
	}
	
	@AfterTest
	public void tearDown() {
		
	}

}
