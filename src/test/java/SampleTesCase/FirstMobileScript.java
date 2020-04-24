package SampleTesCase;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class FirstMobileScript extends TestBase{

	@BeforeMethod
	public void setUp() throws MalformedURLException
	{
		initialization();
	}
	
	@BeforeTest
	public void before()
	{
		
	}
	
	@Test
	public void executeTest()
	{
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}

	
	
}
