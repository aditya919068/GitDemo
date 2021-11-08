package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By emailID=By.xpath( "//input[@id='user_email']");
	By password=By.xpath("//input[@id='user_password']");
	By submit=By.xpath("//input[@class='btn btn-primary btn-md login-button']");



public WebElement getEmail() {
	return driver.findElement(emailID);
}

public WebElement getpassword() {
	return driver.findElement(password);
}

public WebElement submitbutton() {
	return driver.findElement(submit);
}


}
