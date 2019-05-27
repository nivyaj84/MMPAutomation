package org.mmp1.methods;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHomePage {

	WebDriver driver;
	By profileNameText= By.xpath("//h3[@class='page-header']");
	By patientPortalHeading = By.xpath("//table[@class='table']/thead");
	By pageTitleText= By.xpath("//div[@class='panel-heading']/h3");

	public UserHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyProfileName() {
		String userName1 = driver.findElement(profileNameText).getText();
		return userName1;
	}
	
	public void clickLink(String linkName) {
		driver.findElement(By.xpath("//span[contains(text(),'" + linkName + "')]")).click();
	}
	
	public String verifyPageTitleText()
	{	String pageTitleText = driver.findElement(By.xpath("//div[@class='panel-heading']/h3")).getText();
	return pageTitleText;
		
	}
	
	public String verifyPageTitle()
	{
		String pageTitle = driver.getTitle();
		return pageTitle;
	}


	public String[] verifyPatientPortalColumn() {
		List<WebElement> list = driver.findElements(patientPortalHeading);
		String strOfWordsHeader = list.get(0).getText();
		String[] headerNames = strOfWordsHeader.split(" ");
		for (String eachWord : headerNames) {
			System.out.println(eachWord);
		}
		return headerNames;
	}

	public boolean verifyPatientPortalColumnName(int numberOfColumns, String columnName) {
		boolean flag = false;
		List<WebElement> list = driver.findElements(patientPortalHeading);
		String strOfWordsHeader = list.get(0).getText();
		String[] headerNames = strOfWordsHeader.split(" ");
		for (int i = 0; i < numberOfColumns; i++) {
			if (headerNames[i].equalsIgnoreCase(columnName)) {
				flag = true;
				System.out.println("Column exists");
			} else
				continue;
		}
		return flag;
	}

}
