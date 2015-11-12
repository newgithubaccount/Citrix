package TestClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;

import org.testng.annotations.Test;

import Utilities.SeleniumWrapper;
import pageobjects.MyWebinarSelection;
import pageobjects.ScheduleMeeting;
import pageobjects.WebinarLogin;

public class WebinarValidationTest {
	
	String userName=null;
	String password=null;
	public void loadProperties()
	{
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("./lib/env.properties");
			prop.load(input);
			userName=prop.getProperty("Username");
			password=prop.getProperty("Password");
			System.out.println(userName);
			System.out.println(password);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void validateWebinar()
	{
		loadProperties();
		//this flag helps to decide whether the given date is in current month or the date got moved to next month selection
		boolean flag = false;
		Calendar cal = Calendar.getInstance();
		int beforeDate=cal.get(Calendar.DATE);
		cal.add(Calendar.DATE, 3);
		int afterDate=cal.get(Calendar.DATE);	
		//if the date is greater than current date setting bollean flag to true to change the month field
		if(beforeDate>afterDate)
			 flag = true;
		//this method helps to launch the driver basing on the given browser type
		WebinarLogin webinarLogin=new WebinarLogin("chrome");
		//this method helps you to login in to the webinar application
		MyWebinarSelection myWebinarSelection=webinarLogin.login(userName, password);
		//helps to click on schedule meeting
		ScheduleMeeting scheduleMeeting=myWebinarSelection.clickschedulemeeting();	
		//helps for selection of the webinar date
		scheduleMeeting.selectWebinarDate(afterDate,flag);
		//helps to schedule the meeting
		myWebinarSelection=scheduleMeeting.schedule();
		//after scheduling the webinar moving to the scheduled webinars list
		myWebinarSelection.clickSchudledwebinars();
		//validating whether the given webinar is availabe in the list of webinars or not 
		myWebinarSelection.webinarDetails(afterDate,ScheduleMeeting.webinartile);
		//clocing the browser after validating the details
		myWebinarSelection.closeBrowser();		
	}

}
