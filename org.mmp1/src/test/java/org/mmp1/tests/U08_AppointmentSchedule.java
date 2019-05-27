package org.mmp1.tests;

import static org.testng.Assert.assertTrue;
import org.mmp1.methods.MMPLogin;
import org.mmp1.methods.ScheduleAppointment;
import org.mmp1.methods.UserHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class U08_AppointmentSchedule extends TestBase{

	@Parameters({ "MMPUrl", "Username", "Password","Doctor","Date","Time" })
	@Test
	public void scheduleAppointment(String MMPUrl, String username, String password, String doctor, String date, String time) throws Exception{
		
		MMPLogin userLogin1 = new MMPLogin(driver);	
		UserHomePage userHome = new UserHomePage(driver);
		ScheduleAppointment appointment = new ScheduleAppointment(driver);
		
		userLogin1.launchApplication(MMPUrl);
		boolean flag= userLogin1.userLogin(username, password);
		assertTrue(flag);
	    userHome.clickLink("Schedule");
	    appointment.clickNewAppointmentLink();
	    appointment.selectDoctor(doctor);
		appointment.selectDate(date);
		appointment.selectTime(time);
		String symptoms= appointment.enterSymptoms();
		String[] appointmentDetails = appointment.verifyPatientPortalTable();
		SoftAssert sa = new SoftAssert();
	    sa.assertTrue(appointmentDetails[0].contains(date), "Incorrect date displayed");
	    sa.assertTrue(appointmentDetails[1].contains(time), "Incorrect time displayed");
	    sa.assertTrue(appointmentDetails[2].contains(symptoms), "Incorrect symptoms displayed");
	    sa.assertTrue(doctor.contains(appointmentDetails[3]), "Incorrect doctor displayed");
	    
	    userHome.clickLink("Schedule");
	    String scheduleDate = appointment.verifyScheduleDate();
	    String scheduleTime = appointment.verifyScheduleDetails("Time");
	    String scheduleProvider = appointment.verifyScheduleDetails("Provider");
	    String scheduleSymptoms = appointment.verifyScheduleDetails("Symptoms");
	    String scheduleProvider1[] = scheduleProvider.split(":");
	    sa.assertTrue(scheduleDate.contains(date), "Incorrect date displayed");
	    sa.assertTrue(scheduleTime.contains(time), "Incorrect time displayed");
	    sa.assertTrue(scheduleSymptoms.contains(symptoms), "Incorrect symptoms displayed");
	    sa.assertTrue(doctor.contains(scheduleProvider1[1]), "Incorrect doctor displayed");
	    sa.assertAll();
	}
}
