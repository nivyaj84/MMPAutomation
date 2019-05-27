package org.mmp1.tests;


import java.util.HashMap;
import java.util.Map;
import org.mmp1.methods.MMPLogin;
import org.mmp1.methods.MMPRegister;
import org.mmp1.methods.ProfileValidation;
import org.mmp1.methods.MMPOffice;
import org.mmp1.methods.UserHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class U11_Registration extends TestBase {

	public Map<String, String> userInfo1 = new HashMap<String, String>();

	@Parameters({ "MMPUrl", "adminUsername", "adminPassword" })
	@Test
	public void TC_validateRegistrationAndProfile(String MMPUrl, String adminUsername,
			String adminPassword) throws Exception {

		MMPOffice admin = new MMPOffice(driver);
		ProfileValidation userProfile = new ProfileValidation(driver);
		MMPLogin userLogin1 = new MMPLogin(driver);
		MMPRegister user= new MMPRegister(driver);
		UserHomePage userHome= new UserHomePage(driver);
		SoftAssert sa= new SoftAssert();
		
		/* Launch MMP application and click on Register button */
		user.clickRegisterLink(MMPUrl);
		userInfo1=user.enterUserInfo();
		boolean flag = user.verifyTitle("NAMTG");
		sa.assertTrue(flag, "UnSuccessful registration");

		/* Login into Admin application */
		admin.adminLogin(MMPUrl, adminUsername, adminPassword);

		/* Approve new user from Admin application */
		admin.adminApprove(userInfo1.get("FirstName"));

		/* Login using New user credentials */
		userLogin1.launchApplication(MMPUrl);
		flag = userLogin1.userLogin(userInfo1.get("Username"), userInfo1.get("Password"));
		sa.assertTrue(flag,"UnSuccessful with new user credentials");
		String userName1 = userHome.verifyProfileName();
		sa.assertEquals(userName1, userInfo1.get("Username"), "Incorrect Username");

		/* Verifying user information in user profile */
		userHome.clickLink("Profile");
		Boolean Flag=userProfile.TC_01_verifyProfileInfo(userInfo1);
        sa.assertTrue(Flag);
        
        sa.assertAll();
	}

}
