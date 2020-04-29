package sampleTestCase;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import testBase.TestBase;

public class SwipeGestureExample extends TestBase{
	
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
		WebElement exList = driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']");
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		//Tap - Gesture 1
		t.tap(tapOptions().withElement(element(exList))).perform();
		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		driver.findElement(By.xpath("//*[@content-desc='9']")).click();
		WebElement number_15=driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement number_45=driver.findElement(By.xpath("//*[@content-desc='45']"));
		//Gesture 2 : swipe - longpress-> move to 2nd element
		t.longPress(longPressOptions().withElement(element(number_15)).withDuration(ofSeconds(5))).moveTo(element(number_45)).release().perform();
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}


}
