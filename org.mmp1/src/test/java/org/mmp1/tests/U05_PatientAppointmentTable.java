package org.mmp1.tests;

import static org.testng.Assert.assertTrue;
import org.mmp1.methods.MMPLogin;
import org.mmp1.methods.UserHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class U05_PatientAppointmentTable extends TestBase{

	@Parameters({"url","username","password"})
	@Test
	public  void verifyPatientTable(String url,String username,String password) throws Exception
	{ 
		UserHomePage userHome= new UserHomePage(driver);
		MMPLogin userlogin1 = new MMPLogin(driver);
		userlogin1.launchApplication(url);
		Boolean flag=userlogin1.userLogin(username, password);
		assertTrue(flag);
	    String[] headreNames= userHome.verifyPatientPortalColumn();
	    SoftAssert sa = new SoftAssert();
	    sa.assertTrue(headreNames[0].contains("Date"), "Date is not displayed in header");
	    sa.assertTrue(headreNames[1].contains("Time"), "Time is not displayed in header");
	    sa.assertTrue(headreNames[2].contains("Appointment"), "Appointment is not displayed in header");
	    sa.assertTrue(headreNames[3].contains("Doctor"), "Doctor is not displayed in header");
	    sa.assertAll();
	}
}

