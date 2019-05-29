package org.mmp1.methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//Adding a comment
public class MMPRegister{
	 WebDriver driver;
	 public Map<String, String> userInfo = new HashMap<String, String>();
	 
	 By registerButton = By.xpath("//div/a[@class='button button-alt'][contains(text(),'Register')]");
	 By firstNameTextbox= By.id("firstname");
	 By lastNameTextbox=By.id("lastname");
	 By dateOfbirthTextbox = By.id("datepicker");
	 By licenseTextbox= By.id("license");
	 By ssnTextbox= By.id("ssn");
	 By stateTextbox= By.id("state");
	 By cityTextbox= By.id("city");
	 By addressTextbox= By.id("address");
	 By	zipCodeTextbox=By.id("zipcode");
	 By	ageTextbox=By.id("age");
	 By	heightTextbox=By.id("height");
	 By	weightTextbox=By.id("weight");
	 By	pharmacyTextbox=By.id("pharmacy");
	 By pharmacyAddressTextbox= By.id("pharma_adress");
	 By emailTextbox=By.id("email");
	 By userNameTextbox=By.id("username");
	 By securityQuestionDropdown=By.id("security");
	 By passwordTextbox= By.id("password");
	 By confirmpasswordTextbox= By.id("confirmpassword");
	 By securityAnswerTextbox= By.id("answer");
	 By saveButton=By.name("register");
	 
	public	MMPRegister(WebDriver driver)
	{
		this.driver=driver;
	}
	
public void clickRegisterLink(String MMPUrl) throws Exception {
		
		driver.get(MMPUrl);
		driver.findElement(registerButton).click ();
}
	
	public Map<String,String> enterUserInfo()
	{
		/* Generating random string for first name */
		String fName = RandomNumberString.getRandomString(5, 1);
		driver.findElement(firstNameTextbox).sendKeys(fName);
		userInfo.put("FirstName", fName);

		/* Generating random string for last name */
		String lName = RandomNumberString.getRandomString(5, 1);
		driver.findElement(lastNameTextbox).sendKeys(lName);
		userInfo.put("LastName", lName);

		/* Generating random string for date */
		String dateOfBirth = RandomNumberString.getRandonNum(31) + "/" + RandomNumberString.getRandonNum(12) + "/"
				+ RandomNumberString.getRandonNumber(4);
		driver.findElement(dateOfbirthTextbox).sendKeys(dateOfBirth);
		userInfo.put("Date", dateOfBirth);

		/* Generating random string for license */
		int license = RandomNumberString.getRandonNumber(8);
		driver.findElement(licenseTextbox).sendKeys(String.valueOf(license));
		userInfo.put("License", String.valueOf(license));

		/* Generating random string for ssn */
		int ssn = RandomNumberString.getRandonNumber(9);
		driver.findElement(ssnTextbox).sendKeys(String.valueOf(ssn));
		userInfo.put("SSN", String.valueOf(ssn));

		/* Generating random string for state */
		String state = RandomNumberString.getRandomString(5, 1);
		driver.findElement(stateTextbox).sendKeys(state);
		userInfo.put("State", state);

		/* Generating random string for city */
		String city = RandomNumberString.getRandomString(5, 1);
		driver.findElement(cityTextbox).sendKeys(city);
		userInfo.put("City", city);

		/* Generating random string for address */
		String address = RandomNumberString.getRandonNumber(4) + " " + RandomNumberString.getRandomString(5, 1);
		driver.findElement(addressTextbox).sendKeys(address);
		userInfo.put("Address", address);

		/* Generating random string for zipcode */
		int zipCode = RandomNumberString.getRandonNumber(5);
		driver.findElement(zipCodeTextbox).sendKeys(String.valueOf(zipCode));
		userInfo.put("Zipcode", String.valueOf(zipCode));

		/* Generating random string for age */
		int age = RandomNumberString.getRandonNumber(2);
		driver.findElement(ageTextbox).sendKeys(String.valueOf(age));
		userInfo.put("Age", String.valueOf(age));

		/* Generating random string for height */
		int height = RandomNumberString.getRandonNumber(2);
		driver.findElement(heightTextbox).sendKeys(String.valueOf(height));
		userInfo.put("Height", String.valueOf(height));

		/* Generating random string for weight */
		int weight = RandomNumberString.getRandonNumber(2);
		driver.findElement(weightTextbox).sendKeys(String.valueOf(weight));
		userInfo.put("Weight", String.valueOf(weight));

		/* Generating random string for pharmacy */
		String pharmacy = RandomNumberString.getRandomString(5, 1);
		driver.findElement(pharmacyTextbox).sendKeys(pharmacy);
		userInfo.put("Pharmacy", pharmacy);

		/* Generating random string for pharmacy address */
		String pharmacyAddress = RandomNumberString.getRandonNumber(4) + " " + RandomNumberString.getRandomString(5, 1);
		driver.findElement(pharmacyAddressTextbox).sendKeys(pharmacyAddress);
		userInfo.put("PharmacyAddress", pharmacyAddress);

		/* Generating random string for email */
		String email = RandomNumberString.getRandomString(5, 1) + RandomNumberString.getRandonNumber(1) + "@gmail.com";
		driver.findElement(emailTextbox).sendKeys(email);
		userInfo.put("Email", email);

		/* Generating random string for username */
		String userName = RandomNumberString.getRandomString(4, 1) + RandomNumberString.getRandonNumber(1);
		driver.findElement(userNameTextbox).sendKeys(userName);
		userInfo.put("Username", userName);

		/* Selecting from dropdown by sending size as argument */
		WebElement securityDropdown = driver.findElement(securityQuestionDropdown);
		Select s = new Select(securityDropdown);
		List<WebElement> securityList = s.getOptions();
		int size = securityList.size();
		s.selectByIndex(RandomNumberString.getRandonNum(size));

		/* Generating random string for password */
		String password = RandomNumberString.getRandomString(7, 1) + RandomNumberString.getRandonNumber(2);
		driver.findElement(passwordTextbox).sendKeys(password);
		userInfo.put("Password", password);

		/* Same random string for confirm Password */
		driver.findElement(confirmpasswordTextbox).sendKeys(password);
		userInfo.put("ConfirmPassword", password);

		/* Generating random string for security answer */
		String securityAnswer = RandomNumberString.getRandonNumber(4) + " " + RandomNumberString.getRandomString(5, 1);
		driver.findElement(securityAnswerTextbox).sendKeys(securityAnswer);
		
		/* Printing the keys and values */
		System.out.println("New user details:");
		Set<String> set = userInfo.keySet();
		for (String s1 : set) {
			System.out.println(s1 + ":" + userInfo.get(s1));
		}
		
		driver.findElement(saveButton).click();
		driver.switchTo().alert().accept();
		return userInfo;
	}
	 public boolean verifyTitle(String expectedTitle)
	 {   Boolean flag= false;
		 String actualTitle = driver.getTitle();
		 if (actualTitle.equalsIgnoreCase(expectedTitle))
		 {
			 flag= true;
		 }
		 return flag;
	 }
}
