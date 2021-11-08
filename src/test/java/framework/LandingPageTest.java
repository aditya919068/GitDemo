package framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class LandingPageTest extends base{
	public WebDriver driver;
	Logger log=LogManager.getLogger(LandingPageTest.class.getName());
	LandingPage homepage;

	@BeforeTest
	public void initialization() throws IOException {
		driver=initializeDriver();
		log.info("Driver was initialized");
		driver.get(prop.getProperty("url"));
		log.info("URL got established");
	}
	
	@Test
	public void titleVerification() {
		homepage=new LandingPage(driver);
		String text=homepage.gettitle().getText();
		Assert.assertEquals(text, "FEATURED COURSES");
		log.info("Text Matched");
	}
	
	@Test
	public void navigationbarVerification() throws IOException {
		homepage=new LandingPage(driver);
		boolean visibilityofNavigationBar=homepage.navigationbar().isDisplayed();
		Assert.assertTrue(visibilityofNavigationBar);
		log.info("Navigation bar was displayed");
		System.out.println("These are the git changes made 2");
	}
	
	@Test
	public void FailedTestcaseVerification() throws IOException {
		homepage=new LandingPage(driver);
		boolean visibilityofNavigationBar=homepage.navigationbar().isDisplayed();
		Assert.assertFalse(visibilityofNavigationBar);
		log.info("Testcase Failed on purpose");
		System.out.println("These are the git changes made 3");
	}
	
	@AfterTest
	public void termination() {
	driver.close();	
	log.info("Driver terminated");
	}
}
