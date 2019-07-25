package org.mmp1.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//modifing branch3
public class MessageDetails {
//modiying team_mmp branch
	WebDriver driver;
	By contactReasonTextbox = By.id("subject");
	By subjectTextbox = By.id("message");
	By sendButton = By.xpath("//input[@type='submit']");

	public MessageDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	public String enterMessageDetails() {
		String contactReason = RandomNumberString.getRandomString(6, 1);
		String subject = RandomNumberString.getRandomString(6, 1);
		driver.findElement(contactReasonTextbox).sendKeys(contactReason);
		driver.findElement(subjectTextbox).sendKeys(subject);
		driver.findElement(sendButton).click();
		String messageConfirmation = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return messageConfirmation;
	}
	
}
