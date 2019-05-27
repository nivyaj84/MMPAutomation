package org.mmp1.tests;

import static org.testng.Assert.assertTrue;
import org.mmp1.methods.MMPLogin;
import org.mmp1.methods.UserHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class U06_PatientApointmentTableInvalidColumn extends TestBase{
	
	@Parameters({"url","username","password","column_name"})
	@Test
	public void verifyColumnExists(String url,String username,String password, String columnName) throws Exception
	{
		MMPLogin userlogin1 = new MMPLogin(driver);
		UserHomePage userHome= new UserHomePage(driver);
		userlogin1.launchApplication(url);
		userlogin1.userLogin(username, password);
		String[] headerNames= userHome.verifyPatientPortalColumn();
		int numberOfColumns= headerNames.length;
		Boolean Flag = userHome.verifyPatientPortalColumnName(numberOfColumns,columnName);
		assertTrue(Flag);
	}
}
