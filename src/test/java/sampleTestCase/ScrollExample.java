package sampleTestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import testBase.TestBase;


public class ScrollExample extends TestBase{
	
	AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		driver = initialization();
	}
	
	@Test
	public void executeTest()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		//String webView = "webView";
		//MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator("new UIScrollable(new UISelector().scrollable(true)).scrollIntoView(" + "new UISelector().text(\"" + webView + "\"))"));
		//UiScrollable appView = new UiScrollable(new UiSelector().scrollable(true));
		try {
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
        }catch(Exception e) {
            System.out.println("We got an error scrolling!");
        }
	}

}
