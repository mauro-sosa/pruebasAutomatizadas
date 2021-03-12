// http://demo.guru99.com/test/newtours/index.php Test

package com.qualitystream.tutorial;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class MercuryTour_AutomatedTest {
	
	private WebDriver driver;
	
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//a[@href='register.php']");
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPassworLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("submit");
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("submit");
	
	
    By homePageLocator = By.xpath("//img[@src='/images/hdr_right.gif']");
	
	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
	System.setProperty("webdriver.chrome.whitelistedIps", "");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://demo.guru99.com/test/newtours/index.php");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		
		if (driver.findElement(registerPageLocator).isDisplayed()) {
		driver.findElement(usernameLocator).sendKeys("qualityadminmauro@gmail.com");
		driver.findElement(passwordLocator).sendKeys("pass1");
		driver.findElement(confirmPassworLocator).sendKeys("pass1");
		driver.findElement(registerBtnLocator).click();
		System.out.println(" registro correcto ");
		
		}
		
		else {
			
			System.out.println(" registro incorrecto ");
		}
		
		

		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is qualityadminmauro@gmail.com.",fonts.get(5).getText());

		
		}
	
	@Test
	public void signIn() throws InterruptedException {
		if(driver.findElement(userLocator).isDisplayed()){
			driver.findElement(userLocator).sendKeys("qualityadminmauro@gmail.com");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			//assertTrue(driver.findElement(homePageLocator).isDisplayed());
			System.out.println("login correcto");
		}
		else
			System.out.println("login incorrecto");

}}
