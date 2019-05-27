package org.mmp1.tests;

import static org.testng.Assert.assertTrue;

import org.mmp1.methods.MMPLogin;
import org.mmp1.methods.Symptoms;
import org.mmp1.methods.UserHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class U15_SymptomsSearch extends TestBase{

	@Parameters({ "MMPUrl", "Username", "Password","Symptom"})
	@Test
	public void searchSymptoms(String MMPUrl, String username, String password, String symptom) throws Exception{
	
	MMPLogin userLogin1 = new MMPLogin(driver);	
	UserHomePage userHome = new UserHomePage(driver);
	Symptoms symptoms= new Symptoms(driver);
	
	SoftAssert sa = new SoftAssert();
	userLogin1.launchApplication(MMPUrl);
	boolean flag= userLogin1.userLogin(username, password);
	assertTrue(flag);
    userHome.clickLink("Search Symptoms");
    flag = symptoms.searchForSymptom(symptom);
    sa.assertTrue(flag, "Symptom not found");
	
	}
	
}
