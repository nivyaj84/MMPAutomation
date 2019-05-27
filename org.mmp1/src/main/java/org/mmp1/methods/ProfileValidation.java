package org.mmp1.methods;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProfileValidation {
	By firstNameTextboxProfile = By.id("fname");
	By lastNameTextboxProfile= By.id("lname");
	By licenseTextboxProfile=By.id("licn");
	By ssnTextboxProfile= By.id("ssn");
	By addressTextboxProfile= By.id("addr");
	By ageTextboxProfile= By.id("age");
	By weightTextboxProfile=By.id("weight");
	By heightTextboxProfile=By.id("height");
	By cityTextboxProfile=By.id("city");
	By stateTextboxProfile=By.id("state");
	By zipTextboxProfile=By.id("zip");
	
	  WebDriver driver;
	public ProfileValidation(WebDriver driver) {
		this.driver=driver;
	}

	public boolean TC_01_verifyProfileInfo(Map<String, String> userInfo) throws Exception {
		
		Boolean flag= true;
		/* Comparing firstname from HashMap and textbox in Profile page */
		String fNameField = driver.findElement(firstNameTextboxProfile).getAttribute("value");
		String fNameMap = userInfo.get("FirstName");
		if(!(fNameField.equalsIgnoreCase(fNameMap))){
		flag= false;
		}

		/* Comparing lastname from HashMap and textbox in Profile page */
		String lNameField = driver.findElement(lastNameTextboxProfile).getAttribute("value");
		String lNameMap = userInfo.get("LastName");
		if(!(lNameField.equalsIgnoreCase(lNameMap))){
			flag= false;
		}

		/* Comparing license from HashMap and textbox in Profile page */
		String licenseField = driver.findElement(licenseTextboxProfile).getAttribute("value");
		String licenseMap = userInfo.get("License");
		if(!(licenseField.equalsIgnoreCase(licenseMap))){
			flag=false;
		}

		/* Comparing SSN from HashMap and textbox in Profile page */
		String ssnField = driver.findElement(ssnTextboxProfile).getAttribute("value");
		String ssnMap = userInfo.get("SSN");
		if(!(ssnField.equalsIgnoreCase(ssnMap))){
			flag=false;
		}

		/* Comparing Address from HashMap and textbox in Profile page */
		String addressField = driver.findElement(addressTextboxProfile).getAttribute("value");
		String addressMap = userInfo.get("Address");
		if(!(addressField.equalsIgnoreCase(addressMap))){
			flag=false;
		}

		/* Comparing Age from HashMap and textbox in Profile page */
		String ageField = driver.findElement(ageTextboxProfile).getAttribute("value");
		String ageMap = userInfo.get("Age");
		if(!(ageField.equalsIgnoreCase(ageMap))){
			flag=false;
		}

		/* Comparing Weight from HashMap and textbox in Profile page */
		String weightField = driver.findElement(weightTextboxProfile).getAttribute("value");
		String weightMap = userInfo.get("Weight");
		if(!(weightField.equalsIgnoreCase(weightMap))){
			flag=false;
		}

		/* Comparing Height from HashMap and textbox in Profile page */
		String heightField = driver.findElement(heightTextboxProfile).getAttribute("value");
		String heightMap = userInfo.get("Height");
		if(!(heightField.equalsIgnoreCase(heightMap))){
			flag=false;
		}


		/* Comparing Weight from HashMap and textbox in Profile page */
		String cityField = driver.findElement(cityTextboxProfile).getAttribute("value");
		String cityMap = userInfo.get("City");
		if(!(cityField.equalsIgnoreCase(cityMap))){
			flag=false;
		}

		/* Comparing State from HashMap and textbox in Profile page */
		String stateField = driver.findElement(stateTextboxProfile).getAttribute("value");
		String stateMap = userInfo.get("State");
		if(!(stateField.equalsIgnoreCase(stateMap))){
			flag=false;
		}

		/* Comparing Zipcode from HashMap and textbox in Profile page */
		String zipField = driver.findElement(zipTextboxProfile).getAttribute("value");
		String zipMap = userInfo.get("Zipcode");
		if(!(zipField.equalsIgnoreCase(zipMap))){
			flag=false;
		}

		return flag;
		
	}
}
	
	

