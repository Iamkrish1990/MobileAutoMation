package sampleTestCase;

import testBase.TestBase;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static java.time.Duration.ofSeconds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragAndDrop  extends TestBase{
	
	AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		driver = initialization();
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void executeTest()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		TouchAction t = new TouchAction(driver);
		WebElement circle_1=driver.findElement(By.xpath("(//android.view.View)[1]"));
		WebElement circle_2=driver.findElement(By.xpath("(//android.view.View)[2]"));
		t.longPress(longPressOptions().withElement(element(circle_1)).withDuration(ofSeconds(3))).moveTo(element(circle_2)).release().perform();
		//t.longPress(element(circle_1)).moveTo(element(circle_2)).release().perform();
	}
	
	@AfterTest
	public void tearDown() {
		
	}
	
	

}
