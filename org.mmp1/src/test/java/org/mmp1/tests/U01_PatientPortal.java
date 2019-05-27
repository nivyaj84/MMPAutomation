package org.mmp1.tests;


import static org.testng.Assert.assertTrue;
import org.mmp1.methods.MMPLogin;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class U01_PatientPortal extends TestBase{

	@Parameters({"url","username","password"})
	@Test
	public void verifyPatientPortal(String url,String username,String password) throws Exception
	{
		MMPLogin userLogin1 = new MMPLogin(driver);
		userLogin1.launchApplication(url);
		Boolean flag= userLogin1.userLogin(username,password);
		assertTrue(flag, "Unsuccessful login");
	}
	

}
