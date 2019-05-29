package org.mmp1.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPLogin{
	WebDriver driver;
	By loginButton = By.xpath("//div/a[@class='button button-alt'][contains(text(),'Login')]");
	By usernameTextbox= By.name("username");
	By passwordTextbox= By.name("password");
	By loginOKButton = By.name("submit");
//Changes in MMP Branch
	public MMPLogin(WebDriver driver)
	{//Adding  a comment
		this.driver=driver;
	}
    
    public  void launchApplication(String url){
		driver.get(url);
    }

	public boolean userLogin(String username1,String password1) throws Exception{
		Boolean flag=false;
		driver.findElement(loginButton).click();
	    driver.findElement(usernameTextbox).sendKeys(username1);
		driver.findElement(passwordTextbox).sendKeys(password1);
		driver.findElement(loginOKButton).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "home";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{	flag=true;
			return flag;
		}
		else 
		return flag;
	}
}
