package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By signin=By.xpath( "//a[@href='https://rahulshettyacademy.com/sign_in/']");
	By title=By.xpath( "//section/div/div[@class='text-center']/h2");
	By navigationBar=By.xpath( "//ul[@class='nav navbar-nav navbar-right']");



public WebElement getLogin() {
	return driver.findElement(signin);
}

public WebElement gettitle() {
	return driver.findElement(title);
}

public WebElement navigationbar() {
	return driver.findElement(navigationBar);
}

}
