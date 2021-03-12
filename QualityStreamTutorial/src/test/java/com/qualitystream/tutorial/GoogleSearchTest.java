package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchTest {

private WebDriver driver;	
	
@Before 	
public void setUp() {
	
	System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
	System.setProperty("webdriver.chrome.whitelistedIps", "");
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.google.com");
}

@Test
public void TestGooglePage() {
	
	
	WebElement searchbox = driver.findElement(By.name("q"));
			searchbox.clear();
			searchbox.sendKeys(" fc barcelona canal oficial ");
			searchbox.submit();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			assertEquals(" fc barcelona canal oficial ", driver.getTitle());
}

@After
public void tearDown() {
	
	driver.quit();
	
}

}
