package org.mmp1.methods;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OfficePatient {
	WebDriver driver;
	By searchTextbox = By.id("search");
	By searchButton = By.xpath("//input[@value='search']");
	By clickPatient = By.xpath("//div[@id='show']/table/tbody/tr/td[1]/a");
	By createFeeButton = By.xpath("//input[@value='Create Fee']");
	By appointmentDropdown = By.id("app_date");
	By serviceDropdown = By.id("service");
	By submitButton = By.xpath("//input[@value='submit']");

	public OfficePatient(WebDriver driver) {
		this.driver = driver;
	}

	public void searchPatient(String patientSSN) {
		driver.findElement(searchTextbox).sendKeys(patientSSN);
		driver.findElement(searchButton).click();
		driver.findElement(clickPatient).click();
	}

	public String generateFee() {
		driver.findElement(createFeeButton).click();
		WebElement e = driver.findElement(appointmentDropdown);
		Select s = new Select(e);
		/*
		 * List<WebElement> appointmentList = s.getOptions(); int limit=
		 * appointmentList.size(); int index=
		 * RandomNumberString.getRandonNum(limit);
		 */
		s.selectByIndex(0);
		WebElement e1 = driver.findElement(serviceDropdown);
		Select s1 = new Select(e1);
		List<WebElement> serviceList = s1.getOptions();
		int limit = serviceList.size();
		int index = RandomNumberString.getRandonNum(limit);
		s1.selectByIndex(index);
		driver.findElement(submitButton).click();
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertMessage;
	}
}
