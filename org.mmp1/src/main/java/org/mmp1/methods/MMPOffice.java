package org.mmp1.methods;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MMPOffice {
    WebDriver driver;
    By officeLoginButton= By.xpath("//div/a[@class='button'][contains(text(),'Login')][1]");
    By adminUsernameTextbox= By.id("username");
    By adminPasswordTextbox= By.id("password");
    By adminSignInButton= By.xpath("//input[@name='admin']");

	public MMPOffice(WebDriver driver) {
		this.driver=driver;
	}

	public void adminLogin(String MMPUrl, String adminUsername, String adminPassword) {
		driver.get(MMPUrl);
		driver.findElement(officeLoginButton).click();
		driver.findElement(adminUsernameTextbox).sendKeys(adminUsername);
		driver.findElement(adminPasswordTextbox).sendKeys(adminPassword);
		driver.findElement(adminSignInButton).click();
	}
	
	public void clickMenuLink(String linkName) {
		driver.findElement(By.xpath("//span[contains(text(),'" + linkName + "')]")).click();
	}


	public void adminApprove(String firstName) throws Exception {
		driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();
		WebElement status_dropdown = driver.findElement(By.id("search"));
		Select select_status = new Select(status_dropdown);
		select_status.selectByVisibleText("Pending");
		Thread.sleep(2000);
		List<WebElement> pending_user_list = driver.findElements(By.xpath("//div[@id='show']/table/tbody/tr/td[1]"));
		int user_count = pending_user_list.size();
		for (int i = 0; i < user_count; i++) {
			String temp_name = pending_user_list.get(i).getText();
			if (temp_name.equalsIgnoreCase(firstName)) {
				System.out.println("User " + firstName + " found in User list");
				driver.findElement(By.xpath("//a[contains(text(),'" + firstName + "')]")).click();
				status_dropdown = driver.findElement(By.id("sapproval"));
				select_status = new Select(status_dropdown);
				select_status.selectByVisibleText("Accepted");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				driver.switchTo().alert().dismiss();
			} 
		}
	}
}
