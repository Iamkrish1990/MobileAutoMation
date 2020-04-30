package hybridTestCases;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import testBase.TestBaseForHybridApp;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class Hybrid_Example_6 extends TestBaseForHybridApp{
	
	AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		driver = initialization();
	}
	
	@Test
	public void executeTest() throws InterruptedException
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
		try {
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike Blazer Mid '77\"))");
           
        }catch(Exception e) {
            System.out.println("We got an error scrolling!");
        }
		System.out.println("1st scrolling successful");
		
		int sizeOfProducts = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		System.out.println(sizeOfProducts);
		String productName=null;
		
		for(int i=0;i<sizeOfProducts;i++)
		{
			productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		
			if(productName.equals("Nike Blazer Mid '77"))
			{
				By xpathVar=By.xpath("(//android.widget.TextView[@text=\'ADD TO CART\'])[" + i + 1 + "]");
				
				driver.findElement(xpathVar).click();
				System.out.println("xpath displayed as true ");
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		WebElement checkBox = driver.findElement(By.xpath("//android.widget.CheckBox"));
		t.tap(tapOptions().withElement(element(checkBox))).perform();
		WebElement termsAndCondition = driver.findElement(By.xpath("//android.widget.TextView[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(termsAndCondition)).withDuration(ofSeconds(3))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Visit to the website to complete purchase']")).click();
		Thread.sleep(7000);
		Set<String> contexts = driver.getContextHandles();
		for(String context:contexts)
		{
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello" , Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
	}

}
