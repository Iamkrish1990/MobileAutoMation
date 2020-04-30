package hybridTestCases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import testBase.TestBaseForHybridApp;


public class Hybrid_Sample_1 extends TestBaseForHybridApp{
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
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("hello");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).click();
		//  driver.findElement(By.xpath("//android.widget.Button[@text='Let's  Shop']")).click();
		try {
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
        }catch(Exception e) {
            System.out.println("We got an error scrolling!");
        }
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		boolean flag = driver.findElement(By.xpath("//android.widget.TextView[@text='Products']")).isDisplayed();
		Assert.assertTrue(flag, "Product page is not displayed");
		
	}
	

}
