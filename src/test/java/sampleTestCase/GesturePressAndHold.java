package sampleTestCase;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import testBase.TestBase;

public class GesturePressAndHold extends TestBase{
	
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
		WebElement exList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		//Tap - Gesture 1
		t.tap(tapOptions().withElement(element(exList))).perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		WebElement pn=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		//Longpress - Gesture 2
		t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag =driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed();
		Assert.assertTrue(flag, "sample menu is not displayed");
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}


}
