package org.mmp1.methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Symptoms {

	WebDriver driver;

	public Symptoms(WebDriver driver) {
		this.driver = driver;
	}
	
public boolean searchForSymptom(String symptom)
{ 	 boolean flag = false;
	 driver.findElement(By.id("search")).sendKeys(symptom);
	 driver.findElement(By.xpath("//input[@value='Search']")).click();
	 List<WebElement> symptomsList = driver.findElements(By.xpath("//div[@id='show']/table/tbody/tr"));
	 int size = symptomsList.size();
	 for (int i=0; i<size;i++)
	 {
		 symptomsList.get(i).getText().contains(symptom);
		 flag = true;
	 }
	 return flag;	
}
}
