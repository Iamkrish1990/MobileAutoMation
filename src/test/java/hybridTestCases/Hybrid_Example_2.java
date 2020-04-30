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

public class Hybrid_Example_2 extends TestBaseForHybridApp{
	
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
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String flag=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals(flag, "Please enter your name");
	}
	

}
