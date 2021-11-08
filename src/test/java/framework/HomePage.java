package framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	Logger log=LogManager.getLogger(HomePage.class.getName());
	
@BeforeTest
public void initialization() throws IOException {
	driver=initializeDriver();
	log.info("Driver was initialized");
	
}
	
@DataProvider
public Object[][] getdata(){
	Object[][] data=new Object[2][2];
	data[0][0]= "restricted user";
	data[0][1]= "Password123";
	data[1][0]= "Permanent user";
	data[1][1]= "Password12345";
	return data;
}
	
	
	
	
	@Test(dataProvider="getdata")
	public void HomePageNavigation(String username, String Password) {
		
		driver.get(prop.getProperty("url"));
		log.info("URL got launched");
		LandingPage homepage=new LandingPage(driver);
		homepage.getLogin().click();
		log.info("Login got clicked");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.getEmail().sendKeys(username);
		loginpage.getpassword().sendKeys(Password);
		loginpage.submitbutton().click();
		log.info("UserName and password was submitted");
	}

	@AfterTest
	public void termination() {
	driver.close();	
	log.info("Driver Terminated");
	}

}


