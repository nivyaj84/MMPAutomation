package org.mmp1.tests;

import static org.testng.Assert.assertTrue;

import org.mmp1.methods.ExcelHelper;
import org.mmp1.methods.MMPLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class U03_LoginWithXlsx extends TestBase
{   
	MMPLogin userLogin1= new MMPLogin(driver);
 
    @Parameters({"url"})
	@Test(dataProvider="Authentication")
	 public void Registration_data(String url,String username,String password)throws  Exception
	{
		userLogin1.launchApplication(url);	
		Boolean flag= userLogin1.userLogin(username, password);
		assertTrue(flag);
	 }
   
	@DataProvider(name= "Authentication")
	 public String[][] Authentication() throws Exception
	{
	 
		String[][] testObjArray = ExcelHelper.ExcelData("F:\\Practice\\MMP\\Test.xlsx",0);
	         return (testObjArray);
	 
	 }
}
