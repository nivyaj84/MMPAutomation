package org.mmp1.tests;

import static org.testng.Assert.assertTrue;

import org.mmp1.methods.MMPLogin;
import org.mmp1.methods.MessageDetails;
import org.mmp1.methods.UserHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class U13_Message extends TestBase {

	@Parameters({ "MMPUrl", "Username", "Password" })
	@Test
	public void verifyMessage(String MMPUrl, String username, String password) throws Exception {
		MMPLogin userLogin1 = new MMPLogin(driver);
		UserHomePage userHome = new UserHomePage(driver);
		MessageDetails messageInfo = new MessageDetails(driver);

		SoftAssert sa = new SoftAssert();
		userLogin1.launchApplication(MMPUrl);
		boolean flag = userLogin1.userLogin(username, password);
		assertTrue(flag);
		userHome.clickLink("Messages");
		String confirmationPopUp = messageInfo.enterMessageDetails();
		sa.assertEquals(confirmationPopUp, "Messages Successfully sent.", "Message not succesfull");
	}
}
