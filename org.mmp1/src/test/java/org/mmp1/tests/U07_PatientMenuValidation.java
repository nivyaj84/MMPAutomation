package org.mmp1.tests;

import static org.testng.Assert.assertTrue;
import org.mmp1.methods.MMPLogin;
import org.mmp1.methods.UserHomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class U07_PatientMenuValidation extends TestBase {
	String messagePageTitleText;
	String actualTitle;
	SoftAssert sa = new SoftAssert();
	
	@Parameters({ "MMPUrl", "Username", "Password" })
	@BeforeMethod
	public void login(String MMPUrl, String username, String password) throws Exception
	{	MMPLogin userLogin1 = new MMPLogin(driver);
		userLogin1.launchApplication(MMPUrl);
		boolean flag = userLogin1.userLogin(username, password);
		assertTrue(flag);
	}
	
	@AfterMethod
	public void logout()
	{UserHomePage userHome = new UserHomePage(driver);
		userHome.clickLink("Logout");
	}

	/*@Test
public void verifyProfile() 
{UserHomePage userHome = new UserHomePage(driver);
		userHome.clickLink("Profile");
		messagePageTitleText= userHome.verifyPageTitleText();
		sa.assertEquals(messagePageTitleText, "Personal Details", "Profile Page Title text is incorrect");
		actualTitle = userHome.verifyPageTitle();
		sa.assertEquals(actualTitle, "profile", "Page Title is incorrect");
}*/
	
	@Test
	public void verifyScheduleAppointment() 
	{UserHomePage userHome = new UserHomePage(driver);
		userHome.clickLink("Schedule Appointment");
		messagePageTitleText= userHome.verifyPageTitleText();
		sa.assertEquals(messagePageTitleText, "Current Appointments", "Schedule Page Title text is incorrect");
		actualTitle = userHome.verifyPageTitle();
		sa.assertEquals(actualTitle, "Shedule Appointments", "Schedule Page Title is incorrect");
	}
	
	@Test
	public void verifyInformation() 
	{UserHomePage userHome = new UserHomePage(driver);
		userHome.clickLink("Information");
		messagePageTitleText= userHome.verifyPageTitleText();
		sa.assertEquals(messagePageTitleText, "Information", "  Information Page Title text is incorrect");
		actualTitle = userHome.verifyPageTitle();
		sa.assertEquals(actualTitle, "information", "Information Page Title is incorrect");
	}	

	@Test
	public void verifyFees() 
	{UserHomePage userHome = new UserHomePage(driver);
		userHome.clickLink("Fees");
		messagePageTitleText= userHome.verifyPageTitleText();
		sa.assertEquals(messagePageTitleText, "Fees", "Fees Page Title text is incorrect");
		actualTitle = userHome.verifyPageTitle();
		sa.assertEquals(actualTitle, "fees", "Fees Page Title is incorrect");
	}
	
	@Test
	public void verifySearchSymptoms() 
	{UserHomePage userHome = new UserHomePage(driver);
		userHome.clickLink("Search Symptoms");
		messagePageTitleText= userHome.verifyPageTitleText();
		sa.assertEquals(messagePageTitleText, "Search Symptoms", "Search Symptoms Page Title text is incorrect");
		actualTitle = userHome.verifyPageTitle();
		sa.assertEquals(actualTitle, "search Symptoms", "Search Symptoms Page Title is incorrect");
	}
	
	
	@Test
	public void verifyMessages() 
	{	UserHomePage userHome = new UserHomePage(driver);
		userHome.clickLink("Messages");
		messagePageTitleText= userHome.verifyPageTitleText();
		sa.assertEquals(messagePageTitleText, "Messages", "Message Page Title text is incorrect");
		actualTitle = userHome.verifyPageTitle();
		sa.assertEquals(actualTitle, "Send Messages", "Page Title is incorrect");
	}

}
