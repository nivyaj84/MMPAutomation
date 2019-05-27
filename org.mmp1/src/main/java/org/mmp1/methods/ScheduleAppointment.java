package org.mmp1.methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointment {
	WebDriver driver;
	By createNewAppoimntmentButton = By.xpath("//input[@type='submit']");
	By bookAppointment = By.xpath("//table/tbody/tr/td[1]/button");
	By date = By.id("datepicker");
	By dateFrame= By.id("myframe");
	By calenderYearText = By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]");
	By nextArrowButton= By.xpath("//*[@id='ui-datepicker-div']/div/a[2]");
	By calenderMonthText = By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]");
	By calender= By.xpath("//*[@id='ui-datepicker-div']/table");
	By timeDropdown= By.id("time");
	By continueButton= By.id("ChangeHeatName");
	By symptomsTextbox= By.id("sym");
	By submitButton= By.xpath("//input[@type='submit']");
	By patientPortalFirstRow= By.xpath("//table[@class='table']/tbody/tr[1]");
	By appointmentDate = By.xpath("//div[@class='col-md-3']/div/div/h3");

	public ScheduleAppointment(WebDriver driver) {
		this.driver = driver;
	}

	public void clickNewAppointmentLink() {
		driver.findElement(createNewAppoimntmentButton).click();
	}

	public void selectDoctor(String doctor) {
		driver.findElement(bookAppointment).click();
		driver.findElement(By.xpath("//h4[contains(text(),'"+doctor+"')]/ancestor::ul/following-sibling::Button"));
	}

	public void selectDate(String dateToSelect) throws Exception {
		WebElement e = driver.findElement(dateFrame);
		driver.switchTo().frame(e);
		driver.findElement(date).click();
		String date, month, year;
		String calDate, calMonth, calYear;
		String arr[] = dateToSelect.split("/");
		month = arr[0];
		date = arr[1];
		year = arr[2];
		int month1 = Integer.parseInt(month);
		calYear = driver.findElement(calenderYearText).getText();
		System.out.println(calYear);
		while (!calYear.equals(year)) {
			driver.findElement(nextArrowButton).click();
			calYear = driver.findElement(calenderYearText).getText();
		}
		calMonth = driver.findElement(calenderMonthText).getText();
		System.out.println(calMonth);
		String month2 = getMonth(month1);
		System.out.println(month2);
		while (!calMonth.equalsIgnoreCase(month2)) {
			driver.findElement(nextArrowButton).click();
			calMonth = driver.findElement(calenderMonthText).getText();
		}
		Thread.sleep(3000);
		WebElement cal = driver.findElement(calender);

		Thread.sleep(3000);
		List<WebElement> cols = null;
		List<WebElement> rows = cal.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		int size = rows.size();
		for (int i = 0; i < size; i++) {
			cols = rows.get(5).findElements(By.tagName("td"));
			int size1 = cols.size();
			for (int j = 0; j < size1; j++) {
				calDate = cols.get(j).getText();
				if (calDate.equals(date)) {
					cols.get(j).click();
					break;
				}

			}
		}
	}

	public void selectTime(String time) throws Exception {
		WebElement e1 = driver.findElement(timeDropdown);
		e1.click();
		Select s = new Select(e1);
		s.selectByVisibleText("10Am");
		//String timeOption= e1.getAttribute(arg0);
		Thread.sleep(2000);
		driver.findElement(continueButton).click();

	}

	public String enterSymptoms() {
		String symptoms= (RandomNumberString.getRandomString(8, 1));
		driver.findElement(symptomsTextbox).sendKeys(symptoms);
		driver.findElement(submitButton).click();
		return symptoms;
	}
	
	public String[] verifyPatientPortalTable(){
		List<WebElement> appointmentInfo = driver.findElements(patientPortalFirstRow);
		String strOfWords = appointmentInfo.get(0).getText();
		String[] appointmentDetails = strOfWords.split(" ");
		return appointmentDetails;
	}

	public String verifyScheduleDate()
	{
		String date = driver.findElement(appointmentDate).getText();
		return date;
	}

	public String verifyScheduleDetails(String detail)
	{
		String detailInfo = driver.findElement(By.xpath("//a[contains(text(),'"+detail+"')]")).getText();
		return detailInfo;
	}

	
	public String getMonth(int month) {

		String monthWords = "";
		switch (month) {
		case 1:
			monthWords = "January";
			break;
		case 2:
			monthWords = "February";
			break;
		case 3:
			monthWords = "March";
			break;
		case 4:
			monthWords = "April";
			break;
		case 5:
			monthWords = "May";
			break;
		case 6:
			monthWords = "June";
			break;
		case 7:
			monthWords = "July";
			break;
		case 8:
			monthWords = "August";
			break;
		case 9:
			monthWords = "September";
			break;
		case 10:
			monthWords = "October";
			break;
		case 11:
			monthWords = "November";
			break;
		case 12:
			monthWords = "December";
			break;
		}
		return monthWords;
	}
}
