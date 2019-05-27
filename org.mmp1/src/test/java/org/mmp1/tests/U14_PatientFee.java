package org.mmp1.tests;

import org.mmp1.methods.MMPOffice;
import org.mmp1.methods.OfficePatient;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class U14_PatientFee extends TestBase {

	@Parameters({ "MMPUrl", "adminUsername", "adminPassword", "ssn" })
	@Test
	public void generateFee(String MMPUrl, String adminUsername, String adminPassword, String ssn) {

		MMPOffice admin = new MMPOffice(driver);
		OfficePatient patient = new OfficePatient(driver);

		SoftAssert sa = new SoftAssert();
		admin.adminLogin(MMPUrl, adminUsername, adminPassword);
		admin.clickMenuLink("Patients");
		patient.searchPatient(ssn);
		String alertMessage = patient.generateFee();
		sa.assertEquals(alertMessage, "Fee Successfully Entered.", "Fee not generated");
	}

}
